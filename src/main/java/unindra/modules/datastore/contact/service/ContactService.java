package unindra.modules.datastore.contact.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import unindra.core.DB;
import unindra.modules.datastore.contact.model.Contact;

public class ContactService {

	public static void create(Contact data) {
		try {
			DB.exec("INSERT INTO contacts (name, phone, email, address) VALUES (?, ?, ?, ?)",
					data.getName(),
					data.getPhone(),
					data.getEmail(),
					data.getAddress());
		} catch (SQLException e) {
			throw new RuntimeException("Create contact failed: " + e.getMessage(), e);
		}
	}

	public static List<Contact> find(String keyword) {
		List<Contact> list = new ArrayList<>();
		String text = "%" + keyword + "%";
		try (ResultSet rs = DB.query("SELECT * FROM contacts WHERE name like ? or phone like ? or email like ?", text, text,
				text)) {
			while (rs.next()) {
				Contact data = new Contact();
				data.setId(rs.getInt("id"));
				data.setName(rs.getString("name"));
				data.setPhone(rs.getString("phone"));
				data.setEmail(rs.getString("email"));
				data.setAddress(rs.getString("address"));
				data.setBillCoaId(rs.getInt("bill_coa_id"));
				list.add(data);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Get contact failed: " + e.getMessage(), e);
		}
		return list;
	}

	public static Contact getByName(String name) {
		try (ResultSet rs = DB.query("SELECT * FROM contacts WHERE name = ?", name)) {
			while (rs.next()) {
				Contact data = new Contact();
				data.setId(rs.getInt("id"));
				data.setName(rs.getString("name"));
				data.setPhone(rs.getString("phone"));
				data.setEmail(rs.getString("email"));
				data.setAddress(rs.getString("address"));
				return data;
			}
		} catch (SQLException e) {
			throw new RuntimeException("Get contact failed: " + e.getMessage(), e);
		}
		throw new RuntimeException("contact not found");
	}

	public static void update(Contact data) {
		try {
			DB.exec("UPDATE contacts SET name = ?, phone = ?, email = ?, address = ? WHERE id = ?",
					data.getName(),
					data.getPhone(),
					data.getEmail(),
					data.getAddress(),
					data.getId());
		} catch (SQLException e) {
			throw new RuntimeException("Update contact failed: " + e.getMessage(), e);
		}
	}

	public static void delete(int id) {
		try {
			DB.exec("DELETE FROM contacts WHERE id = ?", id);
		} catch (SQLException e) {
			throw new RuntimeException("Delete contact failed: " + e.getMessage(), e);
		}
	}
}
