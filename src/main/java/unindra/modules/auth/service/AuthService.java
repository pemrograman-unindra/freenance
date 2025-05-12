package unindra.modules.auth.service;

import unindra.core.DB;
import unindra.modules.auth.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

public class AuthService {
	public static boolean isUserExists() {
		String sql = "SELECT 1 FROM users limit 1";
		try (ResultSet rs = DB.query(sql)) {
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new RuntimeException("Database error: " + e.getMessage(), e);
		}		
	}

	public static void login(String username, String password) {
		String sql = "SELECT password FROM users WHERE username = ? limit 1";
		try (ResultSet rs = DB.query(sql, username)) {
			if (rs.next()) {
				String hashed = rs.getString("password");
				if (!BCrypt.checkpw(password, hashed)) {
					throw new RuntimeException("Username or password is not valid!");
				}
			} else {
				throw new RuntimeException("Username or password is not valid!");
			}
		} catch (SQLException e) {
			throw new RuntimeException("Database error: " + e.getMessage(), e);
		}
	}

	public static void register(User user) {
		try {
			String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
			DB.exec("INSERT INTO users (name, username, password, email, phone) VALUES (?, ?, ?, ?, ?)", 
				user.getName(),
				user.getUsername(),
				hashedPassword,
				user.getEmail(),
				user.getPhone()
			);
		} catch (SQLException e) {
			throw new RuntimeException("Database error: " + e.getMessage(), e);
		}
	}

	public static void close() {
		System.exit(0);
	}
}
