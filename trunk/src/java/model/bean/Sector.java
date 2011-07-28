/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Carlos
 */
public class Sector extends Bean {

    private String descripcion;
    private int numero;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
}
