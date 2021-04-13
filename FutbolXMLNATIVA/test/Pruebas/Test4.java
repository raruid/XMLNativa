/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import Clases.Equipo;
import Clases.Jugador;
import CustomsListModels.CustomListModelJugadores;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class Test4 {
    
    CustomListModelJugadores jugadores = new CustomListModelJugadores();
    
    public Test4() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    public void aniadirJugadores(Jugador e, String nombre, int edad, int ID_equipo){

        Jugador a = new Jugador();        
        
        a.setID_jugador(e.getID_jugador() + 1);
        a.setNombre(nombre);
        a.setEdad(edad);
        a.setID_equipo(ID_equipo);
        
        jugadores.addJugador(a);   
    }      
    
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void guardarJugadores() {
        Jugador p = new Jugador();

        if(jugadores.getSize() != 0){
            p = jugadores.getJugador(jugadores.getSize() - 1);
        }
        
        int tamanoJugadores = jugadores.getSize();
        aniadirJugadores(p, "Eden Hazard", 28, 2); 
        Assert.assertEquals(jugadores.getSize(), tamanoJugadores + 1);
    }
}
