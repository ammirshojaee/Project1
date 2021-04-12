/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author KIMBERLET EPELLE
 */
@Entity
public class Cashier {
    
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String Password;
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public List<String> getList() {
		if (this.name.length() > 0) {
			return Arrays.asList(this.name.split(","));
		}
		return new ArrayList<>();
	}
    
    
    
}
