A. Proses Bisnis
Proses bisnis merupakan serangkaian aktivitas atau tugas terstruktur yang saling terkait untuk menghasilkan layanan atau produk tertentu bagi konsumen dalam lingkup organisasi. Dalam konteks laporan KKP ini, proses bisnis akan dijabarkan ke dalam empat bagian utama, yaitu proses bisnis sistem berjalan, analisa proses bisnis pekerja lepas, analisa kesenjangan (gap analysis), serta proses bisnis sistem usulan yang telah dikembangkan untuk kebutuhan pekerja lepas.
1. Proses Bisnis Sistem Berjalan
PT. Zahir Internasional merupakan perusahaan yang telah lama dikenal sebagai pengembang perangkat lunak akuntansi yang menyasar segmen usaha mikro, kecil, dan menengah (UMKM). Zahir Accounting secara umum dirancang untuk memenuhi kebutuhan perusahaan atau badan usaha dengan struktur organisasi formal. Proses bisnis pada aplikasi Zahir Accounting berorientasi pada pengelolaan keuangan perusahaan secara menyeluruh dan terintegrasi sesuai dengan prinsip akuntansi. Berikut adalah rincian proses bisnis pada sistem berjalan:

Manajemen Entitas dan Multi-Perusahaan
Zahir mendukung pengelolaan multi-entitas. Proses bisnis dimulai dari login atau registrasi lalu membuat atau memilih entitas perusahaan yang akan dikelola. Hal ini menunjukkan bahwa sistem dirancang untuk organisasi yang memiliki beberapa anak perusahaan atau cabang, di mana setiap entitas memiliki basis data akuntansi yang terpisah namun tetap dalam satu ekosistem aplikasi.

Manajemen Data Master
Data master merupakan data utama dalam sistem yang berfungsi sebagai referensi bagi seluruh transaksi bisnis. Pada Zahir Accounting 7, pengelolaan data master dirancang dengan tingkat granularitas yang tinggi untuk memenuhi kebutuhan perusahaan dengan struktur organisasi yang kompleks. Berikut adalah komponen-komponen data master yang terdapat dalam sistem:
Data Kontak
Modul ini mengelola seluruh informasi pihak yang berhubungan dengan perusahaan, meliputi pelanggan, pemasok, karyawan dan pihak ketiga. Setiap entitas kontak memiliki atribut lengkap seperti nama, alamat, nomor telepon, email, serta informasi perpajakan (NPWP). Data kontak menjadi acuan utama dalam pencatatan transaksi penjualan dan pembelian, sehingga memastikan konsistensi data piutang dan utang usaha.
Daftar Akun (Chart of Account)
Daftar akun merupakan struktur hierarkis yang mendefinisikan seluruh akun keuangan perusahaan berdasarkan standar akuntansi yang berlaku. Zahir menyediakan template COA yang dapat disesuaikan dengan kebutuhan spesifik perusahaan, mencakup klasifikasi akun harta, kewajiban, ekuitas, pendapatan, dan beban. Setiap akun memiliki kode unik dan dapat dikategorikan berdasarkan sifatnya (debet/kredit normal) untuk memfasilitasi proses penjurnalan otomatis.
Data Produk
Modul ini mencatat seluruh item yang diperjualbelikan oleh perusahaan, baik berupa barang fisik maupun jasa. Setiap produk memiliki atribut seperti kode produk, nama, kategori, harga jual, harga beli, dan status aktif/non-aktif. Untuk produk fisik, sistem juga mencatat informasi stok yang tersedia serta riwayat keluar masuk nya stok.
Satuan Pengukuran
Sistem mendukung konversi multi-satuan untuk mengakomodasi kebutuhan transaksi yang menggunakan satuan berbeda. Fitur ini memastikan akurasi perhitungan stok dan nilai persediaan dalam berbagai konteks transaksi.
Data Gudang
Sistem menyediakan fitur manajemen multi-gudang yang memungkinkan pelacakan stok per lokasi secara terpisah. Setiap gudang dapat memiliki penanggung jawab dan alamat yang berbeda, serta mendukung proses transfer stok antar gudang dengan dokumentasi yang teraudit.
Data Departemen
Modul ini memfasilitasi pembagian struktur organisasi perusahaan ke dalam unit-unit kerja yang lebih kecil. Setiap transaksi dapat dialokasikan ke departemen tertentu untuk keperluan analisis profitabilitas per divisi, pengendalian biaya, dan penyusunan laporan keuangan segmental.
Data Proyek
Sistem menyediakan fitur pelacakan biaya dan pendapatan berdasarkan proyek tertentu. Hal ini sangat berguna bagi perusahaan yang bergerak di bidang konstruksi, konsultan, atau jasa profesional lainnya yang memerlukan analisis margin per proyek. Setiap transaksi yang terkait dengan proyek akan teragregasi untuk menghasilkan laporan laba rugi per proyek.
Data Mata Uang
Sistem mendukung pencatatan dalam berbagai mata uang asing dengan kurs yang dapat diperbarui secara berkala. Sistem akan secara otomatis melakukan konversi dan revaluasi ke mata uang dasar perusahaan sehingga nilai dalam laporan yang disajikan valid sesuai nilai kurs yang berlaku pada masing-masing mata uang sesuai dengan standar akuntansi yang berlaku.
Data Pajak
Modul ini mengelola berbagai jenis pajak yang berlaku di negara sesuai dengan lokasi perusahaan masing-masing. Setiap jenis pajak memiliki tarif dan aturan perhitungan yang dapat dikonfigurasi sesuai dengan regulasi perpajakan yang berlaku. Integrasi dengan sistem e-Faktur juga dimungkinkan untuk mempermudah pelaporan pajak.
Data Harta Tetap
Sistem menyediakan modul khusus untuk mengelola aset tetap perusahaan, termasuk pencatatan nilai perolehan, akumulasi penyusutan, dan nilai buku. Metode penyusutan dapat dikonfigurasi (garis lurus, saldo menurun, dll.) dan sistem akan secara otomatis membuat jurnal penyusutan pada setiap akhir periode.

