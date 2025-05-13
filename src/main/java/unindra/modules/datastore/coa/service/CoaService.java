/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unindra.modules.datastore.coa.service;

import unindra.core.DB;
import unindra.modules.datastore.coa.model.Coa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author muham
 */
public class CoaService {
    
    public void createCoa(Coa coa) {
		try {
			DB.exec(
    "INSERT INTO coa (id, parent_id, category_id, code, name, is_cash) VALUES (?, ?, ?, ?, ?, ?)",
    coa.getId(),
    coa.getParent_id(),
    coa.getCategory_id(),
    coa.getCode(),
    coa.getName(),
    coa.getIsCash() 
);

		} catch (SQLException e) {
			throw new RuntimeException("Create contact failed: " + e.getMessage(), e);
		}
	}
    
}
