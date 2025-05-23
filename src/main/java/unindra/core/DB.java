package unindra.core;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.stream.Collectors;

public class DB {
	private static Connection conn;

	public static void init() throws SQLException {
		openConnection();
		migrate();
	}

	private static void openConnection() throws SQLException {
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:" + Config.get("DB_NAME"));
		} catch (SQLException e) {
			throw new RuntimeException("Failed to connect to database: " + e.getMessage(), e);
		}
	}

	public static Connection getConnection() throws SQLException {
		if (conn == null || conn.isClosed()) {
			openConnection();
		}
		return conn;
	}

	public static void closeConnection() {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Helper untuk SELECT (hasil ResultSet harus ditutup oleh pemanggil)
	public static ResultSet query(String sql, Object... params) throws SQLException {
		PreparedStatement stmt = prepareStatement(sql, params);
		return stmt.executeQuery();
	}

	// Helper untuk INSERT, UPDATE, DELETE
	public static int exec(String sql, Object... params) throws SQLException {
		int affectedRows;
		try (PreparedStatement stmt = prepareStatement(sql, params)) {
			affectedRows = stmt.executeUpdate();
			if (sql.trim().toUpperCase().startsWith("INSERT")) {
				try (ResultSet rs = stmt.getGeneratedKeys()) {
					if (rs.next()) {
						return rs.getInt(1);
					}
				}
			}
		}
		return affectedRows;
	}

	// Helper untuk menyiapkan PreparedStatement dengan parameter
	private static PreparedStatement prepareStatement(String sql, Object... params) throws SQLException {
		PreparedStatement stmt = getConnection().prepareStatement(sql);
		for (int i = 0; i < params.length; i++) {
			stmt.setObject(i + 1, params[i]);
		}
		return stmt;
	}

	public static void migrate() {
		try {
			String[] files = {
					"001_create-table-users.sql",
					"002_create-table-chart_of_accounts.sql",
					"003_insert-default-chart_of_accounts.sql",
					"004_create-table-contacts.sql",
					"005_insert-default-contacts.sql",
					"006_create-table-projects.sql",
					"007_insert-default-projects.sql",
					"008_create-table-budgets.sql",
					"009_create-table-transactions.sql",
					"010_create-table-journals.sql"
			};

			for (String file : files) {
				System.out.println("Running migration: " + file);
				try (InputStream in = DB.class.getResourceAsStream("/db/migrations/" + file);
						BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
					String sql = reader.lines().collect(Collectors.joining("\n"));
					exec(sql);
				} catch (Exception e) {
					throw new RuntimeException("Failed to run migration file: " + file + " - " + e.getMessage(), e);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("Database migration failed: " + e.getMessage(), e);
		}
	}
}
