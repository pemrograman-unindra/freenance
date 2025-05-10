INSERT OR IGNORE INTO contacts (id, code, name) VALUES
(1, 'PLN', 'PLN');

UPDATE sqlite_sequence SET seq = 100 WHERE name = 'contacts';