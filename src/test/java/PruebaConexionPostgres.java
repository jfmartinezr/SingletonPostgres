/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.DriverManager;
import org.testng.annotations.Test;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.testng.Assert;
/**
 *
 * @author usuario
 */
public class PruebaConexionPostgres {
    @Test
    public void pruebaconexionPotgresTest(){
        Connection   conexion=null;
        try {
            //conexion servidor aretico
            String cadenaConexion = "jdbc:postgresql://nuevo.aretico.com:5432/software_2";
            String user="grupo2";
            String pwd="alvmart";
            
            //conexion localhost
            //String cadenaConexion = "jdbc:postgresql://127.0.0.1:5432/software_2";
            //String user="postgres";
            //String pwd="alvmart";
            
            Class.forName("org.postgresql.Driver");
               conexion = DriverManager.getConnection(cadenaConexion,user,pwd);
            Assert.assertNotNull(conexion);
        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail();
        }finally{
            if(conexion!=null)
              try {
                  conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(PruebaConexionPostgres.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
}
