package unindra.modules.auth.service;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

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
					hashedPassword);
		} catch (SQLException e) {
			throw new RuntimeException("Database error: " + e.getMessage(), e);
		}
	}

	public static Analytic getAnalytic(String dateStart, String dateEnd) {
		Analytic analytic = new Analytic();
		// asset & liability real
		try (ResultSet rs = DB.query("""
				SELECT
					coa.category_id category_id,
					sum(j.debit-j.credit) amount
				FROM
					journals j
					JOIN transactions t on t.id = j.trx_id
					JOIN chart_of_accounts coa on coa.id = j.coa_id
				WHERE
					coa.category_id in (1, 2)
					AND t.trx_date <= ?
				GROUP BY
					coa.category_id
				""", dateEnd)) {
			while (rs.next()) {
				int categoryId = rs.getInt("category_id");
				BigDecimal amount = rs.getBigDecimal("amount");
				if (categoryId == 1) {
					analytic.setAssetReal(amount);
				} else if (categoryId == 2) {
					analytic.setLiabilityReal(amount.multiply(BigDecimal.valueOf(-1)));
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException("Database error: " + e.getMessage(), e);
		}

		// income & expense real
		try (ResultSet rs = DB.query("""
				SELECT
					coa.category_id category_id,
					sum(j.debit-j.credit) amount
				FROM
					journals j
					JOIN transactions t on t.id = j.trx_id
					JOIN chart_of_accounts coa on coa.id = j.coa_id
				WHERE
					coa.category_id in (4, 5)
					AND t.trx_date >= ?
					AND t.trx_date <= ?
				GROUP BY
					coa.category_id
				""", dateStart, dateEnd)) {
			while (rs.next()) {
				int categoryId = rs.getInt("category_id");
				BigDecimal amount = rs.getBigDecimal("amount");
				if (categoryId == 4) {
					analytic.setIncomeReal(amount);
				} else if (categoryId == 5) {
					analytic.setExpenseReal(amount.multiply(BigDecimal.valueOf(-1)));
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException("Database error: " + e.getMessage(), e);
		}

		// asset & liability budget
		try (ResultSet rs = DB.query("""
				SELECT
					coa.category_id category_id,
					sum(b.amount) amount
				FROM
					budgets b
					JOIN chart_of_accounts coa on coa.id = b.coa_id
				WHERE
					coa.category_id in (1, 2)
					AND b.period_end <= ?
					AND NOT EXISTS (
						SELECT 1 FROM budgets prev
							WHERE prev.coa_id = b.coa_id
							AND prev.period_end <= ?
							AND prev.period_end > b.period_end
					)
				GROUP BY
					coa.category_id
				""", dateEnd)) {
			while (rs.next()) {
				int categoryId = rs.getInt("category_id");
				BigDecimal amount = rs.getBigDecimal("amount");
				if (categoryId == 1) {
					analytic.setAssetBudget(amount);
				} else if (categoryId == 2) {
					analytic.setLiabilityBudget(amount);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException("Database error: " + e.getMessage(), e);
		}

		// income & expense budget
		try (ResultSet rs = DB.query("""
				SELECT
					coa.category_id category_id,
					sum(b.amount) amount
				FROM
					budgets b
					JOIN chart_of_accounts coa on coa.id = b.coa_id
				WHERE
					coa.category_id in (4, 5)
					AND b.period_start >= ?
					AND b.period_end <= ?
				GROUP BY
					coa.category_id
				""", dateStart, dateEnd)) {
			while (rs.next()) {
				int categoryId = rs.getInt("category_id");
				BigDecimal amount = rs.getBigDecimal("amount");
				if (categoryId == 4) {
					analytic.setIncomeBudget(amount);
				} else if (categoryId == 5) {
					analytic.setExpenseBudget(amount);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException("Database error: " + e.getMessage(), e);
		}

		return analytic;
	}

	public static void close() {
		System.exit(0);
	}
}
