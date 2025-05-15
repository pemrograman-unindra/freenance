package unindra.modules.datastore.coa.service;

import unindra.core.DB;
import unindra.modules.datastore.coa.model.Coa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoaService {

	public void create(Coa coa) {
		try {
			DB.exec(
				"INSERT INTO chart_of_accounts (parent_id, category_id, code, name, is_cash) VALUES (?, ?, ?, ?, ?)",
				coa.getParentId(),
				coa.getCategoryId(),
				coa.getCode(),
				coa.getName(),
				coa.getIsCash()
			);
		} catch (SQLException e) {
			throw new RuntimeException("Create chart of account failed: " + e.getMessage(), e);
		}
	}

	public int nextCodeByParentId(int parentId) {
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

	public List<Coa> find(String keyword) {
		List<Coa> chartOfAccounts = new ArrayList<>();
		try (ResultSet rs = DB.query("SELECT parent.name parent_name, coa.* FROM chart_of_accounts coa left join chart_of_accounts parent on parent.id = coa.parent_id WHERE coa.name like ? order by coa.code", "%"+ keyword +"%")) {
			while (rs.next()) {
				Coa coa = new Coa();
				coa.setId(rs.getInt("id"));
				coa.setParentId(rs.getInt("parent_id"));
				coa.setParentName(rs.getString("parent_name"));
				coa.setCategoryId(rs.getInt("category_id"));
				coa.setCode(rs.getInt("code"));
				coa.setName(rs.getString("name"));
				coa.setIsCash(rs.getBoolean("is_cash"));
				chartOfAccounts.add(coa);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Get chart of account failed: " + e.getMessage(), e);
		}
		return chartOfAccounts;
	}

	public void update(Coa coa) {
		try {
			DB.exec(
				"UPDATE chart_of_accounts SET parent_id = ?, category_id = ?, code = ?, name = ?, is_cash = ? WHERE id = ?",
				coa.getParentId(),
				coa.getCategoryId(),
				coa.getCode(),
				coa.getName(),
				coa.getIsCash(),
				coa.getId()
			);
		} catch (SQLException e) {
			throw new RuntimeException("Update chart of account failed: " + e.getMessage(), e);
		}
	}

	public void delete(int id) {
		try {
			DB.exec("DELETE FROM chart_of_accounts WHERE id = ?", id);
		} catch (SQLException e) {
			throw new RuntimeException("Delete chart of account failed: " + e.getMessage(), e);
		}
	}
}