Konfigurasi Sistem
Zahir Accounting 7 dilengkapi dengan konfigurasi sistem yang berfungsi untuk mengelola aspek teknis, keamanan, dan kesinambungan operasional aplikasi terhadap data perusahaan. Konfigurasi sistem dapat diakses melalui menu dropdown yang terletak di pojok kanan atas antarmuka aplikasi.
Manajemen Pengguna
Sistem menyediakan kontrol akses berbasis peran (role-based access control) untuk memastikan bahwa setiap pengguna hanya dapat mengakses fitur dan data sesuai dengan kewenangannya. Sistem juga mencatat seluruh aktivitas pengguna secara kronologis, termasuk waktu login, modul yang diakses, dan transaksi yang dilakukan. Fitur ini penting untuk keperluan audit trail dan investigasi jika terjadi anomali data.
Manajemen Perusahaan
Kategori ini mengelola parameter-parameter yang bersifat spesifik untuk entitas perusahaan yang sedang aktif. Profil perusahaan digunakan di berbagai laporan serta terkait dengan integrasi perpajakan.
Sistem akuntansi bekerja berdasarkan periode waktu tertentu (biasanya bulanan atau tahunan). Proses penutupan buku merupakan prosedur akuntansi yang dilakukan pada akhir periode untuk memfinalisasi laporan keuangan. Setelah tutup buku dilakukan, sistem akan mengunci semua transaksi pada periode tersebut dan secara otomatis memindahkan saldo laba/rugi ke akun laba ditahan (retained earnings). Proses ini bersifat irreversible dan memerlukan otorisasi khusus.
Saldo Awal
Fitur ini untuk menginisialisasi saldo awal setiap akun, utang, piutang, uang muka, serta persediaan pada periode pertama penggunaan sistem. Proses ini sangat penting saat migrasi dari sistem lama ke Zahir, karena memastikan kontinuitas data historis.
Impor Data
Sistem mendukung impor data massal dari file eksternal (CSV, Excel) untuk mempercepat proses entry data master awal maupun transaksi. Fitur ini dilengkapi dengan validasi data untuk mencegah kesalahan format atau duplikasi.
Backup/Restore Data
Prosedur backup menciptakan salinan lengkap database perusahaan yang dapat disimpan di lokasi eksternal sebagai antisipasi kehilangan data. Fitur restore memungkinkan pemulihan data ke kondisi tertentu jika terjadi kegagalan sistem atau kesalahan entry yang masif.
Pengaturan Aplikasi
Menu ini berisi berbagai parameter global yang mengatur perilaku aplikasi, seperti penomoran transaksi, format tanggal, pemisah desimal, metode pembulatan, dan preferensi tampilan. Konfigurasi ini berlaku untuk seluruh pengguna dalam satu entitas perusahaan.

