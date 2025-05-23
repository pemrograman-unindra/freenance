package unindra.core;

import java.io.File;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import io.github.cdimascio.dotenv.Dotenv;

public class Config {
	private static Dotenv dotenv;

	private static final Map<String, String> DEFAULTS = new HashMap<>();

	static {
		try {
			File envFile = new File(".env");
			if (envFile.exists()) {
				dotenv = Dotenv.configure().directory(".").ignoreIfMalformed().ignoreIfMissing().load();
			}
		} catch (Exception ignore) {
		}

		DEFAULTS.put("DB_NAME", "freenance.db");
	}

	public static String get(String key) {
		String defaultValue = DEFAULTS.getOrDefault(key, "");
		return get(key, defaultValue);
	}

	public static String get(String key, String defaultValue) {
		if (dotenv != null) {
			String value = dotenv.get(key);
			if (value != null)
				return value;
		}
		String envValue = System.getenv(key);
		return envValue != null ? envValue : defaultValue;
	}

	public static NumberFormat formatNumber() {
		return NumberFormat.getNumberInstance(new Locale("id", "ID"));
	}

	public static SimpleDateFormat formatDate() {
		return new SimpleDateFormat("yyyy-MM-dd");
	}
}
