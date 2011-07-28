/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.bean;

/**
 *
 * @author Carlos
 */
public class Inversion extends Bean{
    
    private String nombre;
    private double rendimientoA;
    private double rendimientoB;
    private int cantMinima;
    private int cantMaxima;
    private int binEspecifico;
    private int binGeneral;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getBinEspecifico() {
        return binEspecifico;
    }

    public void setBinEspecifico(int binEspecifico) {
        this.binEspecifico = binEspecifico;
    }

    public int getBinGeneral() {
        return binGeneral;
    }

    public void setBinGeneral(int binGeneral) {
        this.binGeneral = binGeneral;
    }

    public int getCantMaxima() {
        return cantMaxima;
    }

    public void setCantMaxima(int cantMaxima) {
        this.cantMaxima = cantMaxima;
    }

    public int getCantMinima() {
        return cantMinima;
    }

    public void setCantMinima(int cantMinima) {
        this.cantMinima = cantMinima;
    }

    public double getRendimientoA() {
        return rendimientoA;
    }

    public void setRendimientoA(double rendimientoA) {
        this.rendimientoA = rendimientoA;
    }

    public double getRendimientoB() {
        return rendimientoB;
    }

    public void setRendimientoB(double rendimientoB) {
        this.rendimientoB = rendimientoB;
    }
}
