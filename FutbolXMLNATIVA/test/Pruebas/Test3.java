/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import Clases.Equipo;
import Clases.Liga;
import Clases.Pais;
import CustomsListModels.CustomListModelEquipos;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class Test3 {
    
    CustomListModelEquipos equipos = new CustomListModelEquipos();
    
    public Test3() {
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
    public void aniadirEquipos(Equipo e, String nombre, String presidente, int id_liga){

        Equipo a = new Equipo();        
        
        a.setID_equipo(e.getID_equipo() + 1);
        a.setNombre(nombre);
        a.setPresidente(presidente);
        a.setID_liga(id_liga);
        
        int tamanoEquipos = equipos.getSize();
        equipos.addEquipo(a);
        Assert.assertEquals(equipos.getSize(), tamanoEquipos + 1);
    }         
    

    
    // The methods must be annotated with annotation @Test. For example:
    @Test
    public void guardarEquipos() {
        Equipo p = new Equipo();

        if(equipos.getSize() != 0){
            p = equipos.getEquipo(equipos.getSize() - 1);
        }
        int tamanoEquipos = equipos.getSize();
        aniadirEquipos(p, "Real Madrid", "Florentino Fernandez", 2);
        Assert.assertEquals(equipos.getSize(), tamanoEquipos + 1);
    } 
      
}