Siklus Penjualan
Siklus penjualan merupakan rangkaian proses bisnis yang dimulai dari penawaran produk/jasa kepada pelanggan hingga penerimaan pembayaran. Pada Zahir Accounting 7, siklus ini dirancang dengan alur yang sangat terstruktur untuk menjaga akurasi dan kontrol terhadap data inventaris, piutang, dan pengakuan pendapatan sesuai dengan prinsip akuntansi yang berlaku. Berikut adalah tahapan dalam siklus pendapatan:
Penawaran Harga (Quotation)
Penawaran harga merupakan dokumen awal yang diterbitkan kepada calon pelanggan yang berisi rincian produk/jasa, harga, syarat pembayaran, dan masa berlaku penawaran. Quotation bersifat non-binding dan belum menimbulkan kewajiban hukum bagi kedua belah pihak. Dokumen ini berfungsi sebagai alat negosiasi sebelum terjadi kesepakatan transaksi.
Pesanan Penjualan (Sales Order)
Setelah pelanggan menyetujui penawaran, sistem akan membuat Sales Order sebagai konfirmasi pemesanan resmi. Dokumen ini mencatat detail barang yang dipesan, kuantitas, harga yang disepakati, dan jadwal pengiriman. Sales Order menjadi dasar bagi departemen gudang untuk mempersiapkan barang dan departemen keuangan untuk memantau outstanding orders.
Pengiriman Barang (Delivery Order)
Proses ini melibatkan pemindahan fisik barang dari gudang ke pelanggan. Sistem akan secara otomatis mengurangi kuantitas stok pada saat delivery order diproses. Dokumen pengiriman dilengkapi dengan nomor resi dan tanda tangan penerima sebagai bukti bahwa barang telah diterima dalam kondisi baik.
Faktur Penjualan (Sales Invoice)
Faktur merupakan dokumen legal yang menjadi dasar pengakuan pendapatan dan piutang usaha dalam sistem akuntansi. Sistem akan secara otomatis membuat jurnal: Debet Piutang Usaha, Kredit Penjualan, dan Kredit PPN Keluaran. Faktur juga dapat diintegrasikan dengan sistem e-Faktur untuk keperluan pelaporan pajak.
Retur Penjualan (Sales Return)
Jika terjadi pengembalian barang oleh pelanggan (karena cacat, tidak sesuai spesifikasi, atau alasan lain), sistem akan mencatat retur penjualan yang berdampak pada: penambahan stok kembali, pengurangan piutang, dan pembuatan jurnal pembalik dari penjualan awal.
Pembayaran Piutang Usaha
Proses terakhir adalah penerimaan pembayaran dari pelanggan, baik secara tunai, transfer bank, atau giro. Sistem akan mencocokkan pembayaran dengan faktur yang outstanding dan secara otomatis mengurangi saldo piutang. Untuk pembayaran parsial, sistem dapat melacak sisa piutang yang belum terbayar.
Daftar Piutang Usaha
Sistem menyediakan daftar piutang yang mengklasifikasikan piutang berdasarkan umur (current, 30 hari, 60 hari, 90 hari, >90 hari) untuk membantu manajemen dalam pengendalian kredit dan estimasi piutang tak tertagih.
Pengembalian Lebih Bayar
Pengembalian Lebih Bayar merupakan suatu transaksi untuk mengembalikan dana kepada pelanggan akibat terjadinya pembayaran yang melebihi jumlah piutang usaha yang seharusnya dilunasi. Dalam sistem akuntansi, kondisi ini menimbulkan kewajiban perusahaan kepada pelanggan, yang dicatat sebagai saldo kredit pelanggan.

