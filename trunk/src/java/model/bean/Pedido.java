/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Laptop
 */
public class Pedido extends Bean{
    
    private Producto producto;
    private Mes mes;
    private int pedido;

    public Pedido() {
    }

    public Mes getMes() {
        return mes;
    }

    public void setMes(Mes mes) {
        this.mes = mes;
    }

    public int getPedido() {
        return pedido;
    }

    public void setPedido(int pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
}
