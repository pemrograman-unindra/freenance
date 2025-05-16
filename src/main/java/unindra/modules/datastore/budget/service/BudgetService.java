package unindra.modules.datastore.budget.service;

import unindra.core.DB;
import unindra.modules.datastore.budget.model.Budget;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BudgetService {

	public static void create(Budget data) {
		try {
			DB.exec("INSERT INTO budgets (coa_id, period_start, period_end, amount) VALUES (?, ?, ?, ?)",
				data.getCoaId(),
				data.getPeriodStart(),
				data.getPeriodEnd(),
				data.getAmount()
			);
		} catch (SQLException e) {
			throw new RuntimeException("Create budget failed: " + e.getMessage(), e);
		}
	}

	public static List<Budget> find(String keyword) {
		List<Budget> list = new ArrayList<>();
								String text = "%"+ keyword +"%";
		try (ResultSet rs = DB.query("SELECT coa.name coa_name, b.* FROM budgets b JOIN chart_of_accounts coa on coa.id = b.coa_id WHERE coa.name like ?", text)) {
			while (rs.next()) {
				Budget data = new Budget();
				data.setId(rs.getInt("id"));
				data.setCoaId(rs.getInt("coa_id"));
				data.setCoaName(rs.getString("coa_name"));
				data.setPeriodStart(LocalDate.parse(rs.getString("period_start")));
				data.setPeriodEnd(LocalDate.parse(rs.getString("period_end")));
				data.setAmount(rs.getBigDecimal("amount"));
				list.add(data);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Get budget failed: " + e.getMessage(), e);
		}
		return list;
	}

	public static void update(Budget data) {
		try {
			DB.exec("UPDATE budgets SET coa_id = ?, period_start = ?, period_end = ?, amount = ? WHERE id = ?",
				data.getCoaId(),
				data.getPeriodStart(),
				data.getPeriodEnd(),
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
