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
public class Vacuna {
    private int idTipoVacuna;
    private int idTipoDosis;
    private String num_documento;
    private String nombres;
    private String apellidos;
    private double edad;
    private String tipoVacuna;
    private String tipoDosis;

    public Vacuna(int idTipoVacuna, int idTipoDosis) {
        this.idTipoVacuna = idTipoVacuna;
        this.idTipoDosis = idTipoDosis;
    }

    public int getIdTipoVacuna() {
        return idTipoVacuna;
    }

    public int getIdTipoDosis() {
        return idTipoDosis;
    }

    public String getNum_documento() {
        return num_documento;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTipoVacuna() {
        return tipoVacuna;
    }

    public String getTipoDosis() {
        return tipoDosis;
    }

    public double getEdad() {
        return edad;
    }

    public void setNum_documento(String num_documento) {
        this.num_documento = num_documento;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setTipoVacuna(String tipoVacuna) {
        this.tipoVacuna = tipoVacuna;
    }

    public void setTipoDosis(String tipoDosis) {
        this.tipoDosis = tipoDosis;
    }

    public void setEdad(double edad) {
        this.edad = edad;
    }
}
