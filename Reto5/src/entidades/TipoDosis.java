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
public class TipoDosis {
    private int idTipoDosis;
    private String tipoDosis;

    public TipoDosis(int idTipoDosis, String tipoDosis) {
        this.idTipoDosis = idTipoDosis;
        this.tipoDosis = tipoDosis;
    }

    public int getIdTipoDosis() {
        return idTipoDosis;
    }

    public String getTipoDosis() {
        return tipoDosis;
    }

    @Override
    public String toString() {
        return tipoDosis;
    }
}
