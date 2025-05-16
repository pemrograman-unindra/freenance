package unindra.modules.datastore.project.service;

import unindra.core.DB;
import unindra.modules.datastore.project.model.Project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectService {

	public static void create(Project data) {
		try {
			DB.exec("""
				INSERT INTO projects (customer_id, code, name, description, start_date, due_date, end_date, budget)
				VALUES (?, ?, ?, ?, ?, ?, ?, ?)
				""",
				data.getCustomerId(),
				data.getCode(),
				data.getName(),
				data.getDescription(),
				data.getStartDate(),
				data.getDueDate(),
				data.getEndDate(),
				data.getBudget()
			);
		} catch (SQLException e) {
			throw new RuntimeException("Create project failed: " + e.getMessage(), e);
		}
	}

	public static List<Project> find(String keyword) {
		List<Project> list = new ArrayList<>();
		String text = "%"+ keyword +"%";
		try (ResultSet rs = DB.query("SELECT * FROM projects WHERE code LIKE ? OR name LIKE ? OR description LIKE ?", text, text, text)) {
			while (rs.next()) {
				Project data = new Project();
				data.setId(rs.getInt("id"));
				data.setCustomerId(rs.getObject("customer_id") != null ? rs.getInt("customer_id") : null);
				data.setCode(rs.getString("code"));
				data.setName(rs.getString("name"));
				data.setDescription(rs.getString("description"));
				data.setStartDate(rs.getDate("start_date") != null ? rs.getDate("start_date").toLocalDate() : null);
				data.setDueDate(rs.getDate("due_date") != null ? rs.getDate("due_date").toLocalDate() : null);
				data.setEndDate(rs.getDate("end_date") != null ? rs.getDate("end_date").toLocalDate() : null);
				data.setBudget(rs.getBigDecimal("budget"));
				data.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
				data.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
				list.add(data);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Get project failed: " + e.getMessage(), e);
		}
		return list;
	}

	public static void update(Project data) {
		try {
			DB.exec("UPDATE projects SET customer_id = ?, code = ?, name = ?, description = ?, start_date = ?, due_date = ?, end_date = ?, budget = ?, updated_at = CURRENT_TIMESTAMP WHERE id = ?",
				data.getCustomerId(),
				data.getCode(),
				data.getName(),
				data.getDescription(),
				data.getStartDate(),
				data.getDueDate(),
				data.getEndDate(),
				data.getBudget(),
				data.getId()
			);
		} catch (SQLException e) {
			throw new RuntimeException("Update project failed: " + e.getMessage(), e);
		}
	}

	public static void delete(int id) {
		try {
			DB.exec("DELETE FROM projects WHERE id = ?", id);
		} catch (SQLException e) {
			throw new RuntimeException("Delete project failed: " + e.getMessage(), e);
		}
	}
}
