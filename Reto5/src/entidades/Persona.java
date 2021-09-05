/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Juan Ricardo
 */
public class Persona {
    private String numDocumento;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private double edad;
    private String telefono;

    public Persona(String numDocumento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, double edad, String telefono) {
        this.numDocumento = numDocumento;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.edad = edad;
        this.telefono = telefono;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public double getEdad() {
        return edad;
    }

    public String getTelefono() {
        return telefono;
    }
    
    public String GetNombreCompleto(){
        String nombresCompleto = primerNombre + " " + segundoNombre;
        return nombresCompleto;
    }
    
    public String GetApellidosCompleto(){
        String apellidosCompleto = primerApellido + " " + segundoApellido;
        return apellidosCompleto;
    }
    
}
