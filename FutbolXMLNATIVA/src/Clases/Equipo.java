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
public class Equipo implements Serializable{
    int ID_equipo;
    String nombre;
    String presidente;
    int ID_liga;   

    public Equipo() {
        this.ID_equipo = 0;
        this.nombre = "NULL";
        this.presidente = "NULL";
        this.ID_liga = 0;
    }

    public Equipo(int ID_equipo, String nombre, String presidente, int ID_liga) {
        this.ID_equipo = ID_equipo;
        this.nombre = nombre;
        this.presidente = presidente;
        this.ID_liga = ID_liga;
    }

    public void setID_equipo(int ID_equipo) {
        this.ID_equipo = ID_equipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    public void setID_liga(int ID_liga) {
        this.ID_liga = ID_liga;
    }

    public int getID_equipo() {
        return ID_equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPresidente() {
        return presidente;
    }

    public int getID_liga() {
        return ID_liga;
    }
}
