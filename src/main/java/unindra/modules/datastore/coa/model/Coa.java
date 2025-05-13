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
    private int category_id;
    private int code;
    private String name;
    private int is_cash;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getParent_id() {
        return parent_id;
    }
    public void setParent_id(int parent) {
        this.parent_id = parent;
    }

    /**
     *
     * @return
     */
    public int getCategory_id() {
        return category_id;
    }
    public void setCategory(int category) {
        this.category_id = category;
    }

    /**
     *
     * @return
     */
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


    public int getIsCash() {
    return is_cash;
}
public void setIsCash(int isCash) {
    this.is_cash = isCash;
}

}