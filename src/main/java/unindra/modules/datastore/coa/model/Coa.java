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
    private String category_name;
    private int code;
    private String name;
    private String note;
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
    public String getParentName() {
        return parent_name;
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
            case 1: return "Harta";
            case 2: return "Utang";
            case 3: return "Kekayaan Bersih";
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

    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }

    public boolean getIsCash() {
        return is_cash;
    }
    public void setIsCash(boolean isCash) {
        this.is_cash = isCash;
    }

}