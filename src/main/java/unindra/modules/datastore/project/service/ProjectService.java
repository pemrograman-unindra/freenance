package unindra.modules.datastore.project.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import unindra.core.DB;
import unindra.modules.datastore.project.model.Project;

public class ProjectService {

	public static void create(Project data) {
		try {
			DB.exec(
					"INSERT INTO projects (customer_id, project_no, name, description, start_date, due_date, end_date, amount) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
					data.getCustomerId(),
					data.getNumber(),
					data.getName(),
					data.getDescription(),
					data.getStartDate(),
					data.getDueDate(),
					data.getEndDate(),
					data.getAmount());
		} catch (SQLException e) {
			throw new RuntimeException("Create project failed: " + e.getMessage(), e);
		}
	}

	public static List<Project> find(String keyword) {
		List<Project> list = new ArrayList<>();
		String text = "%" + keyword + "%";
		try (ResultSet rs = DB.query(
				"SELECT c.name customer_name, p.* FROM projects p LEFT JOIN contacts c on c.id = p.customer_id WHERE p.project_no LIKE ? OR p.name LIKE ? OR p.description LIKE ?",
				text, text, text)) {
			while (rs.next()) {
				Project data = new Project();
				data.setId(rs.getInt("id"));
				data.setCustomerId(rs.getObject("customer_id") != null ? rs.getInt("customer_id") : null);
				data.setNumber(rs.getString("project_no"));
				data.setName(rs.getString("name"));
				data.setDescription(rs.getString("description"));
				if (rs.getString("start_date") != null) {
					data.setStartDate(LocalDate.parse(rs.getString("start_date")));
				}
				if (rs.getString("due_date") != null) {
					data.setDueDate(LocalDate.parse(rs.getString("due_date")));
				}
				if (rs.getString("end_date") != null) {
					data.setEndDate(LocalDate.parse(rs.getString("end_date")));
				}
				data.setAmount(rs.getBigDecimal("amount"));
				data.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
				data.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
				list.add(data);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Get project failed: " + e.getMessage(), e);
		}
		return list;
	}

	public static Project getByNumber(String number) {
		try (ResultSet rs = DB.query(
				"SELECT c.name customer_name, p.* FROM projects p LEFT JOIN contacts c on c.id = p.customer_id WHERE p.project_no = ?",
				number)) {
			while (rs.next()) {
				Project data = new Project();
				data.setId(rs.getInt("id"));
				data.setCustomerId(rs.getObject("customer_id") != null ? rs.getInt("customer_id") : 0);
				data.setCustomerName(rs.getString("customer_name"));
				data.setNumber(rs.getString("project_no"));
				data.setName(rs.getString("name"));
				data.setDescription(rs.getString("description"));
				if (rs.getString("start_date") != null) {
					data.setStartDate(LocalDate.parse(rs.getString("start_date")));
				}
				if (rs.getString("due_date") != null) {
					data.setDueDate(LocalDate.parse(rs.getString("due_date")));
				}
				if (rs.getString("end_date") != null) {
					data.setEndDate(LocalDate.parse(rs.getString("end_date")));
				}
				data.setAmount(rs.getBigDecimal("amount"));
				data.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
				data.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
				return data;
			}
		} catch (SQLException e) {
			throw new RuntimeException("Get project failed: " + e.getMessage(), e);
		}
		throw new RuntimeException("Project not found");
	}

	public static void update(Project data) {
		try {
			DB.exec(
					"UPDATE projects SET customer_id = ?, project_no = ?, name = ?, description = ?, start_date = ?, due_date = ?, end_date = ?, amount = ?, updated_at = CURRENT_TIMESTAMP WHERE id = ?",
					data.getCustomerId(),
					data.getNumber(),
					data.getName(),
					data.getDescription(),
					data.getStartDate(),
					data.getDueDate(),
					data.getEndDate(),
					data.getAmount(),
					data.getId());
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
