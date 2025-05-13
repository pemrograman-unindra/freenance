/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unindra.modules.datastore.coa.model;

/**
 *
 * @author muham
 */
public class Coa {
    private int id;
    private int parent_id;
    private String parent_name;
    private int category_id;
    private int code;
    private String name;
    private boolean is_cash;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parent_id;
    }
    public void setParentId(int parent) {
        this.parent_id = parent;
    }
    public void setParentName(String parent) {
        this.parent_name = parent;
    }

    public int getCategoryId() {
        return category_id;
    }
    public void setCategoryId(int category_id) {
        this.category_id = category_id;
    }
    public String getCategoryName() {
        switch (this.category_id) {
            case 1: return "Aset";
            case 2: return "Kewajiban";
            case 3: return "Aset Bersih";
            case 4: return "Penerimaan";
            case 5: return "Pengeluaran";
        }
        return "Belum Ditentukan";
    }

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsCash() {
        return is_cash;
    }
    public void setIsCash(boolean isCash) {
        this.is_cash = isCash;
    }

}