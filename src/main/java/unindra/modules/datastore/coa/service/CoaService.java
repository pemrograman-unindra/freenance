package unindra.modules.datastore.coa.service;

import unindra.core.DB;
import unindra.modules.datastore.coa.model.Coa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoaService {

	public static void create(Coa coa) {
		try {
			DB.exec(
				"INSERT INTO chart_of_accounts (parent_id, category_id, code, name, note, is_cash) VALUES (?, ?, ?, ?, ?, ?)",
				coa.getParentId(),
				coa.getCategoryId(),
				coa.getCode(),
				coa.getName(),
				coa.getNote(),
				coa.getIsCash()
			);
		} catch (SQLException e) {
			throw new RuntimeException("Create chart of account failed: " + e.getMessage(), e);
		}
	}

	public static int nextCodeByParentId(int parentId) {
		String sql = "SELECT (coalesce(max(child.code), parent.code)+1) next_code FROM chart_of_accounts parent left join chart_of_accounts child on child.parent_id = parent.id WHERE parent.id = ? limit 1";
		try (ResultSet rs = DB.query(sql, parentId)) {
			while (rs.next()) {
				return rs.getInt("next_code");
			}
		} catch (SQLException e) {
			throw new RuntimeException("Get chart of account failed: " + e.getMessage(), e);
		}
		throw new RuntimeException("Parent is not found");
	}

	public static List<Coa> find(String keyword, String type, int categoryId) {
		List<Coa> chartOfAccounts = new ArrayList<>();
		String sql = "SELECT parent.name parent_name, coa.* FROM chart_of_accounts coa left join chart_of_accounts parent on parent.id = coa.parent_id WHERE coa.name like ?";
		if (type.equals("cash")) {
			sql += " and coa.is_cash = true";
		} else if (type.equals("parent")) {
			sql += " and exists (select 1 from chart_of_accounts child where child.parent_id = coa.id)";
		} else if (type.equals("child")) {
			sql += " and not exists (select 1 from chart_of_accounts child where child.parent_id = coa.id)";
		}
		if (categoryId>0) {
			sql += " and coa.category_id = "+String.valueOf(categoryId);
		}
		sql += " order by coa.code";
		try (ResultSet rs = DB.query(sql, "%"+ keyword +"%")) {
			while (rs.next()) {
				Coa coa = new Coa();
				coa.setId(rs.getInt("id"));
				coa.setParentId(rs.getInt("parent_id"));
				coa.setParentName(rs.getString("parent_name"));
				coa.setCategoryId(rs.getInt("category_id"));
				coa.setCode(rs.getInt("code"));
				coa.setName(rs.getString("name"));
				coa.setNote(rs.getString("note"));
				coa.setIsCash(rs.getBoolean("is_cash"));
				chartOfAccounts.add(coa);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Get chart of account failed: " + e.getMessage(), e);
		}
		return chartOfAccounts;
	}

	public static void update(Coa coa) {
		try {
			DB.exec(
				"UPDATE chart_of_accounts SET parent_id = ?, category_id = ?, code = ?, name = ?, note = ?, is_cash = ? WHERE id = ?",
				coa.getParentId(),
				coa.getCategoryId(),
				coa.getCode(),
				coa.getName(),
				coa.getNote(),
				coa.getIsCash(),
				coa.getId()
			);
		} catch (SQLException e) {
			throw new RuntimeException("Update chart of account failed: " + e.getMessage(), e);
		}
	}

	public static void delete(int id) {
		try {
			DB.exec("DELETE FROM chart_of_accounts WHERE id = ?", id);
		} catch (SQLException e) {
			throw new RuntimeException("Delete chart of account failed: " + e.getMessage(), e);
		}
	}
}
