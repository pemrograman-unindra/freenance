package unindra.modules.auth.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;
import java.math.BigDecimal; 

import unindra.core.DB;
import unindra.modules.auth.model.Analytic;
import unindra.modules.auth.model.User;

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
		String sql = "SELECT password FROM users WHERE username = ? or phone = ? or email = ? limit 1";
		try (ResultSet rs = DB.query(sql, username, username, username)) {
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
			DB.exec("INSERT INTO users (name, phone, email, username, password ) VALUES (?, ?, ?, ?, ?)", 
				user.getName(),
				user.getEmail(),
				user.getPhone(),
				user.getUsername(),
				hashedPassword
			);
		} catch (SQLException e) {
			throw new RuntimeException("Database error: " + e.getMessage(), e);
		}
	}

	public static Analytic getAnalytic() {
		Analytic res = new Analytic();
		res.setIncomeBudget(new BigDecimal(9300000));
		res.setExpenseBudget(new BigDecimal(7200000));
		res.setIncomeReal(new BigDecimal(10000000));
		res.setExpenseReal(new BigDecimal(7000000));
		res.setAssetBudget(new BigDecimal(15000000));
		res.setLiabilityBudget(new BigDecimal(5000000));
		res.setAssetReal(new BigDecimal(14500000));
		res.setLiabilityReal(new BigDecimal(4000000));
		return res;
	}

	public static void close() {
		System.exit(0);
	}
}
