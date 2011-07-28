/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.bean;

/**
 *
 * @author Carlos
 */
public class Usuario extends Bean{
    
    private String login;
    private String password;
    private String nombre;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
