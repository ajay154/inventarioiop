/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Laptop
 */
public class Mes extends Bean{
    
    private int id;
    private String nombre;
    private int capacidad;

    public Mes() {
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
