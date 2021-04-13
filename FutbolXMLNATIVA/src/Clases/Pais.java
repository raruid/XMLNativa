package Clases;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class Pais implements Serializable {
    private int ID_pais;
    private String nombre;
    private String zona_horaria;
    private String continente;

    public Pais() {
        this.ID_pais = 0;
        this.nombre = "NULL";
        this.zona_horaria = "NULL";
        this.continente = "NULL";
    }
    
    public Pais(Pais p) {
        this.ID_pais = p.getID_pais();
        this.nombre = p.getNombre();
        this.zona_horaria = p.getZona_horaria();
        this.continente = p.getContinente();
    }    

    public Pais(int ID_pais, String nombre, String zona_horaria, String continente) {
        this.ID_pais = ID_pais;
        this.nombre = nombre;
        this.zona_horaria = zona_horaria;
        this.continente = continente;
    }

    public void setID_pais(int ID_pais) {
        this.ID_pais = ID_pais;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setZona_horaria(String zona_horaria) {
        this.zona_horaria = zona_horaria;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public int getID_pais() {
        return ID_pais;
    }

    public String getNombre() {
        return nombre;
    }

    public String getZona_horaria() {
        return zona_horaria;
    }

    public String getContinente() {
        return continente;
    }

    
}
