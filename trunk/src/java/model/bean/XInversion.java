/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.bean;

/**
 *
 * @author Carlos
 */
public class XInversion extends Bean{
    
    private String descripcion;
    private int cantidadA;
    private int cantidadB;

    public int getCantidadA() {
        return cantidadA;
    }

    public void setCantidadA(int cantidadA) {
        this.cantidadA = cantidadA;
    }

    public int getCantidadB() {
        return cantidadB;
    }

    public void setCantidadB(int cantidadB) {
        this.cantidadB = cantidadB;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
