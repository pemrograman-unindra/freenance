package unindra.modules.transaction.core.service;

import unindra.core.DB;
import unindra.modules.transaction.core.model.Transaction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionService {

	public static void create(Transaction data) {
		try {
			DB.exec("INSERT INTO budgets (coa_id, period_start, period_end, amount) VALUES (?, ?, ?, ?)",

				data.getAmount()
			);
		} catch (SQLException e) {
			throw new RuntimeException("Create budget failed: " + e.getMessage(), e);
		}
	}

	public static List<Transaction> find(String keyword) {
		List<Transaction> list = new ArrayList<>();
		String text = "%"+ keyword +"%";
		try (ResultSet rs = DB.query("SELECT coa.name coa_name, b.* FROM budgets b JOIN chart_of_accounts coa on coa.id = b.coa_id WHERE coa.name like ?", text)) {
			while (rs.next()) {
				Transaction data = new Transaction();
				data.setId(rs.getInt("id"));
				data.setTrxDate(LocalDate.parse(rs.getString("trx_date")));
				data.setAmount(rs.getBigDecimal("amount"));
				list.add(data);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Get budget failed: " + e.getMessage(), e);
		}
		return list;
	}

	public static Transaction getByNumber(String number) {
		try (ResultSet rs = DB.query("SELECT coa.name coa_name, b.* FROM budgets b JOIN chart_of_accounts coa on coa.id = b.coa_id WHERE coa.name = ? and period_start = ? and period_end = ?", number)) {
			while (rs.next()) {
				Transaction data = new Transaction();
				data.setId(rs.getInt("id"));
				return data;
			}
		} catch (SQLException e) {
			throw new RuntimeException("Get budget failed: " + e.getMessage(), e);
		}
		throw new RuntimeException("Budget not found");
	}

	public static void update(Transaction data) {
		try {
			DB.exec("UPDATE budgets SET coa_id = ?, period_start = ?, period_end = ?, amount = ? WHERE id = ?",
				data.getAmount(),
				data.getId()
			);
		} catch (SQLException e) {
			throw new RuntimeException("Update budget failed: " + e.getMessage(), e);
		}
	}

	public static void delete(int id) {
		try {
			DB.exec("DELETE FROM budgets WHERE id = ?", id);
		} catch (SQLException e) {
			throw new RuntimeException("Delete budget failed: " + e.getMessage(), e);
		}
	}
}
