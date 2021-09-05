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
public class TipoVacuna {
    private int idTipoVacuna;
    private String nombreVacuna;

    public TipoVacuna(int idTipoVacuna, String nombreVacuna) {
        this.idTipoVacuna = idTipoVacuna;
        this.nombreVacuna = nombreVacuna;
    }

    public int getIdTipoVacuna() {
        return idTipoVacuna;
    }

    public String getNombreVacuna() {
        return nombreVacuna;
    }

    @Override
    public String toString() {
        return nombreVacuna;
    }
}
