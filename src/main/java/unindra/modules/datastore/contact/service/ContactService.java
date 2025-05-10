package unindra.modules.datastore.contact.service;

import unindra.core.DB;
import unindra.modules.datastore.contact.model.Contact;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactService {

	public void createContact(Contact contact) {
		try {
			DB.exec(
				"INSERT INTO contacts (code, name, phone, email, address) VALUES (?, ?, ?, ?, ?)",
				contact.getCode(),
				contact.getName(),
				contact.getPhone(),
				contact.getEmail(),
				contact.getAddress()
			);
		} catch (SQLException e) {
			throw new RuntimeException("Create contact failed: " + e.getMessage(), e);
		}
	}

	public List<Contact> getContacts(String search) {
		List<Contact> contacts = new ArrayList<>();
		try (ResultSet rs = DB.query("SELECT * FROM contacts WHERE name like ?", "%"+ search +"%")) {
			while (rs.next()) {
				Contact contact = new Contact();
				contact.setId(rs.getInt("id"));
				contact.setCode(rs.getString("code"));
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

	public void updateContact(Contact contact) {
		try {
			DB.exec(
				"UPDATE contacts SET code = ?, name = ?, phone = ?, email = ?, address = ? WHERE id = ?",
				contact.getCode(),
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

	public void deleteContact(int id) {
		try {
			DB.exec("DELETE FROM contacts WHERE id = ?", id);
		} catch (SQLException e) {
			throw new RuntimeException("Delete contact failed: " + e.getMessage(), e);
		}
	}
}
