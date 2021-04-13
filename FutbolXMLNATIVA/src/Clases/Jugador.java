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
public class Jugador implements Serializable{
    
    int ID_jugador;
    String nombre;
    int edad;
    int ID_equipo;

    public Jugador() {
        this.ID_jugador = 0;
        this.nombre = "NULL";
        this.edad = 0;        
        this.ID_equipo = 0;
    }

    public Jugador(int ID_jugador, String nombre, int edad, int ID_equipo) {
        this.ID_jugador = ID_jugador;
        this.nombre = nombre;
        this.ID_equipo = ID_equipo;
        this.edad = edad;
    }

    public void setID_jugador(int ID_jugador) {
        this.ID_jugador = ID_jugador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setID_equipo(int equipo) {
        this.ID_equipo = equipo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getID_jugador() {
        return ID_jugador;
    }

    public String getNombre() {
        return nombre;
    }

    public int getID_equipo() {
        return ID_equipo;
    }

    public int getEdad() {
        return edad;
    }  
}
