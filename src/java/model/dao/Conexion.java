/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.*;

/**
 *
 * @author cdiaz
 */
public class Conexion {

    private static Conexion _instance = null;
    private String bd = "C:/proyectoIOP/proyecto/INVENTARIO.mdb";
    private Connection oCN = null;

    private Conexion() {
    }

    public static Conexion getInstance() {
        if (_instance == null) {
            _instance = new Conexion();
        }
        return _instance;
    }

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            oCN=DriverManager.getConnection("jdbc:odbc:INVENTARIO");

            //String url = "jdbc:odbc:MS Access Database;DBQ="+bd; 
            //oCN = DriverManager.getConnection(url,"","");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return oCN;
    }
}