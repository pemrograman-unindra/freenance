package unindra.core;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Config {
	private static Dotenv dotenv;

	private static final Map<String, String> DEFAULTS = new HashMap<>();

	static {
		try {
			File envFile = new File(".env");
			if (envFile.exists()) {
				dotenv = Dotenv.configure().directory(".").ignoreIfMalformed().ignoreIfMissing().load();
			}
		} catch (Exception ignore) {}

		DEFAULTS.put("DB_NAME", "freenance.db");
	}

	public static String get(String key) {
		String defaultValue = DEFAULTS.getOrDefault(key, "");
		return get(key, defaultValue);
	}

	public static String get(String key, String defaultValue) {
		if (dotenv != null) {
			String value = dotenv.get(key);
			if (value != null) return value;
		}
		String envValue = System.getenv(key);
		return envValue != null ? envValue : defaultValue;
	}
}
