-- Data COA (struktur pohon, id ditentukan manual untuk kemudahan parent_id)
INSERT INTO chart_of_accounts (id, parent_id, category_id, is_cash, code, name) VALUES
-- HARTA
(1, NULL, 1, 0, 1000, 'Harta'),
(11, 1, 1, 1, 1100, 'Tunai'),
(12, 1, 1, 1, 1200, 'Bank BSI 123456'),
(13, 1, 1, 0, 1300, 'Piutang'),
(14, 1, 1, 0, 1400, 'Kendaraan'),

-- KEWAJIBAN
(2, NULL, 2, 0, 2000, 'Kewajiban'),
(21, 2, 2, 0, 2100, 'Utang Usaha'),

-- MODAL
(3, NULL, 3, 0, 3000, 'Modal'),
(31, 3, 3, 0, 3100, 'Modal Pemilik'),
(32, 3, 3, 0, 3200, 'Prive'),

-- PENDAPATAN
(4, NULL, 4, 0, 4000, 'Pendapatan'),
(41, 4, 4, 0, 4100, 'Pendapatan Proyek'),
(42, 4, 4, 0, 4200, 'Pendapatan Lainnya'),

-- BEBAN
(5, NULL, 5, 0, 5000, 'Beban'),
(51, 5, 5, 0, 5100, 'Biaya Sewa Rumah'),
(53, 5, 5, 0, 5300, 'Biaya Listrik'),
(53, 5, 5, 0, 5300, 'Biaya Internet'),
(53, 5, 5, 0, 5300, 'Biaya Telekomunikasi'),
(52, 5, 5, 0, 5200, 'Biaya Transportasi'),
(54, 5, 5, 0, 5400, 'Biaya Lainnya');
