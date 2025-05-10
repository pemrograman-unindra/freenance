CREATE TABLE IF NOT EXISTS transactions (
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	parent_id INTEGER DEFAULT 0, -- untuk transaksi pembayaran dari tagihan (bills)
	project_id INTEGER NOT NULL, -- relasi ke projects.id
	contact_id INTEGER NOT NULL, -- relasi ke contacts.id
	origin_coa_id INTEGER NOT NULL, -- relasi ke chart_of_accounts.id, coa asal (cash_in mengarah ke akun pendapatan, cash_out mengarah ke akun kas, bill mengarah ke akun biaya)
	target_coa_id INTEGER NOT NULL, -- relasi ke chart_of_accounts.id, coa tujuan (cash_in mengarah ke akun kas, cash_out mengarah ke akun biaya, bill mengarah ke akun utang)
	trx_type TEXT NOT NULL, -- bill, cash_in, cash_out
	trx_no TEXT NOT NULL,
	trx_date DATE NOT NULL,
	description TEXT NOT NULL,
	amount NUMERIC DEFAULT 0,
	created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
	updated_at DATETIME DEFAULT CURRENT_TIMESTAMP
);