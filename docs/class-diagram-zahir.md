# Class Diagram - Sistem Berjalan (Zahir Accounting)

Class Diagram ini telah direvisi berdasarkan struktur database aktual Zahir Accounting (`db-zahir.sql`). Zahir menggunakan struktur tabel yang terpusat dan relasi antar tabel sering kali bersifat logis (tanpa Foreign Key constraint fisik di database).

## 1. Modul Manajemen Data Master

Tabel-tabel utama untuk data master:
- **cardfile**: Menyimpan seluruh data kontak (Pelanggan, Suplier, Karyawan, Salesman). Tipe kontak dibedakan oleh flag boolean (`is_customer`, `is_supplier`, dll).
- **inventor**: Menyimpan data produk/item barang dan jasa.
- **kiraan**: Menyimpan Chart of Accounts (Daftar Akun Anggaran).
- **gudang, dept, job**: Menyimpan data master lokasi, departemen, dan proyek.
- **unit, tax**: Menyimpan satuan pengukuran dan tarif pajak.

```plantuml
@startuml Class Diagram Data Master (Real Schema)
skinparam classAttributeIconSize 0
skinparam packageStyle rectangle

package "Master Data" {
    class "cardfile (Kontak)" as cardfile {
        +contact_id : char(36)
        +kode : varchar
        +perusahaan : varchar
        +is_customer : boolean
        +is_supplier : boolean
        +is_employee : boolean
        +currency_id : char(36)
        +classification_id : char(36)
        +bataskredit : double
        +duedays : int
    }

    class "kiraan (Akun/COA)" as kiraan {
        +id : char(36)
        +code : varchar
        +nama : varchar
        +currency_id : char(36)
        +subclassification_id : char(36)
        +is_cash : boolean
        +is_active : boolean
    }

    class "inventor (Produk)" as inventor {
        +id : char(36)
        +kode : varchar
        +deskripsi : varchar
        +keterangan : text
        +is_salable : boolean
        +is_purchasable : boolean
        +is_tracked_as_inventory : boolean
        +unit_id : char(36)
        +cogs_method : varchar
    }

    class "gudang" as gudang {
        +id : char(36)
        +kode : varchar
        +nama : varchar
    }

    class "dept (Departemen)" as dept {
        +id : char(36)
        +kode : varchar
        +nama : varchar
    }

    class "job (Proyek)" as job {
        +id : char(36)
        +kode : varchar
        +nama : varchar
    }
}
@enduml
```

---

## 2. Siklus Penjualan (Sales Cycle)

- **sales**: Tabel utama (header) untuk transaksi penjualan. Jenis transaksi (Quotation, SO, DO, Invoice, Return) biasanya dibedakan oleh field `order_type`.
- **itemsale**: Tabel detail barang/jasa untuk setiap transaksi penjualan.

```plantuml
@startuml Class Diagram Sales (Real Schema)
skinparam classAttributeIconSize 0

package "Sales Module" {
    class "sales (Penjualan)" as sales {
        +id : char(36)
        +transaction_id : char(36)
        +nojoborder : varchar
        +order_type : varchar
        +nilaikurs : double
        +subtotal : double
        +total_tax : double
        +nilaipenjualan : double
        +uangmuka : double
        +courier_id : int
    }

    class "itemsale (Detail Jual)" as itemsale {
        +id : char(36)
        +transaction_id : char(36)
        +product_id : char(36)
        +unit_id : char(36)
        +account_id : char(36)
        +department_id : char(36)
        +project_id : char(36)
        +warehouse_id : char(36)
        +jumlah : double
        +harga : double
        +discount : double
    }
}

sales "1" *-- "many" itemsale : transaction_id
@enduml
```

---

## 3. Siklus Pembelian (Purchase Cycle)

- **beli**: Tabel utama (header) untuk transaksi pembelian (PO, GR, Invoice).
- **itembeli**: Tabel detail barang/jasa untuk transaksi pembelian.

```plantuml
@startuml Class Diagram Purchase (Real Schema)
skinparam classAttributeIconSize 0

package "Purchase Module" {
    class "beli (Pembelian)" as beli {
        +id : char(36)
        +transaction_id : char(36)
        +taxserialnumber : varchar
        +nilaikurs : double
        +subtotal : double
        +total_tax : double
        +nilaipenjualan : double
        +uangmuka : double
    }

    class "itembeli (Detail Beli)" as itembeli {
        +id : char(36)
        +transaction_id : char(36)
        +product_id : char(36)
        +unit_id : char(36)
        +account_id : char(36)
        +department_id : char(36)
        +project_id : char(36)
        +warehouse_id : char(36)
        +jumlah : double
        +harga : double
        +discount : double
    }
}

beli "1" *-- "many" itembeli : transaction_id
@enduml
```

---

## 4. Keuangan & Jurnal (Finance)

- **kasin**: Tabel transaksi kas masuk (bukan hasil penjualan).
- **kasout**: Tabel transaksi kas keluar (biaya operasional, dll).
- **jurnal**: Tabel detail jurnal akuntansi (debit/kredit). Zahir mungkin menggunakan `g_jurnal` sebagai header atau langsung mengelola jurnal detail yang terhubung ke `transaction_id` dari modul lain.
- **asset**: Tabel harta tetap.

```plantuml
@startuml Class Diagram Finance (Real Schema)
skinparam classAttributeIconSize 0

package "Finance Module" {
    class "kasin (Kas Masuk)" as kasin {
        +id : char(36)
        +transaction_id : char(36)
        +account_id : char(36)
        +nilai : double
        +is_receivable_payment : smallint
    }

    class "kasout (Kas Keluar)" as kasout {
        +id : char(36)
        +transaction_id : char(36)
        +account_id : char(36)
        +nilai : double
        +is_payable_payment : smallint
    }

    class "jurnal (Jurnal Detail)" as jurnal {
        +id : char(36)
        +transaction_id : char(36)
        +account_id : char(36)
        +debit : double
        +kredit : double
        +note : text
    }
    
    class "asset (Harta Tetap)" as asset {
        +id : char(36)
        +kode : varchar
        +nama : varchar
        +nilai_perolehan : double
        +nilai_buku : double
        +kode_asset_id : char(36)
        +depr_account_id : char(36)
    }
}
@enduml
```
