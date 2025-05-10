CREATE TABLE IF NOT EXISTS chart_of_accounts (
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	parent_id INTEGER,
	category_id INTEGER, -- 1: Harta, 2: Kewajiban, 3: Modal, 4: Pendapatan, 5: Beban
	code INTEGER NOT NULL UNIQUE,
	name TEXT NOT NULL,
	is_cash BOOLEAN NOT NULL DEFAULT FALSE, -- 0: Non-Kas, 1: Kas
	created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
	updated_at DATETIME DEFAULT CURRENT_TIMESTAMP
);