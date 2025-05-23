package unindra.modules.transaction.core.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import unindra.core.DB;
import unindra.modules.transaction.core.model.Transaction;

public class TransactionService {

	public static void create(Transaction data) {
		try {
			int trxId = DB.exec("""
					INSERT INTO transactions (
						parent_id,
						project_id,
						contact_id,
						origin_coa_id,
						target_coa_id,
						trx_type,
						trx_no,
						trx_date,
						description,
						amount
					) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
					""",
					data.getParentId(),
					data.getProjectId(),
					data.getContactId(),
					data.getOriginCoaId(),
					data.getTargetCoaId(),
					data.getTrxType(),
					data.getTrxNumber(),
					data.getTrxDate(),
					data.getDescription(),
					data.getAmount());
			DB.exec("INSERT INTO journals (trx_id, coa_id, debit, credit) VALUES (?, ?, ?, ?)",
					trxId, data.getTargetCoaId(), data.getAmount(), 0);
			DB.exec("INSERT INTO journals (trx_id, coa_id, debit, credit) VALUES (?, ?, ?, ?)",
					trxId, data.getOriginCoaId(), 0, data.getAmount());
		} catch (SQLException e) {
			throw new RuntimeException("Create transaction failed: " + e.getMessage(), e);
		}
	}

	public static List<Transaction> find(String type, String keyword) {
		List<Transaction> list = new ArrayList<>();
		String sql = """
				SELECT
					parent.trx_no parent_number,
					p.project_no project_number,
					c.name contact_name,
					origin_coa.name origin_coa_name,
					target_coa.name target_coa_name,
					t.*
				FROM
					transactions t
					LEFT JOIN transactions parent on parent.id = t.parent_id
					LEFT JOIN projects p on p.id = t.project_id
					LEFT JOIN contacts c on c.id = t.contact_id
					LEFT JOIN chart_of_accounts origin_coa on origin_coa.id = t.origin_coa_id
					LEFT JOIN chart_of_accounts target_coa on target_coa.id = t.target_coa_id
				WHERE
					t.trx_type = ?
					AND t.trx_no like ?
				""";
		String text = "%" + keyword + "%";
		try (ResultSet rs = DB.query(sql, type, text)) {
			while (rs.next()) {
				Transaction data = new Transaction();
				data.setId(rs.getInt("id"));

				data.setParentId(rs.getInt("parent_id"));
				data.setParentNumber(rs.getString("parent_number"));
				data.setProjectId(rs.getInt("project_id"));
				data.setProjectNumber(rs.getString("project_number"));
				data.setContactId(rs.getInt("contact_id"));
				data.setContactName(rs.getString("contact_name"));
				data.setOriginCoaId(rs.getInt("origin_coa_id"));
				data.setOriginCoaName(rs.getString("origin_coa_name"));
				data.setTargetCoaId(rs.getInt("trx_date"));
				data.setTargetCoaName(rs.getString("target_coa_name"));
				data.setTrxType(rs.getString("trx_type"));
				data.setTrxNumber(rs.getString("trx_no"));
				data.setTrxDate(LocalDate.parse(rs.getString("trx_date")));
				data.setDescription(rs.getString("description"));
				data.setAmount(rs.getBigDecimal("amount"));
				list.add(data);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Get transaction failed: " + e.getMessage(), e);
		}
		return list;
	}

	public static Transaction getByNumber(String number) {
		String sql = """
					SELECT
						parent.trx_no parent_number,
						c.name contact_name,
						origin_coa_id.name origin_coa_name,
						target_coa_id.name target_coa_name,
						t.*
					FROM
						transactions t
						LEFT JOIN transactions parent on parent.id = t.parent_id
						LEFT JOIN contacts c on c.id = t.contact_id
						LEFT JOIN chart_of_accounts origin_coa on origin_coa.id = t.origin_coa_id
						LEFT JOIN chart_of_accounts target_coa on target_coa.id = t.target_coa_id
					WHERE
						t.trx_no = ?
				""";
		try (ResultSet rs = DB.query(sql, number)) {
			while (rs.next()) {
				Transaction data = new Transaction();
				data.setId(rs.getInt("id"));
				return data;
			}
		} catch (SQLException e) {
			throw new RuntimeException("Get transaction failed: " + e.getMessage(), e);
		}
		throw new RuntimeException("transaction not found");
	}

	public static void update(Transaction data) {
		try {
			DB.exec("""
					UPDATE transactions SET
						parent_id = ?
						project_id = ?
						contact_id = ?
						origin_coa_id = ?
						target_coa_id = ?
						trx_type = ?
						trx_no = ?
						trx_date = ?
						description = ?
						amount = ?
					WHERE
						id = ?
					""",
					data.getParentId(),
					data.getProjectId(),
					data.getContactId(),
					data.getOriginCoaId(),
					data.getTargetCoaId(),
					data.getTrxType(),
					data.getTrxNumber(),
					data.getTrxDate(),
					data.getDescription(),
					data.getAmount(),
					data.getId());
			DB.exec("DELETE FROM journals WHERE trx_id = ?", data.getId());
			DB.exec("INSERT INTO journals (trx_id, coa_id, debit, credit) VALUES (?, ?, ?, ?)",
					data.getId(), data.getTargetCoaId(), data.getAmount(), 0);
			DB.exec("INSERT INTO journals (trx_id, coa_id, debit, credit) VALUES (?, ?, ?, ?)",
					data.getId(), data.getOriginCoaId(), 0, data.getAmount());
		} catch (SQLException e) {
			throw new RuntimeException("Update transaction failed: " + e.getMessage(), e);
		}
	}

	public static void delete(int id) {
		try {
			DB.exec("DELETE FROM transactions WHERE id = ?", id);
			DB.exec("DELETE FROM journals WHERE trx_id = ?", id);
		} catch (SQLException e) {
			throw new RuntimeException("Delete transaction failed: " + e.getMessage(), e);
		}
	}
}
