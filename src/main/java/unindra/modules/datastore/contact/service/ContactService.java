package unindra.modules.datastore.contact.service;

import unindra.core.DB;
import unindra.modules.datastore.contact.model.Contact;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactService {

	public static void create(Contact contact) {
		try {
			DB.exec(
				"INSERT INTO contacts (name, phone, email, address) VALUES (?, ?, ?, ?)",
				contact.getName(),
				contact.getPhone(),
				contact.getEmail(),
				contact.getAddress()
			);
		} catch (SQLException e) {
			throw new RuntimeException("Create contact failed: " + e.getMessage(), e);
		}
	}

	public static List<Contact> find(String keyword) {
		List<Contact> contacts = new ArrayList<>();
                String text = "%"+ keyword +"%";
		try (ResultSet rs = DB.query("SELECT * FROM contacts WHERE name like ? or phone like ? or email like ?", text, text, text)) {
			while (rs.next()) {
				Contact contact = new Contact();
				contact.setId(rs.getInt("id"));
				contact.setName(rs.getString("name"));
				contact.setPhone(rs.getString("phone"));
				contact.setEmail(rs.getString("email"));
				contact.setAddress(rs.getString("address"));
				contacts.add(contact);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Get contact failed: " + e.getMessage(), e);
		}
		return contacts;
	}

	public static void update(Contact contact) {
		try {
			DB.exec(
				"UPDATE contacts SET name = ?, phone = ?, email = ?, address = ? WHERE id = ?",
				contact.getName(),
				contact.getPhone(),
				contact.getEmail(),
				contact.getAddress(),
				contact.getId()
			);
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
