package com.mycompany.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * JM
 */
public class Conexion {

    private static Conexion INSTANCE = new Conexion();
    private String cadenaConexion = "jdbc:postgresql://nuevo.aretico.com:5432/software_2";
    private String user = "grupo2";
    private String pwd = "alvmart";
    Connection connect;

    // El constructor privado no permite que se genere un constructor por defecto.
    private Conexion() {
        //codigo opcional
        connect = null;

        try {

            Class.forName("org.postgresql.Driver");
            connect = DriverManager.getConnection(cadenaConexion, user, pwd);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    //crea un metodo estatico para traer la instancia //opcional sincronizacion
    public static Conexion getInstance() {

        //verifico si la instancia no se ha creado anteriormente    
        if (INSTANCE == null) {
            INSTANCE = new Conexion();
        }
        return INSTANCE;
    }

    public void getAlgo() {
        System.out.println("I am here....");
    }

    public static void main(String a[]) {
        Conexion co = Conexion.getInstance();
        co.getAlgo();

    }

}
