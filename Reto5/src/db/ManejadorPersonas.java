/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entidades.Persona;
import entidades.TipoDosis;
import entidades.TipoVacuna;
import entidades.Vacuna;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Ricardo
 */
public class ManejadorPersonas extends Conexion {
    public boolean crearPersona(Persona persona){
        conectar();
        
        String sql =  "INSERT INTO personas" + 
                "(num_documento, nombre_1, nombre_2, apellido_1, apellido_2, edad, telefono) " + 
                "VALUES ('" + persona.getNumDocumento() + "', '" + persona.getPrimerNombre() + "', '" + persona.getSegundoNombre() + "', '" 
                + persona.getPrimerApellido() + "', '" + persona.getSegundoApellido() + "', '" + persona.getEdad() + "', '" + persona.getTelefono() + "')";
        boolean resultado = ejecutarSQL(sql);
        
        desconectar();
        
        return resultado;
    }
    public boolean crearVacuna(Vacuna vacuna, Persona persona){
        conectar();
        
        String sql =  "INSERT INTO vacunas" + 
                "(id_tipo_vacuna, id_tipo_dosis, fecha_app, id_persona) " + 
                "VALUES ('" + vacuna.getIdTipoVacuna() + "', '" + vacuna.getIdTipoDosis() + "', NOW(), '" + persona.getNumDocumento() + "')";
        boolean resultado = ejecutarSQL(sql);
        
        desconectar();
        
        return resultado;
    }
    
    public boolean actualizarPersona(Persona persona){
        conectar();
        
        String sql =  "UPDATE personas" + 
                "SET num_documento = " + persona.getNumDocumento() + ", " +
                "nombre_1 = " + persona.getPrimerNombre() + ", " +
                "nombre_2 = " + persona.getSegundoNombre() + ", " +
                "apellido_1 = " + persona.getPrimerApellido() + ", " +
                "apellido_ = " + persona.getSegundoApellido() + ", " +
                "edad = " + persona.getEdad() + ", " +
                "telefono = " + persona.getTelefono() + 
                "WHERE num_documento = '" + persona.getNumDocumento()+ "'";
        boolean resultado = ejecutarSQL(sql);
        
        desconectar();
        
        return resultado;
    }
    
    public boolean actualizarVacuna(Vacuna vacuna, Persona persona){
        conectar();
        
        String sql =  "UPDATE vacunas" + 
                "SET id_tipo_vacuna = " + vacuna.getIdTipoVacuna() + ", " +
                "id_tipo_dosis =" + vacuna.getIdTipoDosis() + ", " +
                "fecha_app = NOW()" +
                "id_persona = " + persona.getNumDocumento()+ "'";
        boolean resultado = ejecutarSQL(sql);
        
        desconectar();
        
        return resultado;
    }
    
    public Persona consultarPersona(String fecha_app){
        try {
            conectar();
            
            String sql = "SELECT * FROM personas"
                    + "WHERE fecha_app ='"+ fecha_app +"'";
            
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rst = pstm.executeQuery();
            System.out.println(sql);
            
            if(rst.next()){
                Persona persona = new Persona(rst.getString("NUM_DOCUMENTO"), rst.getString("NOMBRE_1"), rst.getString("NOMBRE_2"), 
                        rst.getString("APELLIDO_1"), rst.getString("APELLIDO_2"), rst.getDouble("EDAD"), rst.getString("TELEFONO"));
                return persona;
            } else {
                return null;
            }
            
        } catch (SQLException ex) {
            System.out.println("Error en la conexion de la base de datos");
            return null;
        } finally{
            desconectar();
        }
    }
    
    public Vacuna consultarVacuna(String fecha_app){
        try {
            conectar();
            
            String sql = "SELECT * FROM vacunas"
                    + "WHERE fecha_app ='"+ fecha_app +"'";
            
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rst = pstm.executeQuery();
            
            if(rst.next()){
                Vacuna vacuna = new Vacuna(rst.getInt("ID_TIPO_VACUNA"), rst.getInt("ID_TIPO_DOSIS"));
                return vacuna;
            } else {
                return null;
            }
            
        } catch (SQLException ex) {
            System.out.println("Error en la conexion de la base de datos 1");
            return null;
        } finally{
            desconectar();
        }
    }
    