Siklus Pembelian
Siklus pembelian mencakup seluruh aktivitas pengadaan barang dan jasa yang diperlukan untuk operasional perusahaan. Zahir Accounting 7 menerapkan prinsip segregation of duties dalam siklus ini untuk meminimalkan risiko fraud dan memastikan akuntabilitas. Berikut adalah tahapan dalam siklus pengeluaran:
Pengajuan Pembelian (Purchase Requisition)
Proses dimulai dari departemen yang membutuhkan barang/jasa dengan mengajukan purchase requisition kepada departemen pembelian. Dokumen ini berisi spesifikasi barang, kuantitas, dan justifikasi kebutuhan. Sistem dapat dikonfigurasi untuk memerlukan approval dari manajer departemen sebelum requisition diproses lebih lanjut.
Permintaan Penawaran (Request for Quotation)
Departemen pembelian akan mengirimkan RFQ kepada beberapa vendor untuk mendapatkan penawaran terbaik. Sistem dapat mencatat multiple quotations dari berbagai vendor dan melakukan perbandingan harga untuk mendukung keputusan pembelian yang optimal.
Pesanan Pembelian (Purchase Order)
Setelah vendor terpilih, sistem akan membuat Purchase Order sebagai kontrak pemesanan formal. PO berisi detail barang, harga, syarat pembayaran, dan jadwal pengiriman yang telah disepakati. Dokumen ini memiliki kekuatan hukum dan menjadi komitmen perusahaan untuk melakukan pembayaran setelah barang diterima.
Penerimaan Barang (Goods Receipt)
Saat barang tiba di gudang, petugas akan melakukan verifikasi fisik dengan mencocokkan barang yang diterima dengan PO. Sistem akan mencatat goods receipt yang secara otomatis menambah kuantitas stok dan membuat jurnal: Debet Persediaan, Kredit Utang Belum Difaktur (jika faktur belum diterima).
Faktur Pembelian (Purchase Invoice)
Faktur merupakan dokumen legal yang menjadi dasar pengakuan utang usaha dalam sistem akuntansi. Sistem akan secara otomatis membuat jurnal: Debet Persediaan/Beban, Debet PPN Masukan, Kredit Utang Usaha.
Pembayaran Utang Usaha
Proses pembayaran dilakukan sesuai dengan terms of payment yang telah disepakati. Sistem dapat mengelola payment schedule dan memberikan reminder untuk pembayaran yang akan jatuh tempo. Untuk vendor dengan volume transaksi tinggi, sistem mendukung batch payment untuk efisiensi.
Daftar Utang Usaha
Sistem menyediakan daftar utang untuk memantau kewajiban perusahaan berdasarkan jatuh tempo, membantu cash flow planning, dan memastikan tidak ada penalty akibat keterlambatan pembayaran.
Penerimaan Lebih Bayar
Transaksi untuk menerima dana dari vendor atas kelebihan pembayaran.

Manajemen Kas dan Bank
Manajemen kas dan bank merupakan komponen krusial dalam menjaga likuiditas perusahaan. Zahir Accounting 7 menyediakan fitur komprehensif untuk mengelola seluruh instrumen keuangan jangka pendek dengan kontrol yang ketat:
Pengeluaran
Mencatat seluruh pengeluaran dana untuk pembayaran beban operasional, atau pengeluaran lainnya.
Uang Muka Pengeluaran
Mencatat seluruh dana yang dikeluarkan diawal untuk pembayaran beban operasional, atau pengeluaran lainnya yang nanti nya akan dipertanggungjawabkan.
Penerimaan
Mencatat seluruh penerimaan dana dari berbagai sumber selain penjualan.
Uang Muka Penerimaan
Mencatat seluruh dana yang diterima diawal atas pendapatan yang belum dilakukan.
Transfer Kas
Mencatat perpindahan dana antar rekening bank atau dari kas ke bank atau sebaliknya.
Rekonsiliasi Bank
Proses pencocokan saldo buku besar dengan rekening koran bank untuk mengidentifikasi perbedaan yang timbul akibat outstanding checks, deposits in transit, atau bank charges. Sistem menyediakan interface untuk menandai transaksi yang sudah cleared dan secara otomatis menghitung adjusted balance.
Manajemen Giro
Mengelola giro mundur baik yang diterima dari pelanggan (Giro Masuk) maupun yang diterbitkan kepada vendor (Giro Keluar). Sistem mencatat tanggal jatuh tempo dan memberikan reminder untuk pencairan atau pembayaran giro.


