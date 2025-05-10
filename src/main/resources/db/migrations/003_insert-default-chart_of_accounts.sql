INSERT OR IGNORE INTO chart_of_accounts (id, parent_id, category_id, is_cash, code, name) VALUES
-- HARTA
(1, NULL, 1, false, 10000, 'Aset'),
(11, 1, 1, true, 11000, 'Uang Tunai'),
(11, 1, 1, true, 11000, 'Uang Tunai'),
(12, 1, 1, true, 12000, 'BSI 123456'),
(12, 1, 1, true, 12000, 'Muamalat 654321'),
(12, 1, 1, true, 12000, 'Gopay'),
(13, 1, 1, false, 13000, 'Piutang'),
(14, 1, 1, false, 14000, 'Kendaraan'),

-- KEWAJIBAN
(2, NULL, 2, false, 20000, 'Kewajiban'),
(21, 2, 2, false, 21000, 'Tagihan Sewa Rumah'),
(21, 2, 2, false, 21000, 'Tagihan Listrik'),
(21, 2, 2, false, 21000, 'Tagihan Internet'),
(21, 2, 2, false, 21000, 'Tagihan Telekomunikasi'),

-- MODAL
(3, NULL, 3, false, 30000, 'Aset Bersih'),
(31, 3, 3, false, 31000, 'Aset Bersih'),

-- PENDAPATAN
(4, NULL, 4, false, 40000, 'Penerimaan'),
(41, 4, 4, false, 41000, 'Pendapatan Proyek'),
(42, 4, 4, false, 42000, 'Pendapatan Lainnya'),

-- BEBAN
(5, NULL, 5, false, 50000, 'Pengeluaran'),
(51, 5, 5, false, 51000, 'Biaya Sewa Rumah'),
(53, 5, 5, false, 53000, 'Biaya Listrik'),
(53, 5, 5, false, 53000, 'Biaya Internet'),
(53, 5, 5, false, 53000, 'Biaya Telekomunikasi'),
(52, 5, 5, false, 52000, 'Biaya Transportasi'),
(54, 5, 5, false, 54000, 'Biaya Lainnya');

UPDATE sqlite_sequence SET seq = 100 WHERE name = 'chart_of_accounts';