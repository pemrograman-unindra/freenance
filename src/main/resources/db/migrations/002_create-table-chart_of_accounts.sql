CREATE TABLE IF NOT EXISTS chart_of_accounts (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  parent_id INTEGER,
  category_id INTEGER, -- 1: Harta, 2: Kewajiban, 3: Modal, 4: Pendapatan, 5: Beban
  code INTEGER NOT NULL UNIQUE,
  name TEXT NOT NULL,
  is_cash INTEGER NOT NULL DEFAULT 0, -- 0: Non-Kas, 1: Kas
  FOREIGN KEY (parent_id) REFERENCES chart_of_accounts(id)
);
UPDATE sqlite_sequence SET seq = 1000 WHERE name = 'chart_of_accounts';