Manajemen Persediaan
Modul persediaan menangani aspek operasional fisik produk. Sistem menggunakan metode perpetual inventory yang mencatat setiap mutasi stok secara real-time:
Data Produk
Setiap produk memiliki informasi lengkap termasuk kode SKU, kategori, harga pokok penjualan, dan metode penilaian persediaan.
Penyesuaian Barang
Penyesuaian persediaan dilakukan untuk mencatat penambahan atau pengurangan stok barang selain dari pembelian dan penjualan.
Stok Opname
Proses perhitungan fisik persediaan yang dilakukan secara periodik untuk memverifikasi akurasi data sistem. Sistem menyediakan worksheet untuk mencatat hasil perhitungan fisik dan secara otomatis menghitung selisih antara stok sistem dengan stok fisik.
Pindah Gudang
Sistem mencatat perpindahan barang antar gudang dengan dokumentasi lengkap. Transfer akan mengurangi stok di gudang asal dan menambah stok di gudang tujuan.
Proses Produksi
Mencatat aktivitas produksi yang mengkonversi bahan baku menjadi barang jadi. Sistem akan mengurangi stok bahan baku sesuai BOM dan menambah stok barang jadi.
Formula Produksi (Bill of Materials)
Mendefinisikan komposisi bahan baku dan komponen yang diperlukan untuk menghasilkan satu unit produk jadi.
Konsinyasi Barang Keluar
Mencatat barang yang dititipkan ke pihak ketiga untuk dijual. Barang konsinyasi tetap menjadi aset perusahaan hingga terjual.
Serial dan Lot Tracking
Untuk produk yang memerlukan traceability (seperti elektronik atau farmasi), sistem dapat melacak setiap unit berdasarkan serial number atau lot number, termasuk tanggal kadaluarsa.

Pelaporan dan Dashboard Analitik
Sistem pelaporan Zahir Accounting 7 dirancang untuk memenuhi kebutuhan berbagai stakeholder, mulai dari level operasional hingga strategis. Laporan disajikan dalam format yang sesuai dengan standar akuntansi dan dapat diekspor dalam berbagai format (PDF, Excel, CSV):
Laporan Keuangan
Sekumpulan laporan utama yang menyajikan informasi posisi keuangan, kinerja keuangan, serta arus kas perusahaan dalam suatu periode tertentu. Laporan ini disusun berdasarkan standar akuntansi yang berlaku dan dihasilkan dari seluruh transaksi yang telah dicatat dalam sistem.
Laporan Penjualan dan Piutang
Laporan Penjualan dan Piutang merupakan sekumpulan laporan yang menyajikan informasi mengenai aktivitas penjualan perusahaan dan posisi piutang usaha kepada pelanggan selama periode tertentu.
Laporan Pembelian dan Utang
Laporan Pembelian dan Utang merupakan sekumpulan laporan yang menyajikan informasi mengenai aktivitas pembelian perusahaan serta kewajiban perusahaan kepada pemasok (utang usaha).
Laporan Produk
Laporan Produk merupakan laporan yang menyajikan informasi terkait persediaan barang dan kinerja produk yang dimiliki perusahaan.
Laporan Lainnya
Laporan Lainnya merupakan kumpulan laporan pendukung yang menyediakan informasi tambahan di luar laporan utama, namun tetap relevan untuk pengelolaan dan pengendalian perusahaan.
Kustom Laporan
Kustom laporan bertujuan untuk meningkatkan fleksibilitas sistem informasi akuntansi sehingga laporan yang dihasilkan dapat mendukung kebutuhan analisis dan pengambilan keputusan manajemen secara spesifik.

Proses bisnis tersebut dirancang untuk lingkungan perusahaan yang memiliki tingkat kompleksitas transaksi tinggi, struktur organisasi berlapis, serta kebutuhan kepatuhan terhadap standar akuntansi yang berlaku.

