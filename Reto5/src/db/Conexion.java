/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Juan Ricardo
 */
public abstract class Conexion {
    private String servidor;
    private int puerto;
    private String usuario;
    private String contrasena;
    private String baseDatos;
    protected Connection con;
    
    public Conexion(){
        servidor = "127.0.0.1";
        puerto = 3306;
        usuario = "root";
        contrasena = "";
        baseDatos = "misiontic";
    }
    
    public boolean conectar(){
        con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            con = DriverManager.getConnection("jdbc:mysql://" + servidor + ":" + puerto + "/" + baseDatos, usuario, contrasena);
            if(con != null){
                return true;
            } else {
                return false;
            }
        }  catch (ClassNotFoundException ex) {
            System.out.println("Error en la carga del conector de la base de datos");
            return false;
        } catch (SQLException ex) {
            System.out.println("Error de coenxión a la base de datos");
            return false;
        }
    }
    
    public boolean desconectar(){
        try {
            con.close();
            return true;
        } catch (SQLException ex){
            System.out.println("Error de desconexion de la base de datos");
            return false;
        }
    }
    
    public boolean ejecutarSQL(String sql){
        try (CallableStatement cstmt = con.prepareCall(sql)){
            cstmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar sentencia SQL");
            return false;
        } 
    }
}
