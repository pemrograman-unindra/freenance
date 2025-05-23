package unindra.modules.datastore.coa.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import unindra.core.DB;
import unindra.modules.datastore.coa.model.Coa;

public class CoaService {

	public static int create(Coa data) {
		int newId;
		try {
			newId = DB.exec(
					"INSERT INTO chart_of_accounts (parent_id, category_id, code, name, note, is_cash) VALUES (?, ?, ?, ?, ?, ?)",
					data.getParentId(),
					data.getCategoryId(),
					data.getCode(),
					data.getName(),
					data.getNote(),
					data.getIsCash());
		} catch (SQLException e) {
			throw new RuntimeException("Create chart of account failed: " + e.getMessage(), e);
		}
		return newId;
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

	public static Coa getByCode(int code) {
		Coa data = new Coa();
		try (ResultSet rs = DB.query(
				"SELECT parent.name parent_name, coa.* FROM chart_of_accounts coa left join chart_of_accounts parent on parent.id = coa.parent_id WHERE coa.code = ?",
				code)) {
			while (rs.next()) {
				data.setId(rs.getInt("id"));
				data.setParentId(rs.getInt("parent_id"));
				data.setParentName(rs.getString("parent_name"));
				data.setCategoryId(rs.getInt("category_id"));
				data.setCode(rs.getInt("code"));
				data.setName(rs.getString("name"));
				data.setNote(rs.getString("note"));
				data.setIsCash(rs.getBoolean("is_cash"));
				return data;
			}
		} catch (SQLException e) {
			throw new RuntimeException("Get chart of account failed: " + e.getMessage(), e);
		}
		throw new RuntimeException("Chart of account is not found");
	}

	public static List<Coa> find(String keyword, String type, int categoryId) {
		List<Coa> list = new ArrayList<>();
		String sql = "SELECT parent.name parent_name, coa.* FROM chart_of_accounts coa left join chart_of_accounts parent on parent.id = coa.parent_id WHERE coa.name like ?";
		if (type.equals("cash")) {
			sql += " and coa.is_cash = true";
		} else if (type.equals("parent")) {
			sql += " and exists (select 1 from chart_of_accounts child where child.parent_id = coa.id)";
		} else if (type.equals("child")) {
			sql += " and not exists (select 1 from chart_of_accounts child where child.parent_id = coa.id)";
		}
		if (categoryId > 0) {
			sql += " and coa.category_id = " + String.valueOf(categoryId);
		}
		sql += " order by coa.code";
		try (ResultSet rs = DB.query(sql, "%" + keyword + "%")) {
			while (rs.next()) {
				Coa data = new Coa();
				data.setId(rs.getInt("id"));
				data.setParentId(rs.getInt("parent_id"));
				data.setParentName(rs.getString("parent_name"));
				data.setCategoryId(rs.getInt("category_id"));
				data.setCode(rs.getInt("code"));
				data.setName(rs.getString("name"));
				data.setNote(rs.getString("note"));
				data.setIsCash(rs.getBoolean("is_cash"));
				list.add(data);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Get chart of account failed: " + e.getMessage(), e);
		}
		return list;
	}

	public static void update(Coa data) {
		try {
			DB.exec(
					"UPDATE chart_of_accounts SET parent_id = ?, category_id = ?, code = ?, name = ?, note = ?, is_cash = ? WHERE id = ?",
					data.getParentId(),
					data.getCategoryId(),
					data.getCode(),
					data.getName(),
					data.getNote(),
					data.getIsCash(),
					data.getId());
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