2. Analisa Proses Bisnis Pekerja Lepas
Pekerja lepas memiliki karakteristik yang berbeda dengan perusahaan. Pekerja lepas umumnya bekerja secara mandiri, tidak memiliki struktur organisasi formal, serta menjalankan aktivitas keuangan yang relatif sederhana. Berdasarkan hasil observasi dan analisis kebutuhan, ditemukan bahwa proses bisnis aplikasi Zahir yang ada dinilai kurang sesuai apabila diterapkan secara langsung pada pekerja lepas. Berikut ini karakteristik proses bisnis pekerja lepas:
Struktur Organisasi
Pekerja lepas umumnya beroperasi secara individual atau dalam tim kecil (maksimal 2-3 orang) tanpa struktur organisasi formal. Tidak ada pembagian departemen, hirarki manajerial, atau segregation of duties seperti pada perusahaan. Satu orang seringkali menjalankan multiple roles: sebagai pelaksana pekerjaan, sales, administrasi, dan finance sekaligus.
Model Bisnis
Mayoritas pekerja lepas bergerak di sektor jasa mandiri seperti:
Jasa kreatif: desainer grafis, video editor, content writer, fotografer
Jasa teknologi: programmer, web developer, IT consultant
Jasa profesional: konsultan bisnis, penerjemah, akuntan freelance
Jasa pendidikan: tutor privat, instruktur online
Model bisnis berbasis jasa ini tidak melibatkan barang fisik, sehingga tidak memerlukan manajemen inventaris atau logistik.
Pola Pendapatan
Pendapatan pekerja lepas bersifat project-based dan tidak tetap (variable income). Setiap proyek memiliki nilai kontrak, durasi, dan terms of payment yang berbeda-beda. Pendapatan dapat berfluktuasi signifikan antar bulan tergantung pada jumlah dan nilai proyek yang diperoleh.
Skala Operasional
Volume transaksi pekerja lepas relatif kecil dibandingkan perusahaan:
Jumlah klien: 5-20 klien aktif per tahun
Jumlah proyek: 10-50 proyek per tahun
Jumlah transaksi: 50-200 transaksi per bulan
Skala yang kecil ini memungkinkan pencatatan yang lebih sederhana tanpa perlu sistem yang kompleks.

3. Analisa Kesenjangan (Gap Analysis)
Analisa kesenjangan merupakan metode sistematis untuk mengidentifikasi perbedaan antara kondisi saat ini (current state) dengan kondisi yang diinginkan (desired state). Dalam konteks pengembangan aplikasi manajemen keuangan untuk pekerja lepas, analisa ini dilakukan untuk mengidentifikasi ketidaksesuaian antara proses bisnis Zahir Accounting 7 dengan kebutuhan spesifik pekerja lepas.
Berdasarkan kajian mendalam terhadap proses bisnis sistem berjalan, ditemukan beberapa kesenjangan signifikan yang menjadi dasar pengembangan sistem usulan:
Kesenjangan Kompleksitas Proses Bisnis
Kondisi saat ini sistem menerapkan alur proses bisnis yang panjang dan berjenjang, seperti siklus penjualan yang terdiri dari 6 tahap (Quotation, Sales Order, Delivery Order, Invoice, Payment, Return) dan siklus pembelian yang terdiri dari 7 tahap (Requisition, RFQ, PO, Goods Receipt, Invoice, Payment, Return), sedangkan pekerja lepas umumnya beroperasi secara individual atau dalam tim kecil dengan struktur organisasi yang flat. Mereka memerlukan proses yang cepat dan langsung tanpa tahapan berlapis. Terdapat gap signifikan antara kompleksitas proses yang ditawarkan sistem dengan kesederhanaan yang dibutuhkan pekerja lepas. Proses yang terlalu panjang justru menghambat produktivitas dan menambah beban administratif yang tidak perlu.
Kesenjangan Relevansi Fitur
Kondisi saat ini sistem menyediakan modul-modul yang dirancang untuk perusahaan perdagangan dan manufaktur seperti pelacakan stok persediaan dengan multi gudang, formula dan proses produksi, manajemen giro, departemen, dan lain sebagainya, sedangkan pekerja lepas mayoritas bergerak di bidang jasa (desain, programming, konsultan, content creator, dan sebagainya) yang tidak melibatkan barang fisik. Lebih dari 60% fitur yang tersedia di Zahir tidak relevan dengan karakteristik pekerjaan pekerja lepas. Fitur-fitur tersebut justru membingungkan pekerja lepas.
Kesenjangan Terminologi dan Pengalaman Pengguna
Kondisi saat ini sistem menggunakan terminologi akuntansi formal yang mengikuti standar PSAK (Pernyataan Standar Akuntansi Keuangan), seperti jurnal, neraca, penyusutan, akrual, dan sebagainya sedangkan pekerja lepas umumnya tidak memiliki latar belakang pendidikan akuntansi. Mereka memerlukan interface dengan bahasa sehari-hari yang intuitif. Terdapat barrier komunikasi antara sistem dengan pengguna karena perbedaan bahasa teknis. Hal ini menyebabkan learning curve yang tinggi dan resistensi pengguna terhadap adopsi sistem.
Kesenjangan Model Pelaporan
Kondisi saat ini sistem menghasilkan laporan keuangan formal yang sesuai dengan standar akuntansi untuk keperluan audit eksternal oleh Kantor Akuntan Publik, pelaporan ke otoritas pajak, presentasi ke stakeholder (investor atau kreditor), serta kepatuhan dengan regulasi OJK untuk perusahaan publik, sedangkan pekerja lepas memerlukan laporan yang mudah dipahami untuk mengelola kesehatan keuangan personal. Laporan yang dihasilkan sistem terlalu teknis dan berorientasi pada kepatuhan, bukan pada informasi yang praktis untuk pengambilan keputusan operasional sehari-hari.
Kesenjangan Biaya dan Aksesibilitas
Kondisi saat ini sebagai software enterprise, Zahir memiliki struktur biaya yang signifikan yaitu lisensi dengan harga untuk perusahaan, biaya implementasi dan training, kebutuhan perangkat keras yang cukup tinggi untuk performa optimal serta ketergantungan pada IT support, sedangkan pekerja lepas memiliki budget terbatas dan memerlukan aplikasi dengan biaya rendah atau freemium model, Self-service implementation tanpa perlu konsultan, dapat berjalan di perangkat keras standar (laptop consumer-grade) dan minimal maintenance dengan auto-update. Total biaya dari Zahir terlalu tinggi untuk skala bisnis pekerja lepas, sehingga tidak ekonomis untuk diadopsi.

