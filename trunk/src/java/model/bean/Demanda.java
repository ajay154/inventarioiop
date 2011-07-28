/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Laptop
 */
public class Demanda extends Bean{
    
    private Producto producto;
    private Mes mes;
    private int demanda;

    public Demanda() {
    }

    public int getDemanda() {
        return demanda;
    }

    public void setDemanda(int demanda) {
        this.demanda = demanda;
    }

    public Mes getMes() {
        return mes;
    }

    public void setMes(Mes mes) {
        this.mes = mes;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    
    
}