    public ArrayList<TipoVacuna> obtenerListaVacunas(){
        try {
            conectar();
            
            String sql = "SELECT * FROM tipos_vacunas "
                    + "ORDER BY id_tipo_vacuna";
            
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rst = pstm.executeQuery();
            
            ArrayList<TipoVacuna> listaTiposVacunas = new ArrayList<>();
            while (rst.next()){
                TipoVacuna tv = new TipoVacuna(rst.getInt("ID_TIPO_VACUNA"), rst.getString("NOMBRE_VACUNA"));
                listaTiposVacunas.add(tv);
            }
            return listaTiposVacunas;
        } catch (SQLException ex) {
            System.out.println("Error en la conexion de la base de datos 1");
            return (new ArrayList<>());
        } finally{
            desconectar();
        }
    }
    public ArrayList<TipoDosis> obtenerListaDosis(){
        try {
            conectar();
            
            String sql = "SELECT * FROM tipo_dosis "
                    + "ORDER BY id_tipo_dosis";
            
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rst = pstm.executeQuery();
            
            ArrayList<TipoDosis> listaTiposDosis = new ArrayList<>();
            while (rst.next()){
                TipoDosis td = new TipoDosis(rst.getInt("ID_TIPO_DOSIS"), rst.getString("TIPO_DOSIS"));
                listaTiposDosis.add(td);
            }
            return listaTiposDosis;
        } catch (SQLException ex) {
            System.out.println("Error en la conexion de la base de datos 1");
            return (new ArrayList<>());
        } finally{
            desconectar();
        }
    }
     public ArrayList<Vacuna> obtenerListaFecha(String fecha_app){
        try {
            conectar();
            
            String sql = "SELECT p.num_documento, p.nombre_1, p.nombre_2, p.apellido_1, p.apellido_2, p.edad, v.id_tipo_vacuna, tv.nombre_vacuna, v.id_tipo_dosis, td.tipo_dosis"
                    + "FROM vacunas v"
                    + "INNER JOIN personas p ON v.id_persona=p.num_documento"
                    + "INNER JOIN tipos_vacunas tv ON v.id_tipo_vacuna=tv.id_tipo_vacuna"
                    + "INNER JOIN tipo_dosis td ON v.id_tipo_dosis=td.id_tipo_dosis"
                    + "WHERE fecha_app = '" + fecha_app +"'";
            
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rst = pstm.executeQuery();
            
            ArrayList<Vacuna> listaVacunas = new ArrayList<>();
            while (rst.next()){
                Vacuna vacuna = new Vacuna(rst.getInt("V.ID_TIPO_VACUNA"), rst.getInt("V.ID_TIPO_DOSIS"));
                
                Persona persona = new Persona(rst.getString("P.NUM_DOCUMENTO"), rst.getString("P.NOMBRE_1"), rst.getString("P.NOMBRE_2"), 
                       rst.getString("P.APELLIDO_1"), rst.getString("P.APELLIDO_2"), rst.getDouble("P.EDAD"), rst.getString("P.TELEFONO"));
                
                TipoVacuna tipo_vacuna = new TipoVacuna(rst.getInt("V.ID_TIPO_VACUNA"), rst.getString("TV.NOMBRE_VACUNA"));
                
                TipoDosis tipo_dosis = new TipoDosis(rst.getInt("V.ID_TIPO_DOSIS"), rst.getString("TD.TIPO_DOSIS"));
                 
                vacuna.setNum_documento(persona.getNumDocumento());
                vacuna.setNombres(persona.GetNombreCompleto());
                vacuna.setApellidos(persona.GetApellidosCompleto());
                vacuna.setEdad(persona.getEdad());
                vacuna.setTipoVacuna(sql);
                
                listaVacunas.add(vacuna);
            }
            return listaVacunas;
        } catch (SQLException ex) {
            System.out.println("Error en la conexion de la base de datos");
            return (new ArrayList<>());
        } finally{
            desconectar();
        }
    }
}