4. Proses Bisnis Sistem Usulan
Berdasarkan hasil analisis kesenjangan di atas, aplikasi yang diusulkan dikembangkan dengan melakukan transformasi fundamental dari paradigma Corporate Accounting System menjadi Personal Financial Management System. Transformasi ini tidak hanya berupa penyederhanaan fitur, tetapi merupakan re-engineering proses bisnis yang disesuaikan dengan karakteristik dan kebutuhan pekerja lepas. Pengembangan aplikasi manajemen keuangan pekerja lepas pada PT Zahir Internasional dilakukan dengan menyederhanakan proses bisnis aplikasi Zahir yang sudah ada serta menyesuaikannya dengan kebutuhan pengguna pekerja lepas. Pengembangan ini tidak bertujuan untuk menggantikan sistem Zahir secara keseluruhan, melainkan sebagai adaptasi proses bisnis untuk segmen pengguna yang berbeda.
Proses bisnis aplikasi hasil pengembangan meliputi tahapan sebagai berikut:
Pendaftaran
Pekerja lepas melakukan pendaftaran dan mengisi data profil dasar tanpa perlu melakukan pengaturan struktur akun dan pengguna yang kompleks.
Menyiapkan data master
Pengguna bisa menyiapkan data-data yang akan dipakai pada transaksi yaitu kategori keuangan, data kontak, data proyek dan perencanaan anggaran. Data-data tersebut bisa juga diinput langsung saat melakukan penginputan transaksi.
Mengelola tagihan
Pengguna menginput tagihan yang diterima untuk dapat dikelola dan direncanakan kapan akan dibayar meliputi tanggal tagihan, akan dibayarkan kepada siapa, akan dibayar dengan apa (uang tunai atau transfer bank), untuk pembayaran apa, berapa jumlah uang yang dibayar, serta atas proyek apa dan catatan nya seperti apa.
Mengelola pengeluaran
Pengguna menginput transaksi pengeluaran dana baik dari tagihan yang sudah diterima sebelumnya maupun yang langsung dibayarkan secara langsung meliputi tanggal, dibayarkan kepada siapa, dibayar dengan apa (uang tunai atau transfer bank), untuk pembayaran apa, berapa jumlah uang yang dibayar, serta atas proyek apa dan catatan nya seperti apa.
Mengelola penerimaan
Pengguna menginput transaksi penerimaan dana meliputi tanggal, diterima dari siapa, diterima melalui apa (uang tunai atau transfer bank), penerimaan atas apa, berapa jumah uang yang diterima, serta atas proyek apa dan catatan nya seperti apa.
Penyajian Laporan Sederhana
Aplikasi menampilkan laporan sederhana seperti rekap aktifitas keuangan dan kekayaan. Mengganti terminologi akuntansi formal dengan bahasa sehari-hari yang mudah dipahami oleh non-akuntan, tanpa mengorbankan akurasi pencatatan keuangan.
Proses bisnis yang dikembangkan menekankan kemudahan penggunaan, efisiensi pencatatan, serta pemahaman yang mudah bagi pengguna non-akuntansi.
