INSERT OR IGNORE INTO contacts (id, name) VALUES
(1, 'PLN');

UPDATE sqlite_sequence SET seq = 100 WHERE name = 'contacts';