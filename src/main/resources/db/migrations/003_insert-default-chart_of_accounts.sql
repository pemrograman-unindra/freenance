INSERT OR IGNORE INTO chart_of_accounts (id, parent_id, category_id, is_cash, code, name, note) VALUES
-- HARTA
(1, null, 1, false, 10000, 'Harta', 'Harta yang kita miliki'),
(11, 1, 1, true, 11000, 'Uang Tunai / Bank', 'Alat Pembayaran'),
(111, 11, 1, true, 11100, 'Uang Tunai', 'Uang Tunai'),
(112, 11, 1, true, 11200, 'Bank BSI', 'No. Rek : 12345'),
(113, 11, 1, true, 11300, 'Bank Muamalat', 'No. Rek : 654321'),
(114, 11, 1, true, 11400, 'Uang Elektronik', 'Emoney, BCA Flazz, dsb'),
(115, 11, 1, true, 11500, 'Dompet Digital', 'Gopay, OVO, DANA, dsb'),
(12, 1, 1, false, 12000, 'Piutang', 'Dana yang masih berada dipihak lain'),
(121, 12, 1, false, 12100, 'Piutang Klien', 'Penghasilan dari klien yang belum diterima'),
(122, 12, 1, false, 12200, 'Piutang Pribadi', 'Keluarga atau teman yang berutang kepada kita'),
(13, 1, 1, false, 13000, 'Investasi', 'Saham, Logam Mulia, dsb'),
(131, 13, 1, false, 13100, 'Saham', 'Saham'),
(132, 13, 1, false, 13200, 'Logam Mulia', 'Logam Mulia (LM)'),
(133, 13, 1, false, 13300, 'Tanah', 'Tanah'),
(14, 1, 1, false, 14000, 'Aset', 'Aset'),
(141, 14, 1, false, 14100, 'Rumah', 'Tanah dan bangunan tempat tinggal'),
(142, 14, 1, false, 14200, 'Mobil', 'Toyota Fortuner B-1234-EFG'),
(143, 14, 1, false, 14300, 'Sepeda Motor', 'Honda CRF B-4321-EFG'),
(144, 14, 1, false, 14400, 'Peralatan Kerja', 'Laptop, Meja Kerja, dsb'),

-- UTANG
(2, null, 2, false, 20000, 'Utang', 'Dana yang harus kita bayar kepihak lain'),
(21, 2, 2, false, 21000, 'Utang Rumah (KPR)', 'Sisa cicilan kredit kepemilikan rumah'),
(22, 2, 2, false, 22000, 'Utang Mobil (KPM)', 'Sisa cicilan kredit kepemilikan mobil B-1234-EFG'),
(23, 2, 2, false, 23000, 'Utang Sepeda Motor (KSM)', 'Sisa cicilan kredit kepemilikan sepda motor B-4321-EFG'),
(24, 2, 2, false, 24000, 'Utang Pajak', 'Pajak yang harus dibayar'),
(25, 2, 2, false, 25000, 'Utang Pribadi', 'Pinjaman kepada saudara atau teman'),
(26, 2, 2, false, 26000, 'Utang Lainnya', 'Utang lainnya'),

-- KEKAYAAN BERSIH
(3, null, 3, false, 30000, 'Kekayaan Bersih', 'Harta bersih setelah dikurangi utang'),
(31, 3, 3, false, 31000, 'Kekayaan Bersih Berjalan', 'Kekayaan bersih saat ini'),

-- PENERIMAAN
(4, null, 4, false, 40000, 'Penerimaan', 'Penghasilan'),
(41, 4, 4, false, 41000, 'Pendapatan Freelance', 'Penghasilan utama dari proyek'),
(42, 4, 4, false, 42000, 'Pendapatan Investasi', 'Bagi Hasil, Deviden, dsb'),
(43, 4, 4, false, 43000, 'Pendapatan Tak Terduga', 'Hadiah, cashback, dsb'),
(44, 4, 4, false, 44000, 'Pendapatan Lainnya', 'Jualan online, proyek kecil, dsb'),

-- PENGELUARAN
(5, null, 5, false, 50000, 'Pengeluaran', 'Pengeluaran'),
(51, 5, 5, false, 51000, 'Biaya Kerja', 'Pengeluaran yang berkaitan dengan pekerjaan'),
(511, 51, 5, false, 51100, 'Biaya Sewa Tempat Kerja', 'Ruang kantor, Studio Kerja, Coworking Space, dsb'),
(512, 51, 5, false, 51200, 'Biaya Listrik', 'Token listrik, tagihan listrik, dsb'),
(513, 51, 5, false, 51300, 'Biaya Internet & Komunikasi', 'Wifi, Kuota, Pulsa, dsb'),
(514, 51, 5, false, 51400, 'Biaya Promosi', 'Google Ads, Linkedin, Upwork, dsb'),
(515, 51, 5, false, 51500, 'Biaya Perlengkapan Kerja', 'Alat tulis, mouse, dsb'),
(516, 51, 5, false, 51600, 'Biaya Lisensi & Software', 'Google Workspace, Canva, Adobe, dsb'),
(517, 51, 5, false, 51700, 'Biaya Pendidikan & Kursus', 'Bootcamp, seminar, workshop, kursus, dsb'),
(52, 5, 5, false, 52000, 'Biaya Hidup', 'Pengeluaran yang tidak berkaitan dengan pekerjaan'),
(521, 52, 5, false, 52100, 'Biaya Sewa Tempat Tinggal', 'Rumah, Apartemen, Kost, dsb'),
(522, 52, 5, false, 52200, 'Biaya Makanan & Minuman', 'Gas, Beras, Lauk, dsb'),
(523, 52, 5, false, 52300, 'Biaya Transportasi', 'BBM, parkir, tol, servis kendaraan, dsb'),
(524, 52, 5, false, 52400, 'Biaya Kesehatan', 'BPJS, Rumah Sakit, dsb'),
(525, 52, 5, false, 52500, 'Biaya Hiburan & Lifestyle', 'Jalan-jalan, healing, dsb'),
(526, 52, 5, false, 52600, 'Biaya Lainnya', 'Biaya lain-lain');

UPDATE sqlite_sequence SET seq = 1000 WHERE name = 'chart_of_accounts';