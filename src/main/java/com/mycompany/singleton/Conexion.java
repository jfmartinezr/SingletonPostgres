/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.singleton;

/**
 *
 * @author usuario
 */
public class Conexion {
    
    private static Conexion INSTANCE = new Conexion();
    
    
    // El constructor privado no permite que se genere un constructor por defecto.
    private Conexion(){
    //codigo opcional
    }
    
    //crea un metodo estatico para traer la instancia
    public static Conexion getInstance(){
    return INSTANCE;
    }
    
    
    public void getAlgo(){
          System.out.println("I am here....");
    }
    
    public static void main(String a[]){
             Conexion co = Conexion.getInstance();
             co.getAlgo();
                      
         }
     
}
