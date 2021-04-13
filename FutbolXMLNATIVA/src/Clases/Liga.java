/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class Liga implements Serializable{
    
    private int ID_liga;
    private String nombre;
    private int division;
    private int ID_pais;

    public Liga() {
        this.ID_liga = 0;
        this.nombre = "NULL";
        this.division = 0;
        this.ID_pais = 0;
    }

    public Liga(int ID_liga, String nombre, int division, int ID_pais) {
        this.ID_liga = ID_liga;
        this.nombre = nombre;
        this.division = division;
        this.ID_pais = ID_pais;
    }
    
    

    public void setID_liga(int ID_liga) {
        this.ID_liga = ID_liga;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public void setID_pais(int ID_pais) {
        this.ID_pais = ID_pais;
    }

    public int getID_liga() {
        return ID_liga;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDivision() {
        return division;
    }

    public int getID_pais() {
        return ID_pais;
    }

}
