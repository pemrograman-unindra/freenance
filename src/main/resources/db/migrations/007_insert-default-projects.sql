INSERT OR IGNORE INTO projects (id, code, name) VALUES (1, 'N/A', 'Umum');

UPDATE sqlite_sequence SET seq = 2 WHERE name = 'projects';