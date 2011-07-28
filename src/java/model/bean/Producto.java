/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Laptop
 */
public class Producto extends Bean{
    
    private int id;
    private String descripcion;
    private double cubicaje;
    private int stockMin;
    private double costo;
    private double costoInv;
    private int saldoAnt;

    public Producto() {
    }
    
    

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getCostoInv() {
        return costoInv;
    }

    public void setCostoInv(double costoInv) {
        this.costoInv = costoInv;
    }

    public double getCubicaje() {
        return cubicaje;
    }

    public void setCubicaje(double cubicaje) {
        this.cubicaje = cubicaje;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getSaldoAnt() {
        return saldoAnt;
    }

    public void setSaldoAnt(int saldoAnt) {
        this.saldoAnt = saldoAnt;
    }

    public int getStockMin() {
        return stockMin;
    }

    public void setStockMin(int stockMin) {
        this.stockMin = stockMin;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
