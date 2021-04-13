package Vista;


import Clases.Equipo;
import Clases.Jugador;
import Clases.Liga;
import CustomsListModels.CustomListModelPaises;
import Clases.Pais;
import CustomsListModels.CustomListModelEquipos;
import CustomsListModels.CustomListModelJugadores;
import CustomsListModels.CustomListModelLigas;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Platform.exit;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQResultSequence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public final class VistaFutbol extends javax.swing.JFrame {
    
    CustomListModelPaises paises = new CustomListModelPaises();
    CustomListModelLigas ligas = new CustomListModelLigas();
    CustomListModelEquipos equipos = new CustomListModelEquipos();
    CustomListModelJugadores jugadores = new CustomListModelJugadores();
    private static String nomClaseDS = "net.xqj.exist.ExistXQDataSource"; 
    public static int ultimoID = 0;
    
    public VistaFutbol() {
        initComponents();
        
        listaPaises.setModel(paises);
        listaLigas.setModel(ligas);
        listaEquipos.setModel(equipos);
        listaJugadores.setModel(jugadores);       
        
        btnAniadir.setBackground(Color.LIGHT_GRAY);
        btnAniadir2.setBackground(Color.LIGHT_GRAY);
        btnAniadir3.setBackground(Color.LIGHT_GRAY);
        btnAniadir4.setBackground(Color.LIGHT_GRAY);
        btnBorrar.setBackground(Color.LIGHT_GRAY);
        btnBorrar2.setBackground(Color.LIGHT_GRAY);
        btnBorrar3.setBackground(Color.LIGHT_GRAY);
        btnBorrar4.setBackground(Color.LIGHT_GRAY);
        btnModificar.setBackground(Color.LIGHT_GRAY);
        btnModificar2.setBackground(Color.LIGHT_GRAY);
        btnModificar3.setBackground(Color.LIGHT_GRAY);
        btnModificar4.setBackground(Color.LIGHT_GRAY);
        btnGuardarCambios.setBackground(Color.LIGHT_GRAY);
        btnGuardarCambios2.setBackground(Color.LIGHT_GRAY);
        btnGuardarCambios3.setBackground(Color.LIGHT_GRAY);
        btnGuardarCambios4.setBackground(Color.LIGHT_GRAY);
        btnGuardar.setBackground(Color.LIGHT_GRAY);
        btnGuardar2.setBackground(Color.LIGHT_GRAY);
        btnGuardar3.setBackground(Color.LIGHT_GRAY);
        btnGuardar4.setBackground(Color.LIGHT_GRAY);
        btnCancelar.setBackground(Color.LIGHT_GRAY);
        btnCancelar2.setBackground(Color.LIGHT_GRAY);
        btnCancelar3.setBackground(Color.LIGHT_GRAY);
        btnCancelar4.setBackground(Color.LIGHT_GRAY);
        btnSalir.setBackground(Color.LIGHT_GRAY);
    }
    
        private static XQConnection obtenConexion() throws ClassNotFoundException, InstantiationException, 
        IllegalAccessException,XQException{
        XQDataSource xqs = (XQDataSource) Class.forName(nomClaseDS).
                newInstance();       
        xqs.setProperty("serverName", "localhost");
        xqs.setProperty("port", "8080");
        xqs.setProperty("user", "admin");
        xqs.setProperty("password", "admin");
        
        return xqs.getConnection();
        
    }
        
    private static void muestraErrorXQuery(XQException e){
        System.err.println("XQuery ERROR mensaje: " + e.getMessage());
        System.err.println("XQuery ERROR causa: " + e.getCause());
        System.err.println("XQuery ERROR código: " + e.getVendorCode());
    
    }
    
    public void updatePaises(){
        XQConnection c = null; 
        /*
        try { 
            c = obtenConexion(); 
            String cad = "doc('/db/prueba/clientes.xml')/clientes/cliente/apellidos"; 
                        
             /*   
            String cad = "update insert " +
                "<pais>" +
                "<id_pais>1</id_pais>" +
                "<nombre>España</nombre>" + 
                "<zona_horaria>GTM-8</zona_horaria>" +
                "<continente>Asia</continente>" +
                "</pais>" +
                " into doc('/db/paises/paises.xml')/pais";
            XQExpression xqe = c.createExpression(); 
            xqe.executeCommand(cad); 
            */
             
             /*
            int i=1; 
            while (xqrs.next()) { 
                System.out.println("[Resultado "+(i++) + "]"); 
		XMLStreamReader xsr = xqrs.getItemAsStream(); 
		while (xsr.hasNext()) { 
                    if (xsr.getEventType() == XMLStreamConstants.CHARACTERS) { 
                        System.out.println(xsr.getText()); 
                    } 
                    xsr.next(); 
                    } 
                } 
        } 
	catch (XQException e) { 
            muestraErrorXQuery(e);
	} 
	catch (Exception e) { 
            e.printStackTrace(); 
	} 
	finally { 
            try { 
		if (c != null) { 
                    c.close(); 
		} 
            } 
            catch (XQException xe) { 
		xe.printStackTrace(); 
            } 
	} 
             
             */
    }
    
    public void insertarPaisesXML(String id, String nombre, String zonaHor, String cont){
        XQConnection c = null; 
        
        try { 
            c = obtenConexion(); 
                String cad = "update insert " +
                "<pais>" +
                "<id_pais>" + id + "</id_pais>" +
                "<nombre>" + nombre + "</nombre>" + 
                "<zona_horaria>" + zonaHor + "</zona_horaria>" +
                "<continente>" + cont + "</continente>" +
                "</pais> " +
                "into doc('/db/paises/paises.xml')/paises";
            XQExpression xqe = c.createExpression(); 
            xqe.executeCommand(cad);   
        } 
	catch (XQException e) { 
            muestraErrorXQuery(e);
	} 
	catch (Exception e) { 
            e.printStackTrace(); 
	} 
	finally { 
            try { 
		if (c != null) { 
                    c.close(); 
		} 
            } 
            catch (XQException xe) { 
		xe.printStackTrace(); 
            } 
	} 
    }
    
    public void updatePaisesXML(int id, String nombre, String zonahor, String continente){
        XQConnection c = null; 
    
        System.out.println("dididididi" + id);

        String updateID = "update value doc('/db/paises/paises.xml')/paises/pais[id_pais=" + id + "]/id_pais with \"" + id + "\"";
        String updateNombre = "update value doc('/db/paises/paises.xml')/paises/pais[id_pais=" + id + "]/nombre with \"" + nombre + "\""; 
        String updateZonaHor = "update value doc('/db/paises/paises.xml')/paises/pais[id_pais=" + id + "]/zona_horaria with \"" + zonahor + "\""; 
        String updateCont = "update value doc('/db/paises/paises.xml')/paises/pais[id_pais=" + id + "]/continente with \"" + continente + "\""; 
        
        
        try { 
            c = obtenConexion(); 
            
            XQExpression xqe = c.createExpression(); 
            xqe.executeCommand(updateNombre);  
            xqe.executeCommand(updateZonaHor); 
            xqe.executeCommand(updateCont); 
            xqe.executeCommand(updateID); 
        } 
	catch (XQException e) { 
            muestraErrorXQuery(e);
	} 
	catch (Exception e) { 
            e.printStackTrace(); 
	} 
	finally { 
            try { 
		if (c != null) { 
                    c.close(); 
		} 
            } 
            catch (XQException xe) { 
		xe.printStackTrace(); 
            } 
	}     
    }
    
    public void borrarPaisesXML(int id){
        
        XQConnection c = null; 
        String delete = "for $pa in doc('/db/paises/paises.xml')/paises/pais[id_pais=" + id + "] return update delete $pa";

        try { 
            c = obtenConexion(); 
            
            XQExpression xqe = c.createExpression();  
            xqe.executeCommand(delete); 
        } 
	catch (XQException e) { 
            muestraErrorXQuery(e);
	} 
	catch (Exception e) { 
            e.printStackTrace(); 
	} 
	finally { 
            try { 
		if (c != null) { 
                    c.close(); 
		} 
            } 
            catch (XQException xe) { 
		xe.printStackTrace(); 
            } 
	}     
    }
    
    public void leerPaisesXML(){
        
        String cadenaFinal = "";
        XQConnection c = null;
        
        try{
            c = obtenConexion();
            String cad = "doc('/db/paises/paises.xml')/paises/pais";
            XQExpression xqe = c.createExpression();
            XQResultSequence xqrs = xqe.executeQuery(cad);
            
            //int i=1; 
                 
            
            while (xqrs.next()) { 
                    //System.out.println("[Resultado "+(i++) + "]"); 
                    //System.out.println("Angelines0 " + cadenaFinal);
                    XMLStreamReader xsr = xqrs.getItemAsStream(); 
                    while (xsr.hasNext()) { 
                        if (xsr.getEventType() == XMLStreamConstants.CHARACTERS) { 
                            String aux = String.valueOf(xsr.getText());
                            //System.out.println("Angelines1 " + aux);
                            //System.out.println(xsr.getText()); 
                            if(!aux.equals("")){
                                //System.out.println("Angelines2 " + aux);
                                cadenaFinal += aux + "#";
                            }
                        } 
                        xsr.next(); 
                    } 
                }
                
                //String[] cadenaTratada = cadenaFinal.split("#");
                
                cadenaFinal = cadenaFinal.replace("\r", "");
                cadenaFinal = cadenaFinal.replace("\n", "");
                cadenaFinal = cadenaFinal.replace(" ", "");
                cadenaFinal = cadenaFinal.replace("###", "#");
                cadenaFinal = cadenaFinal.replace("##", "#");
                
                String[] cadenaTratada = cadenaFinal.split("#");
                
                System.out.println(cadenaTratada.length);
                
                int iteraciones = (cadenaTratada.length-1) / 4;
                
                int posicion_id = 1;
                int posicion_nombre = 2;
                int posicion_zona = 3;
                int posicion_cont = 4;
                
                for(int i = 0; i < iteraciones; i++){
                    Pais p = new Pais();
                    
                    p.setID_pais(Integer.parseInt(cadenaTratada[posicion_id]));
                    p.setNombre(cadenaTratada[posicion_nombre]);
                    p.setZona_horaria(cadenaTratada[posicion_zona]);
                    p.setContinente(cadenaTratada[posicion_cont]);
                    
                    paises.addPais(p);
                    
                    posicion_id += 4;
                    posicion_nombre += 4;
                    posicion_zona += 4;
                    posicion_cont += 4;
                }
                
                System.out.println(cadenaFinal);
                
                for(int i = 0; i < cadenaTratada.length; i++){
                    System.out.println("\t" + cadenaTratada[i]);
                }
               
            
        }catch (XQException e) { 
            muestraErrorXQuery(e);
	} 
	catch (Exception e) { 
            e.printStackTrace(); 
	} 
	finally { 
            try { 
		if (c != null) { 
                    c.close(); 
		} 
            } 
            catch (XQException xe) { 
		xe.printStackTrace(); 
            } 
	}
    }
    
    public void aniadirPaises(Pais p, String nombre, String zona_horaria, String continente){
        Pais a = new Pais();
        
        a.setID_pais(p.getID_pais() + 1);
        a.setNombre(nombre);
        a.setZona_horaria(zona_horaria);
        a.setContinente(continente);
        
        String id = String.valueOf(a.getID_pais());
        
        System.out.println(id);
        
        
        //escribirPaisesDB4O(a);
        insertarPaisesXML(id, nombre, zona_horaria, continente);
        
        
        paises.addPais(a);
    }
    
    public void aniadirLigas(int id, String nombre, int division, int id_pais){
        Liga a = new Liga();
        
        
        a.setID_liga(id + 1);
        a.setNombre(nombre);
        a.setDivision(division);
        a.setID_pais(id_pais);
        
        //escribirLigasDB4O(a);
        
        ligas.addLiga(a);
        
    }    
  
    public void aniadirEquipos(Equipo e, String nombre, String presidente, int id_liga){

        Equipo a = new Equipo();        
        
        a.setID_equipo(e.getID_equipo() + 1);
        a.setNombre(nombre);
        a.setPresidente(presidente);
        a.setID_liga(id_liga);
        
        //escribirEquiposDB4O(a);
        
        equipos.addEquipo(a);
        
    }  
    
    public void aniadirJugadores(Jugador e, String nombre, int edad, int ID_equipo){

        Jugador a = new Jugador();        
        
        a.setID_jugador(e.getID_jugador() + 1);
        a.setNombre(nombre);
        a.setEdad(edad);
        a.setID_equipo(ID_equipo);
        
        //escribirJugadoresDB4O(a);
        
        jugadores.addJugador(a);   
    }  
    
    /*
    public void escribirPaisesDB4O(Pais pa){
        ObjectContainer db = Db4o.openFile("Pais.db");
            
        Pais p = new Pais();
            
        p.setID_pais(pa.getID_pais());
        p.setNombre(pa.getNombre()); 
        p.setZona_horaria(pa.getZona_horaria());
        p.setContinente(pa.getContinente());

        System.out.println(p.getZona_horaria());
        db.store(p);
        
        db.close();
    }
    
    public void updatePaisesDB4O(Pais p){
        ObjectContainer db = Db4o.openFile("Pais.db");
        
        Pais pa = new Pais();
        Query q = db.query();
        q.constrain(Pais.class);  
        q.descend("ID_pais").constrain(new Integer(p.getID_pais())).equal();
        ObjectSet result1= q.execute();
        
        pa = (Pais) result1.next();
        
        pa.setID_pais(p.getID_pais());
        pa.setNombre(p.getNombre());
        pa.setZona_horaria(p.getZona_horaria());
        pa.setContinente(p.getContinente());
        
        db.store(pa);
        
        db.close();
    }
    
    public void borrarPaisesDB4O(int id_pais){
        ObjectContainer db = Db4o.openFile("Pais.db");
        
        Pais pa = new Pais();
        Query q = db.query();
        q.constrain(Pais.class);
        q.descend("ID_pais").constrain(new Integer(id_pais)).equal();
        ObjectSet result1= q.execute();
        
        pa = (Pais) result1.next();
        db.delete(pa);
        
        db.close();
    }
    
    public void leerPaisesDB4O(){
        ObjectContainer db = Db4o.openFile("Pais.db");
        
        Pais pa;
        Query q = db.query();
        q.constrain(Pais.class);
        ObjectSet result1= q.execute();
        
        System.out.println(result1.size());
        while(result1.hasNext()) {

            Pais p = (Pais) result1.next();
            pa = new Pais();
            
            pa.setID_pais(p.getID_pais());
            pa.setNombre(p.getNombre());
            pa.setZona_horaria(p.getZona_horaria());
            pa.setContinente(p.getContinente());
            
            paisComboBox.addItem(pa.getNombre());
            paises.addPais(p);
        }
        db.close();        
    }
    
    public void escribirLigasDB4O(Liga pa){
        ObjectContainer db = Db4o.openFile("Liga.db");

        Liga examplePlayer = new Liga(0,null, 0, 0);
        ObjectSet result = db.queryByExample(examplePlayer);
        db.delete(examplePlayer);
            
        Liga p = new Liga();
            
        p.setID_liga(pa.getID_liga());
        p.setNombre(pa.getNombre()); 
        p.setDivision(pa.getDivision());
        p.setID_pais(pa.getID_pais());

        db.store(p);
        
        db.close();
    }
    
    public void updateLigasDB4O(Liga p){
        ObjectContainer db = Db4o.openFile("Liga.db");
        
        Liga pa = new Liga();
        Query q = db.query();
        q.constrain(Liga.class);  
        q.descend("ID_liga").constrain(new Integer(p.getID_liga())).equal();
        ObjectSet result1= q.execute();
        
        pa = (Liga) result1.next();
        
        pa.setID_liga(p.getID_liga());
        pa.setNombre(p.getNombre());
        pa.setDivision(p.getDivision());
        pa.setID_pais(p.getID_pais());
        
        db.store(pa);
        
        db.close();
    }    
    
    public void borrarLigasDB4O(int id_liga){
        ObjectContainer db = Db4o.openFile("Liga.db");
        
        
        Liga pa = new Liga();
        Query q = db.query();
        q.constrain(Liga.class);
        q.descend("ID_liga").constrain(new Integer(id_liga)).equal();
        ObjectSet result1= q.execute();
        
        pa = (Liga) result1.next();
        db.delete(pa);
        
        db.close();
    }   

    public void leerLigasDB4O(){
        ObjectContainer db = Db4o.openFile("Liga.db");
        
        Liga pa;
        Query q = db.query();
        q.constrain(Liga.class);
        ObjectSet result1= q.execute();
        
        System.out.println(result1.size());
        while(result1.hasNext()) {

            Liga p = (Liga) result1.next();
            pa = new Liga();
            
            pa.setID_liga(p.getID_liga());
            pa.setNombre(p.getNombre());
            pa.setDivision(p.getDivision());
            pa.setID_pais(p.getID_pais());
            
            paisComboBox.addItem(pa.getNombre());
            ligas.addLiga(p);
        }
        db.close();        
    }    
    
    public void escribirEquiposDB4O(Equipo pa){
        ObjectContainer db = Db4o.openFile("Equipo.db");

        Equipo examplePlayer = new Equipo(0,null, null, 0);
        ObjectSet result = db.queryByExample(examplePlayer);
        db.delete(examplePlayer);
            
        Equipo p = new Equipo();
            
        p.setID_equipo(pa.getID_equipo());
        p.setNombre(pa.getNombre()); 
        p.setPresidente(pa.getPresidente());
        p.setID_liga(pa.getID_liga());

        db.store(p);
        
        db.close();
    }
    
    public void updateEquiposDB4O(Equipo p){
        ObjectContainer db = Db4o.openFile("Equipo.db");
        
        Equipo pa = new Equipo();
        Query q = db.query();
        q.constrain(Equipo.class);  
        q.descend("ID_equipo").constrain(new Integer(p.getID_equipo())).equal();
        ObjectSet result1= q.execute();
        
        pa = (Equipo) result1.next();
        
        pa.setID_equipo(p.getID_equipo());
        pa.setNombre(p.getNombre());
        pa.setPresidente(p.getPresidente());
        pa.setID_liga(p.getID_liga());
        
        db.store(pa);
        
        db.close();
    }        
    
    public void borrarEquiposDB4O(int id_equipo){
        ObjectContainer db = Db4o.openFile("Equipo.db");
        
        
        Equipo pa = new Equipo();
        Query q = db.query();
        q.constrain(Equipo.class);
        q.descend("ID_equipo").constrain(new Integer(id_equipo)).equal();
        ObjectSet result1= q.execute();
        
        pa = (Equipo) result1.next();
        db.delete(pa);
        
        db.close();
    }     
    
    public void leerEquiposDB4O(){
        ObjectContainer db = Db4o.openFile("Equipo.db");
        
        Equipo pa;
        Query q = db.query();
        q.constrain(Equipo.class);
        ObjectSet result1= q.execute();
        
        System.out.println(result1.size());
        while(result1.hasNext()) {

            Equipo p = (Equipo) result1.next();
            pa = new Equipo();
            
            pa.setID_equipo(p.getID_equipo());
            pa.setNombre(p.getNombre());
            pa.setPresidente(p.getPresidente());
            pa.setID_liga(p.getID_liga());
            
            paisComboBox.addItem(pa.getNombre());
            equipos.addEquipo(p);
        }
        db.close();        
    }     

    public void escribirJugadoresDB4O(Jugador pa){
        ObjectContainer db = Db4o.openFile("Jugador.db");

        Jugador examplePlayer = new Jugador(0,null, 0, 0);
        ObjectSet result = db.queryByExample(examplePlayer);
        db.delete(examplePlayer);
            
        Jugador p = new Jugador();
            
        p.setID_jugador(pa.getID_jugador());
        p.setNombre(pa.getNombre()); 
        p.setEdad(pa.getEdad());
        p.setID_equipo(pa.getID_equipo());

        db.store(p);
        
        db.close();
    }
    
    public void updateJugadoresDB4O(Jugador p){
        ObjectContainer db = Db4o.openFile("Jugador.db");
        
        Jugador pa = new Jugador();
        Query q = db.query();
        q.constrain(Jugador.class);  
        q.descend("ID_jugador").constrain(new Integer(p.getID_jugador())).equal();
        ObjectSet result1= q.execute();
        
        pa = (Jugador) result1.next();
        
        pa.setID_jugador(p.getID_jugador());
        pa.setNombre(p.getNombre());
        pa.setEdad(p.getEdad());
        pa.setID_equipo(p.getID_equipo());
        
        db.store(pa);
        
        db.close();
    }        
    
    public void borrarJugadoresDB4O(int id_jugador){
        ObjectContainer db = Db4o.openFile("Jugador.db");
        
        
        Jugador pa = new Jugador();
        Query q = db.query();
        q.constrain(Jugador.class);
        q.descend("ID_jugador").constrain(new Integer(id_jugador)).equal();
        ObjectSet result1= q.execute();
        
        pa = (Jugador) result1.next();
        db.delete(pa);
        
        db.close();
    }       
    
    public void leerJugadoresDB4O(){
        ObjectContainer db = Db4o.openFile("Jugador.db");
        
        Jugador pa;
        Query q = db.query();
        q.constrain(Jugador.class);
        ObjectSet result1= q.execute();
        
        System.out.println(result1.size());
        while(result1.hasNext()) {

            Jugador p = (Jugador) result1.next();
            pa = new Jugador();
            
            pa.setID_jugador(p.getID_jugador());
            pa.setNombre(p.getNombre());
            pa.setEdad(p.getEdad());
            pa.setID_equipo(p.getID_equipo());
            
            paisComboBox.addItem(pa.getNombre());
            jugadores.addJugador(p);
        }
        db.close();        
    }     
    */
    /*
    public void escribirPaises() throws FileNotFoundException, IOException{
        
        File borrar = new File("FichPaises.txt");
        borrar.delete();
        File fichero = new File("FichPaises.txt");//declara el fichero
        FileOutputStream fileout = new FileOutputStream(fichero, true);  //crea el flujo de salida
        ObjectOutputStream dataOS = new ObjectOutputStream(fileout); 
            
        Pais p = new Pais();    
        for (int i = 0; i < paises.getSize(); i++) {
            p = paises.getPais(i);
            dataOS.writeObject(p); //escribo la persona en el fichero
            
            //System.out.println("GRABO LOS DATOS DE PERSONA.");
        }
    }
    
    public void escribirLigas() throws FileNotFoundException, IOException{
        
        File borrar = new File("FichLigas.txt");
        borrar.delete();        
        File fichero = new File("FichLigas.txt");//declara el fichero
        FileOutputStream fileout = new FileOutputStream(fichero, true);  //crea el flujo de salida
        ObjectOutputStream dataOS = new ObjectOutputStream(fileout); 
            
        Liga l = new Liga();    
        for (int i = 0; i < ligas.getSize(); i++) {
            l = ligas.getLiga(i);
            dataOS.writeObject(l); //escribo la persona en el fichero
        }
    }    
    
    public void escribirEquipos() throws FileNotFoundException, IOException{
        
        File borrar = new File("FichEquipos.txt");
        borrar.delete();        
        File fichero = new File("FichEquipos.txt");//declara el fichero
        FileOutputStream fileout = new FileOutputStream(fichero, true);  //crea el flujo de salida
        ObjectOutputStream dataOS = new ObjectOutputStream(fileout); 
            
        Equipo e = new Equipo();    
        for (int i = 0; i < equipos.getSize(); i++) {
            e = equipos.getEquipo(i);
            dataOS.writeObject(e); //escribo la persona en el fichero
        }
    }    
    
    public void escribirJugadores() throws FileNotFoundException, IOException{

        File borrar = new File("FichJugadores.txt");
        borrar.delete();        
        File fichero = new File("FichJugadores.txt");//declara el fichero
        FileOutputStream fileout = new FileOutputStream(fichero, true);  //crea el flujo de salida
        ObjectOutputStream dataOS = new ObjectOutputStream(fileout); 
            
        Jugador j = new Jugador();    
        for (int i = 0; i < jugadores.getSize(); i++) {
            j = jugadores.getJugador(i);
            dataOS.writeObject(j); //escribo la persona en el fichero
            //System.out.println("GRABO LOS DATOS DE PERSONA.");
        }
    } 
    
    */
    
    
    public void leerPaises() throws FileNotFoundException, IOException, ClassNotFoundException{
        Pais pais; // defino la variable pais
        pais = new Pais();
	File fichero = new File("FichPaises.txt");
        if(fichero.length() > 0){
            ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fichero));

            int i = 0;
            try {
                while (true) { 
                    pais = (Pais) dataIS.readObject();
                    paisComboBox.addItem(pais.getNombre());
                    paises.addPais(pais);
                    i++;
                }
            } catch (EOFException eo) {
                //System.out.println("FIN DE LECTURA.");
            } catch (StreamCorruptedException x) {
            }

            dataIS.close(); // cerrar stream de entrada
        }
    }

    public void leerLigas() throws FileNotFoundException, IOException, ClassNotFoundException{
        Liga liga;
        liga = new Liga();
	File fichero = new File("FichLigas.txt");
        if(fichero.length() > 0){
            ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fichero));

            int i = 0;
            try {
                while (true) { // lectura del fichero
                    liga = (Liga) dataIS.readObject(); // leer una Persona
                    ligaComboBox.addItem(liga.getNombre());
                    ligas.addLiga(liga);
                    i++;
                }
            } catch (EOFException eo) {
                //System.out.println("FIN DE LECTURA.");
            } catch (StreamCorruptedException x) {
            }

            dataIS.close(); // cerrar stream de entrada
 
        }
    }
    

    public void leerEquipos() throws FileNotFoundException, IOException, ClassNotFoundException{
        Equipo equipo;
        equipo = new Equipo();
	File fichero = new File("FichEquipos.txt");
        if(fichero.length() > 0){
            ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fichero));

            int i = 0;
            try {
                while (true) { // lectura del fichero
                    equipo = (Equipo) dataIS.readObject(); // leer una Persona
                    equipoComboBox.addItem(equipo.getNombre());
                    equipos.addEquipo(equipo);
                    i++;
                }
            } catch (EOFException eo) {
                //System.out.println("FIN DE LECTURA.");
            } catch (StreamCorruptedException x) {
            }

            dataIS.close(); // cerrar stream de entrada
        }
    }
    
    public void leerJugadores() throws FileNotFoundException, IOException, ClassNotFoundException{
        Jugador jugador;
        jugador = new Jugador();
	File fichero = new File("FichJugadores.txt");
        if(fichero.length() > 0){
            ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fichero));

            int i = 0;
            try {
                while (true) { // lectura del fichero
                    jugador = (Jugador) dataIS.readObject(); // leer una Persona
                    jugadores.addJugador(jugador);
                    i++;
                }
            } catch (EOFException eo) {
                //System.out.println("FIN DE LECTURA.");
            } catch (StreamCorruptedException x) {
            }

            dataIS.close(); // cerrar stream de entrada
        }
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollBar1 = new javax.swing.JScrollBar();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        btnAniadir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        nombreLabel = new javax.swing.JLabel();
        apellidoLabel = new javax.swing.JLabel();
        edadLabel = new javax.swing.JLabel();
        repiteLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaPaises = new javax.swing.JList<>();
        IDTexto = new javax.swing.JTextField();
        nombreTexto = new javax.swing.JTextField();
        horarioTexto = new javax.swing.JTextField();
        continenteTexto = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnGuardarCambios = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnModificar2 = new javax.swing.JButton();
        btnAniadir2 = new javax.swing.JButton();
        btnCancelar2 = new javax.swing.JButton();
        nombreLabel1 = new javax.swing.JLabel();
        apellidoLabel1 = new javax.swing.JLabel();
        edadLabel1 = new javax.swing.JLabel();
        repiteLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaLigas = new javax.swing.JList<>();
        IDTexto2 = new javax.swing.JTextField();
        nombreTexto2 = new javax.swing.JTextField();
        divisionTexto = new javax.swing.JTextField();
        btnGuardar2 = new javax.swing.JButton();
        btnBorrar2 = new javax.swing.JButton();
        btnGuardarCambios2 = new javax.swing.JButton();
        paisComboBox = new javax.swing.JComboBox<>();
        repiteLabel4 = new javax.swing.JLabel();
        paisTexto = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnModificar3 = new javax.swing.JButton();
        btnAniadir3 = new javax.swing.JButton();
        btnCancelar3 = new javax.swing.JButton();
        nombreLabel2 = new javax.swing.JLabel();
        apellidoLabel2 = new javax.swing.JLabel();
        edadLabel2 = new javax.swing.JLabel();
        repiteLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaEquipos = new javax.swing.JList<>();
        IDTexto3 = new javax.swing.JTextField();
        nombreTexto3 = new javax.swing.JTextField();
        presidenteTexto = new javax.swing.JTextField();
        btnGuardar3 = new javax.swing.JButton();
        btnBorrar3 = new javax.swing.JButton();
        ligaComboBox = new javax.swing.JComboBox<>();
        btnGuardarCambios3 = new javax.swing.JButton();
        repiteLabel5 = new javax.swing.JLabel();
        ligaTexto = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btnModificar4 = new javax.swing.JButton();
        btnAniadir4 = new javax.swing.JButton();
        btnCancelar4 = new javax.swing.JButton();
        nombreLabel3 = new javax.swing.JLabel();
        apellidoLabel3 = new javax.swing.JLabel();
        edadLabel3 = new javax.swing.JLabel();
        repiteLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaJugadores = new javax.swing.JList<>();
        IDTexto4 = new javax.swing.JTextField();
        nombreTexto4 = new javax.swing.JTextField();
        equipoTexto = new javax.swing.JTextField();
        btnGuardar4 = new javax.swing.JButton();
        btnBorrar4 = new javax.swing.JButton();
        btnGuardarCambios4 = new javax.swing.JButton();
        equipoComboBox = new javax.swing.JComboBox<>();
        repiteLabel6 = new javax.swing.JLabel();
        edadTexto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane2MouseClicked(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnAniadir.setText("Añadir");
        btnAniadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAniadirActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        nombreLabel.setText("ID Pais:");

        apellidoLabel.setText("Nombre:");

        edadLabel.setText("Zona_horaria:");

        repiteLabel.setText("Continente");

        listaPaises.setModel(paises);
        listaPaises.setToolTipText("");
        listaPaises.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaPaisesMouseClicked(evt);
            }
        });
        listaPaises.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaPaisesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaPaises);

        IDTexto.setEditable(false);

        nombreTexto.setEditable(false);

        horarioTexto.setEditable(false);

        continenteTexto.setEditable(false);
        continenteTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continenteTextoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnGuardarCambios.setText("Guardar Cambios");
        btnGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCambiosActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(nombreTexto)
                                .addGap(54, 54, 54))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(IDTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nombreLabel)
                                    .addComponent(apellidoLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(repiteLabel)
                            .addComponent(edadLabel)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(continenteTexto, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                .addComponent(horarioTexto)))
                        .addGap(17, 17, 17)))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnGuardarCambios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAniadir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnAniadir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBorrar)
                        .addGap(14, 14, 14)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuardarCambios)
                        .addGap(33, 33, 33)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombreLabel)
                            .addComponent(edadLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IDTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(horarioTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(apellidoLabel)
                            .addComponent(repiteLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombreTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(continenteTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)
                        .addGap(1, 1, 1)))
                .addComponent(btnSalir)
                .addGap(0, 35, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Pais", jPanel2);

        btnModificar2.setText("Modificar");
        btnModificar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar2ActionPerformed(evt);
            }
        });

        btnAniadir2.setText("Añadir");
        btnAniadir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAniadir2ActionPerformed(evt);
            }
        });

        btnCancelar2.setText("Cancelar");
        btnCancelar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar2ActionPerformed(evt);
            }
        });

        nombreLabel1.setText("ID Liga");

        apellidoLabel1.setText("Nombre");

        edadLabel1.setText("Division");

        repiteLabel1.setText("Elegir Pais");

        listaLigas.setModel(ligas);
        listaLigas.setToolTipText("");
        listaLigas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaLigasMouseClicked(evt);
            }
        });
        listaLigas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaLigasValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listaLigas);

        IDTexto2.setEditable(false);

        nombreTexto2.setEditable(false);

        divisionTexto.setEditable(false);

        btnGuardar2.setText("Guardar");
        btnGuardar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar2ActionPerformed(evt);
            }
        });

        btnBorrar2.setText("Borrar");
        btnBorrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrar2ActionPerformed(evt);
            }
        });

        btnGuardarCambios2.setText("Guardar Cambios");
        btnGuardarCambios2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCambios2ActionPerformed(evt);
            }
        });

        paisComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paisComboBoxActionPerformed(evt);
            }
        });

        repiteLabel4.setText("Pais");

        paisTexto.setEditable(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreLabel1)
                            .addComponent(IDTexto2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(apellidoLabel1)
                            .addComponent(nombreTexto2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(edadLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelar2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(repiteLabel4)
                                    .addComponent(paisTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(divisionTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(0, 1, Short.MAX_VALUE)
                                        .addComponent(repiteLabel1)
                                        .addGap(54, 54, 54))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(paisComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane2)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnGuardarCambios2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnModificar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnBorrar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAniadir2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGuardar2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnAniadir2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBorrar2)
                        .addGap(9, 9, 9)
                        .addComponent(btnModificar2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuardarCambios2)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar2)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(nombreLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(edadLabel1)
                                    .addComponent(btnCancelar2))
                                .addGap(3, 3, 3)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(divisionTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IDTexto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(apellidoLabel1)
                            .addComponent(repiteLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombreTexto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(paisTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(paisComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(repiteLabel1)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 61, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Liga", jPanel1);

        btnModificar3.setText("Modificar");
        btnModificar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar3ActionPerformed(evt);
            }
        });

        btnAniadir3.setText("Añadir");
        btnAniadir3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAniadir3ActionPerformed(evt);
            }
        });

        btnCancelar3.setText("Cancelar");
        btnCancelar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar3ActionPerformed(evt);
            }
        });

        nombreLabel2.setText("ID Equipo");

        apellidoLabel2.setText("Nombre");

        edadLabel2.setText("Presidente");

        repiteLabel2.setText("Selecciona una liga");

        listaEquipos.setModel(equipos);
        listaEquipos.setToolTipText("");
        listaEquipos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaEquiposMouseClicked(evt);
            }
        });
        listaEquipos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaEquiposValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(listaEquipos);

        IDTexto3.setEditable(false);

        nombreTexto3.setEditable(false);

        presidenteTexto.setEditable(false);

        btnGuardar3.setText("Guardar");
        btnGuardar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar3ActionPerformed(evt);
            }
        });

        btnBorrar3.setText("Borrar");
        btnBorrar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrar3ActionPerformed(evt);
            }
        });

        ligaComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ligaComboBoxActionPerformed(evt);
            }
        });

        btnGuardarCambios3.setText("Guardar Cambios");
        btnGuardarCambios3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCambios3ActionPerformed(evt);
            }
        });

        repiteLabel5.setText("Liga");

        ligaTexto.setEditable(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nombreLabel2)
                                .addComponent(IDTexto3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(apellidoLabel2))
                            .addComponent(nombreTexto3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(repiteLabel5)
                            .addComponent(presidenteTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edadLabel2)
                            .addComponent(ligaTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(repiteLabel2)
                                    .addComponent(ligaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnBorrar3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnModificar3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnGuardarCambios3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnAniadir3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(btnGuardar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLabel2)
                    .addComponent(edadLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDTexto3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(presidenteTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellidoLabel2)
                    .addComponent(repiteLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreTexto3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ligaTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnAniadir3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBorrar3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardarCambios3)
                .addGap(32, 32, 32)
                .addComponent(btnGuardar3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar3)
                .addGap(27, 27, 27)
                .addComponent(repiteLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ligaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Equipo", jPanel3);

        btnModificar4.setText("Modificar");
        btnModificar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar4ActionPerformed(evt);
            }
        });

        btnAniadir4.setText("Añadir");
        btnAniadir4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAniadir4ActionPerformed(evt);
            }
        });

        btnCancelar4.setText("Cancelar");
        btnCancelar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar4ActionPerformed(evt);
            }
        });

        nombreLabel3.setText("ID Jugador");

        apellidoLabel3.setText("Nombre");

        edadLabel3.setText("Edad");

        repiteLabel3.setText("Elige el equipo");

        listaJugadores.setModel(jugadores);
        listaJugadores.setToolTipText("");
        listaJugadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaJugadoresMouseClicked(evt);
            }
        });
        listaJugadores.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaJugadoresValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(listaJugadores);

        IDTexto4.setEditable(false);

        nombreTexto4.setEditable(false);

        equipoTexto.setEditable(false);

        btnGuardar4.setText("Guardar");
        btnGuardar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar4ActionPerformed(evt);
            }
        });

        btnBorrar4.setText("Borrar");
        btnBorrar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrar4ActionPerformed(evt);
            }
        });

        btnGuardarCambios4.setText("Guardar Cambios");
        btnGuardarCambios4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCambios4ActionPerformed(evt);
            }
        });

        equipoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equipoComboBoxActionPerformed(evt);
            }
        });

        repiteLabel6.setText("Equipo");

        edadTexto.setEditable(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nombreLabel3)
                            .addComponent(apellidoLabel3)
                            .addComponent(nombreTexto4, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(IDTexto4))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edadTexto)
                            .addComponent(equipoTexto)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(repiteLabel6)
                                    .addComponent(edadLabel3))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnAniadir4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(repiteLabel3)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnGuardar4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnBorrar4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnModificar4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnGuardarCambios4, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnCancelar4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(equipoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAniadir4)
                        .addGap(32, 32, 32)
                        .addComponent(btnBorrar4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardarCambios4)
                        .addGap(25, 25, 25)
                        .addComponent(btnGuardar4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar4))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreLabel3)
                    .addComponent(edadLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDTexto4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edadTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(apellidoLabel3)
                            .addComponent(repiteLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombreTexto4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(equipoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(repiteLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(equipoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 385, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        jTabbedPane2.addTab("Jugador", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane2MouseClicked
        btnBorrar.setBackground(Color.LIGHT_GRAY);
        btnBorrar2.setBackground(Color.LIGHT_GRAY);
        btnBorrar3.setBackground(Color.LIGHT_GRAY);
        btnBorrar4.setBackground(Color.LIGHT_GRAY);      
    }//GEN-LAST:event_jTabbedPane2MouseClicked

    private void equipoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equipoComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_equipoComboBoxActionPerformed

    private void btnGuardarCambios4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambios4ActionPerformed
        
        Jugador l = new Jugador();
        Equipo p = new Equipo();
        int edad = 0;
        String nombre_equipo = "NULL";
        int id_equipo = 0;
        boolean encontrado = false;

        //Para que al guardar me guarde el cambio de pais, ARREGLAR SI SE PUDIESE
        nombre_equipo = (String) equipoComboBox.getSelectedItem();
        for(int i = 0; i < equipos.getSize() && encontrado == false; i++){
            p = equipos.getEquipo(i);
            if(p.getNombre() == nombre_equipo){
                id_equipo = p.getID_equipo();
                encontrado = true;
            }else{
                encontrado = false;
            }
        }

        l =  jugadores.getJugador(listaJugadores.getSelectedIndex());
        edad = Integer.parseInt(edadTexto.getText());

        l.setNombre(nombreTexto4.getText());
        l.setEdad(edad);
        l.setID_equipo(id_equipo);
        
        //updateJugadoresDB4O(l);

        nombreTexto4.setEditable(false);
        equipoTexto.setEditable(false);

        btnAniadir4.setEnabled(true);
        btnGuardar4.setEnabled(true);

        btnModificar4.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_btnGuardarCambios4ActionPerformed

    private void btnBorrar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrar4ActionPerformed
        try{

            Jugador p = new Jugador();
            boolean encontrado = false;
            int posicion_jugador = 0;

            posicion_jugador = listaJugadores.getSelectedIndex();

            p = jugadores.getJugador(posicion_jugador);
            
            //borrarJugadoresDB4O(p.getID_jugador());

            //System.out.println("yeyoo");
            jugadores.eliminarJugador(posicion_jugador);

        }catch(Exception e){
            System.out.println("Ha ocurrido un error en la ejecucion");
        }

        IDTexto3.setText("");
        nombreTexto3.setText("");
        presidenteTexto.setText("");
        ligaTexto.setText("");
    }//GEN-LAST:event_btnBorrar4ActionPerformed

    private void btnGuardar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar4ActionPerformed

        Jugador j = new Jugador();
        Equipo e = new Equipo();

        if(jugadores.getSize() != 0){
            j = jugadores.getJugador(jugadores.getSize() - 1);
        }

        //Para pasarle el id del equipo al que se va a asociar
        int posicion_equipo = 0;
        posicion_equipo = equipoComboBox.getSelectedIndex();
        e = equipos.getEquipo(posicion_equipo);

        int edad = 0;
        edad = Integer.parseInt(edadTexto.getText());

        aniadirJugadores(j, nombreTexto4.getText(), edad, e.getID_equipo());

        nombreTexto4.setEditable(false);
        edadTexto.setEditable(false);

        btnBorrar4.setEnabled(true);
        btnModificar4.setEnabled(true);
        btnGuardarCambios4.setEnabled(true);

        IDTexto4.setText("");
        nombreTexto4.setText("");
        edadTexto.setText("");
        equipoTexto.setText("");

        btnAniadir4.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_btnGuardar4ActionPerformed

    private void listaJugadoresValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaJugadoresValueChanged

    }//GEN-LAST:event_listaJugadoresValueChanged

    private void listaJugadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaJugadoresMouseClicked

        nombreTexto4.setEditable(false);
        edadTexto.setEditable(false);

        Jugador j = new Jugador();

        j = jugadores.getJugador(listaJugadores.getSelectedIndex());

        String id = "NULL";
        String edad = "NULL";

        edad = String.valueOf(j.getEdad());

        id = String.valueOf(j.getID_jugador());

        IDTexto4.setText(id);
        nombreTexto4.setText(j.getNombre());
        edadTexto.setText(edad);
        //PARA INSERTAR EL NOMBRE DE EL PAIS A TRAVES DE EL ID ASOCIADO DE LA CLASE
        for(int i = 0; i < equipos.getSize(); i++){
            Equipo a = new Equipo();
            a = equipos.getEquipo(i);
            if(j.getID_equipo()== a.getID_equipo()){
                equipoTexto.setText(a.getNombre());
                equipoComboBox.setSelectedItem(a.getNombre());
            }
        }
        
        
    }//GEN-LAST:event_listaJugadoresMouseClicked

    private void btnCancelar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar4ActionPerformed
        btnAniadir4.setBackground(Color.LIGHT_GRAY);
        btnModificar4.setBackground(Color.LIGHT_GRAY);

        btnAniadir4.setEnabled(true);
        btnGuardar4.setEnabled(true);
        btnBorrar4.setEnabled(true);
        if(jugadores.getSize() != 0){
            btnModificar4.setEnabled(true);
            btnGuardarCambios4.setEnabled(true);
        }

        nombreTexto4.setEditable(false);
        edadTexto.setEditable(false);            
        
        IDTexto4.setText("");
        nombreTexto4.setText("");
        edadTexto.setText("");
        equipoTexto.setText("");
    }//GEN-LAST:event_btnCancelar4ActionPerformed

    private void btnAniadir4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAniadir4ActionPerformed
        btnAniadir4.setBackground(Color.green);

        nombreTexto4.setEditable(true);
        edadTexto.setEditable(true);

        btnBorrar4.setEnabled(false);
        btnModificar4.setEnabled(false);
        btnGuardarCambios4.setEnabled(false);

        IDTexto4.setText("");
        nombreTexto4.setText("");
        edadTexto.setText("");
        equipoTexto.setText("");
    }//GEN-LAST:event_btnAniadir4ActionPerformed

    private void btnModificar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar4ActionPerformed

        btnModificar4.setBackground(Color.yellow);

        nombreTexto4.setEditable(true);
        edadTexto.setEditable(true);

        btnAniadir4.setEnabled(false);
        btnGuardar4.setEnabled(false);
    }//GEN-LAST:event_btnModificar4ActionPerformed

    private void btnGuardarCambios3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambios3ActionPerformed
        Equipo l = new Equipo();
        Liga p = new Liga();
        
        String nombre_liga = "NULL";
        int id_liga = 0;
        boolean encontrado = false;

        //Para que al guardar me guarde el cambio de pais, ARREGLAR SI SE PUDIESE
        nombre_liga = (String) ligaComboBox.getSelectedItem();
        for(int i = 0; i < ligas.getSize() && encontrado == false; i++){
            p = ligas.getLiga(i);
            if(p.getNombre() == nombre_liga){
                id_liga = p.getID_liga();
                encontrado = true;
            }else{
                encontrado = false;
            }
        }

        System.out.println(p.getID_pais());

        l =  equipos.getEquipo(listaEquipos.getSelectedIndex());

        //EL TERCERO ES EL CAMBIO DE PAIS, ARREGLAR SI SE PUDIESE
        l.setNombre(nombreTexto3.getText());
        l.setPresidente(presidenteTexto.getText());
        l.setID_liga(id_liga);    
        
        //updateEquiposDB4O(l);
        
        equipoComboBox.insertItemAt(nombreTexto3.getText(), listaEquipos.getSelectedIndex());
        equipoComboBox.removeItemAt(listaEquipos.getSelectedIndex() + 1);

        nombreTexto3.setEditable(false);
        presidenteTexto.setEditable(false);

        btnAniadir3.setEnabled(true);
        btnGuardar3.setEnabled(true);

        btnModificar3.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_btnGuardarCambios3ActionPerformed

    private void ligaComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ligaComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ligaComboBoxActionPerformed

    private void btnBorrar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrar3ActionPerformed
        try{

            Equipo p = new Equipo();
            boolean encontrado = false;
            int posicion_equipo = 0;

            posicion_equipo = listaEquipos.getSelectedIndex();

            p = equipos.getEquipo(posicion_equipo);
            
            //borrarEquiposDB4O(p.getID_equipo());

            for(int i = 0; i < jugadores.getSize() && encontrado == false; i++){
                Jugador l = new Jugador();
                l = jugadores.getJugador(i);
                if(p.getID_equipo()== l.getID_equipo()){
                    encontrado = true;
                }else{
                    encontrado = false;
                }
            }

            if(encontrado == true){
                btnBorrar3.setBackground(Color.red);
            }else{
                btnBorrar3.setBackground(Color.green);
                equipoComboBox.removeItem(nombreTexto3.getText());
                equipos.eliminarEquipo(posicion_equipo);
            }

        }catch(Exception e){
            System.out.println("Ha ocurrido un error en la ejecucion");
        }

        IDTexto3.setText("");
        nombreTexto3.setText("");
        presidenteTexto.setText("");
        ligaTexto.setText("");
    }//GEN-LAST:event_btnBorrar3ActionPerformed

    private void btnGuardar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar3ActionPerformed

        Equipo e = new Equipo();
        Liga a = new Liga();

        if(equipos.getSize() != 0){
            e = equipos.getEquipo(equipos.getSize() - 1);
        }

        int posicion_liga = 0;

        posicion_liga = ligaComboBox.getSelectedIndex();
        a = ligas.getLiga(posicion_liga);

        //TODO: ARREGLAR EL COMBO BOX
        aniadirEquipos(e, nombreTexto3.getText(), presidenteTexto.getText(), a.getID_liga());
        equipoComboBox.addItem(nombreTexto3.getText());

        nombreTexto3.setEditable(false);
        presidenteTexto.setEditable(false);

        btnBorrar3.setEnabled(true);
        btnModificar3.setEnabled(true);
        btnGuardarCambios3.setEnabled(true);

        IDTexto3.setText("");
        nombreTexto3.setText("");
        presidenteTexto.setText("");

        btnAniadir3.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_btnGuardar3ActionPerformed

    private void listaEquiposValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaEquiposValueChanged

    }//GEN-LAST:event_listaEquiposValueChanged

    private void listaEquiposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaEquiposMouseClicked

        nombreTexto3.setEditable(false);
        presidenteTexto.setEditable(false);

        Equipo e = new Equipo();

        e = equipos.getEquipo(listaEquipos.getSelectedIndex());

        String id = "NULL";

        id = String.valueOf(e.getID_equipo());

        IDTexto3.setText(id);
        nombreTexto3.setText(e.getNombre());
        presidenteTexto.setText(e.getPresidente());
        //PARA INSERTAR EL NOMBRE DE EL PAIS A TRAVES DE EL ID ASOCIADO DE LA CLASE
        for(int i = 0; i < ligas.getSize(); i++){
            Liga a = new Liga();
            a = ligas.getLiga(i);
            if(e.getID_liga() == a.getID_liga()){
                ligaTexto.setText(a.getNombre());
                ligaComboBox.setSelectedItem(a.getNombre());
            }
        }
    }//GEN-LAST:event_listaEquiposMouseClicked

    private void btnCancelar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar3ActionPerformed
        btnAniadir3.setBackground(Color.LIGHT_GRAY);
        btnModificar3.setBackground(Color.LIGHT_GRAY);

        btnAniadir3.setEnabled(true);
        btnGuardar3.setEnabled(true);
        btnBorrar3.setEnabled(true);

        if(equipos.getSize() != 0){
            btnModificar3.setEnabled(true);
            btnGuardarCambios3.setEnabled(true);
        }

        nombreTexto3.setEditable(false);
        presidenteTexto.setEditable(false);      
        
        IDTexto3.setText("");
        nombreTexto3.setText("");
        presidenteTexto.setText("");
        ligaTexto.setText("");
    }//GEN-LAST:event_btnCancelar3ActionPerformed

    private void btnAniadir3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAniadir3ActionPerformed
        nombreTexto3.setEditable(true);
        presidenteTexto.setEditable(true);

        btnAniadir3.setBackground(Color.green);

        btnBorrar3.setEnabled(false);
        btnModificar3.setEnabled(false);
        btnGuardarCambios3.setEnabled(false);

        IDTexto3.setText("");
        nombreTexto3.setText("");
        presidenteTexto.setText("");
        ligaTexto.setText("");
    }//GEN-LAST:event_btnAniadir3ActionPerformed

    private void btnModificar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar3ActionPerformed

        btnModificar3.setBackground(Color.yellow);

        nombreTexto3.setEditable(true);
        presidenteTexto.setEditable(true);

        btnAniadir3.setEnabled(false);
        btnGuardar3.setEnabled(false);
    }//GEN-LAST:event_btnModificar3ActionPerformed

    private void paisComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paisComboBoxActionPerformed

    }//GEN-LAST:event_paisComboBoxActionPerformed

    private void btnGuardarCambios2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambios2ActionPerformed
        Liga l = new Liga();
        Pais p = new Pais();
        int division = 0;
        String nombre_pais = "NULL";
        int id_pais = 0;
        boolean encontrado = false;

        //Para que al guardar me guarde el cambio de pais, ARREGLAR SI SE PUDIESE
        nombre_pais = (String) paisComboBox.getSelectedItem();
        for(int i = 0; i < paises.getSize() && encontrado == false; i++){
            p = paises.getPais(i);
            if(p.getNombre() == nombre_pais){
                id_pais = p.getID_pais();
                encontrado = true;
            }else{
                encontrado = false;
            }
        }

        System.out.println(p.getID_pais());

        l =  ligas.getLiga(listaLigas.getSelectedIndex());
        division = Integer.parseInt(divisionTexto.getText());

        //EL TERCERO ES EL CAMBIO DE PAIS, ARREGLAR SI SE PUDIESE
        l.setNombre(nombreTexto2.getText());
        l.setDivision(division);
        l.setID_pais(id_pais);
        
        //updateLigasDB4O(l);

        ligaComboBox.insertItemAt(nombreTexto2.getText(), listaLigas.getSelectedIndex());
        ligaComboBox.removeItemAt(listaLigas.getSelectedIndex() + 1);

        nombreTexto2.setEditable(false);
        divisionTexto.setEditable(false);

        btnAniadir2.setEnabled(true);
        btnGuardar2.setEnabled(true);

        btnModificar2.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_btnGuardarCambios2ActionPerformed

    private void btnBorrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrar2ActionPerformed
        try{

            Liga p = new Liga();
            boolean encontrado = false;
            int posicion_liga = 0;

            posicion_liga = listaLigas.getSelectedIndex();

            p = ligas.getLiga(posicion_liga);
            
            //borrarLigasDB4O(p.getID_liga());
            for(int i = 0; i < equipos.getSize() && encontrado == false; i++){
                Equipo l = new Equipo();
                l = equipos.getEquipo(i);
                if(p.getID_liga()== l.getID_liga()){
                    encontrado = true;
                }else{
                    encontrado = false;
                }
            }

            if(encontrado == true){
                btnBorrar2.setBackground(Color.red);
            }else{
                btnBorrar2.setBackground(Color.green);
                ligaComboBox.removeItem(nombreTexto2.getText());
                ligas.eliminarLiga(posicion_liga);
            }

        }catch(Exception e){
            System.out.println("Ha ocurrido un error en la ejecucion");
        }

        IDTexto2.setText("");
        nombreTexto2.setText("");
        divisionTexto.setText("");
        paisTexto.setText("");
    }//GEN-LAST:event_btnBorrar2ActionPerformed

    private void btnGuardar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar2ActionPerformed

        Liga l = new Liga();
        Pais e = new Pais();

        if(ligas.getSize() != 0){
            l = ligas.getLiga(ligas.getSize() - 1);
        }

        int division = 0;
        int posicion_pais = 0;

        division = Integer.parseInt(divisionTexto.getText());

        posicion_pais = paisComboBox.getSelectedIndex();
        e = paises.getPais(posicion_pais);

        aniadirLigas(l.getID_liga(), nombreTexto2.getText(), division, e.getID_pais());
        ligaComboBox.addItem(nombreTexto2.getText());

        nombreTexto2.setEditable(false);
        divisionTexto.setEditable(false);

        btnBorrar2.setEnabled(true);
        btnModificar2.setEnabled(true);
        btnGuardarCambios2.setEnabled(true);

        IDTexto2.setText("");
        nombreTexto2.setText("");
        divisionTexto.setText("");
        paisTexto.setText("");

        btnAniadir2.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_btnGuardar2ActionPerformed

    private void listaLigasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaLigasValueChanged

    }//GEN-LAST:event_listaLigasValueChanged

    private void listaLigasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaLigasMouseClicked

        nombreTexto2.setEditable(false);
        divisionTexto.setEditable(false);

        Liga l = new Liga();

        l = ligas.getLiga(listaLigas.getSelectedIndex());

        String id = "NULL";
        String division = "NULL";

        division = String.valueOf(l.getDivision());
        id = String.valueOf(l.getID_liga());

        IDTexto2.setText(id);
        nombreTexto2.setText(l.getNombre());
        divisionTexto.setText(division);

        //PARA INSERTAR EL NOMBRE DE EL PAIS A TRAVES DE EL ID ASOCIADO DE LA CLASE
        for(int i = 0; i < paises.getSize(); i++){
            Pais e = new Pais();
            e = paises.getPais(i);
            if(l.getID_pais() == e.getID_pais()){
                paisTexto.setText(e.getNombre());
                paisComboBox.setSelectedItem(e.getNombre());
            }
        }
    }//GEN-LAST:event_listaLigasMouseClicked

    private void btnCancelar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar2ActionPerformed
        btnAniadir2.setBackground(Color.LIGHT_GRAY);
        btnModificar2.setBackground(Color.LIGHT_GRAY);

        btnAniadir2.setEnabled(true);
        btnGuardar2.setEnabled(true);
        btnBorrar2.setEnabled(true);
        if(ligas.getSize() != 0){
            btnModificar2.setEnabled(true);
            btnGuardarCambios2.setEnabled(true);
        }

        nombreTexto2.setEditable(false);
        divisionTexto.setEditable(false);       
        
        IDTexto2.setText("");
        nombreTexto2.setText("");
        divisionTexto.setText("");
        paisTexto.setText("");
    }//GEN-LAST:event_btnCancelar2ActionPerformed

    private void btnAniadir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAniadir2ActionPerformed

        btnAniadir2.setBackground(Color.green);

        nombreTexto2.setEditable(true);
        divisionTexto.setEditable(true);

        btnBorrar2.setEnabled(false);
        btnModificar2.setEnabled(false);
        btnGuardarCambios2.setEnabled(false);

        IDTexto2.setText("");
        nombreTexto2.setText("");
        divisionTexto.setText("");
        paisTexto.setText("");
    }//GEN-LAST:event_btnAniadir2ActionPerformed

    private void btnModificar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar2ActionPerformed

        btnModificar2.setBackground(Color.yellow);

        nombreTexto2.setEditable(true);
        divisionTexto.setEditable(true);

        btnAniadir2.setEnabled(false);
        btnGuardar2.setEnabled(false);
    }//GEN-LAST:event_btnModificar2ActionPerformed

    private void btnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosActionPerformed
        Pais p = new Pais();

        p =  paises.getPais(listaPaises.getSelectedIndex());

        p.setNombre(nombreTexto.getText());
        p.setZona_horaria(horarioTexto.getText());
        p.setContinente(continenteTexto.getText());
        
        //updatePaisesDB4O(p);
        updatePaisesXML(p.getID_pais(), p.getNombre(), p.getZona_horaria(), p.getContinente());

        paisComboBox.insertItemAt(nombreTexto.getText(), listaPaises.getSelectedIndex());
        paisComboBox.removeItemAt(listaPaises.getSelectedIndex() + 1);

        nombreTexto.setEditable(false);
        horarioTexto.setEditable(false);
        continenteTexto.setEditable(false);

        btnAniadir.setEnabled(true);
        btnGuardar.setEnabled(true);

        btnModificar.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_btnGuardarCambiosActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        try{

            Pais p = new Pais();
            boolean encontrado = false;
            int posicion_pais = 0;

            posicion_pais = listaPaises.getSelectedIndex();

            p = paises.getPais(posicion_pais);
            
            borrarPaisesXML(p.getID_pais());
            
            for(int i = 0; i < ligas.getSize() && encontrado == false; i++){
                Liga l = new Liga();
                l = ligas.getLiga(i);
                if(p.getID_pais()== l.getID_pais()){
                    encontrado = true;
                }else{
                    encontrado = false;
                }
            }

            if(encontrado == true){
                btnBorrar.setBackground(Color.red);
            }else{
                btnBorrar.setBackground(Color.green);
                paisComboBox.removeItem(nombreTexto.getText());
                paises.eliminarPais(posicion_pais);
            }

        }catch(Exception e){
            System.out.println("Ha ocurrido un error en la ejecucion");
        }

        IDTexto.setText("");
        nombreTexto.setText("");
        horarioTexto.setText("");
        continenteTexto.setText("");
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        Pais p = new Pais();

        if(paises.getSize() != 0){
            p = paises.getPais(paises.getSize() - 1);
        }

        aniadirPaises(p, nombreTexto.getText(), horarioTexto.getText(), continenteTexto.getText());       
        paisComboBox.addItem(nombreTexto.getText());

        IDTexto.setText("");
        nombreTexto.setText("");
        horarioTexto.setText("");
        continenteTexto.setText("");

        IDTexto.setEditable(false);
        nombreTexto.setEditable(false);
        horarioTexto.setEditable(false);
        continenteTexto.setEditable(false);

        btnBorrar.setEnabled(true);
        btnModificar.setEnabled(true);
        btnGuardarCambios.setEnabled(true);

        btnAniadir.setBackground(Color.LIGHT_GRAY);

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void continenteTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continenteTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_continenteTextoActionPerformed

    private void listaPaisesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaPaisesValueChanged

    }//GEN-LAST:event_listaPaisesValueChanged

    private void listaPaisesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaPaisesMouseClicked

        try{
            nombreTexto.setEditable(false);
            horarioTexto.setEditable(false);
            continenteTexto.setEditable(false);

            Pais a = new Pais();

            a = paises.getPais(listaPaises.getSelectedIndex());

            String id = "";

            id = String.valueOf(a.getID_pais());

            IDTexto.setText(id);
            nombreTexto.setText(a.getNombre());
            horarioTexto.setText(a.getZona_horaria());
            continenteTexto.setText(a.getContinente());
        }catch(Exception e){
            System.out.println("Todo controlado bro");
        }
    }//GEN-LAST:event_listaPaisesMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        btnAniadir.setBackground(Color.LIGHT_GRAY);
        btnModificar.setBackground(Color.LIGHT_GRAY);
        btnBorrar.setBackground(Color.LIGHT_GRAY);

        btnAniadir.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnBorrar.setEnabled(true);
        if(paises.getSize() != 0){
            btnModificar.setEnabled(true);
            btnGuardarCambios.setEnabled(true);
        }

        nombreTexto.setEditable(false);
        horarioTexto.setEditable(false);
        continenteTexto.setEditable(false);         
        
        IDTexto.setText("");
        nombreTexto.setText("");
        horarioTexto.setText("");
        continenteTexto.setText("");
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAniadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAniadirActionPerformed

        btnAniadir.setBackground(Color.green);
        btnBorrar.setBackground(Color.LIGHT_GRAY);

        nombreTexto.setEditable(true);
        horarioTexto.setEditable(true);
        continenteTexto.setEditable(true);

        btnBorrar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnGuardarCambios.setEnabled(false);

        IDTexto.setText("");
        nombreTexto.setText("");
        horarioTexto.setText("");
        continenteTexto.setText("");

    }//GEN-LAST:event_btnAniadirActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        btnModificar.setBackground(Color.yellow);
        btnBorrar.setBackground(Color.LIGHT_GRAY);

        nombreTexto.setEditable(true);
        horarioTexto.setEditable(true);
        continenteTexto.setEditable(true);

        btnAniadir.setEnabled(false);
        btnGuardar.setEnabled(false);

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
/*
        try {
            this.escribirPaises();
            this.escribirLigas();
            this.escribirEquipos();
            this.escribirJugadores();
        } catch (IOException ex) {
            System.out.println("Ha pasao algo bro");
        }
*/        
       System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {

                VistaFutbol vista = new VistaFutbol();
                
                vista.updatePaises();
                System.out.println("Hecho");
                
                vista.leerPaisesXML();
                
                System.out.println("BRO");
                //vista.leerLigasDB4O();
                //vista.leerEquiposDB4O();
                //vista.leerJugadoresDB4O();
                
                vista.setVisible(true);
            }
       
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IDTexto;
    private javax.swing.JTextField IDTexto2;
    private javax.swing.JTextField IDTexto3;
    private javax.swing.JTextField IDTexto4;
    private javax.swing.JLabel apellidoLabel;
    private javax.swing.JLabel apellidoLabel1;
    private javax.swing.JLabel apellidoLabel2;
    private javax.swing.JLabel apellidoLabel3;
    private javax.swing.JButton btnAniadir;
    private javax.swing.JButton btnAniadir2;
    private javax.swing.JButton btnAniadir3;
    private javax.swing.JButton btnAniadir4;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBorrar2;
    private javax.swing.JButton btnBorrar3;
    private javax.swing.JButton btnBorrar4;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelar2;
    private javax.swing.JButton btnCancelar3;
    private javax.swing.JButton btnCancelar4;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardar2;
    private javax.swing.JButton btnGuardar3;
    private javax.swing.JButton btnGuardar4;
    private javax.swing.JButton btnGuardarCambios;
    private javax.swing.JButton btnGuardarCambios2;
    private javax.swing.JButton btnGuardarCambios3;
    private javax.swing.JButton btnGuardarCambios4;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnModificar2;
    private javax.swing.JButton btnModificar3;
    private javax.swing.JButton btnModificar4;
    private javax.swing.JButton btnSalir;
    private javax.swing.JTextField continenteTexto;
    private javax.swing.JTextField divisionTexto;
    private javax.swing.JLabel edadLabel;
    private javax.swing.JLabel edadLabel1;
    private javax.swing.JLabel edadLabel2;
    private javax.swing.JLabel edadLabel3;
    private javax.swing.JTextField edadTexto;
    private javax.swing.JComboBox<String> equipoComboBox;
    private javax.swing.JTextField equipoTexto;
    private javax.swing.JTextField horarioTexto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JComboBox<String> ligaComboBox;
    private javax.swing.JTextField ligaTexto;
    private javax.swing.JList<String> listaEquipos;
    private javax.swing.JList<String> listaJugadores;
    private javax.swing.JList<String> listaLigas;
    private javax.swing.JList<String> listaPaises;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JLabel nombreLabel1;
    private javax.swing.JLabel nombreLabel2;
    private javax.swing.JLabel nombreLabel3;
    private javax.swing.JTextField nombreTexto;
    private javax.swing.JTextField nombreTexto2;
    private javax.swing.JTextField nombreTexto3;
    private javax.swing.JTextField nombreTexto4;
    private javax.swing.JComboBox<String> paisComboBox;
    private javax.swing.JTextField paisTexto;
    private javax.swing.JTextField presidenteTexto;
    private javax.swing.JLabel repiteLabel;
    private javax.swing.JLabel repiteLabel1;
    private javax.swing.JLabel repiteLabel2;
    private javax.swing.JLabel repiteLabel3;
    private javax.swing.JLabel repiteLabel4;
    private javax.swing.JLabel repiteLabel5;
    private javax.swing.JLabel repiteLabel6;
    // End of variables declaration//GEN-END:variables
}
