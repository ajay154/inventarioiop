/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.bean.Demanda;
import model.bean.Mes;
import model.bean.Pedido;
import model.bean.Producto;
import model.bean.Usuario;
import model.bean.VistaDemandaBean;

/**
 *
 * @author Inventario
 */
public class LingoDao {

    private static LingoDao _instance;

    private LingoDao() {
    }

    public static LingoDao getInstance() {
        if (_instance == null) {
            _instance = new LingoDao();
        }
        return _instance;
    }

    public Usuario getUsuario(Usuario usuario) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Usuario bean = null;
        try {
            conn = getConnection();
            String sql = " select login,password,nombre from TB_USUARIO where login = ? and password = ? ";

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getLogin().trim());
            pstm.setString(2, usuario.getPassword().trim());
            rs = pstm.executeQuery();
            if (rs.next()) {
                bean = new Usuario();
                bean.setLogin(rs.getString(1));
                bean.setPassword(rs.getString(2));
                bean.setNombre(rs.getString(3));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error de BD");
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return bean;
        }
    }

    public void updateProducto(ArrayList<Producto> list) {
        String sql = "update TB_PRODUCTO set CUBICAJE = ?, STOCK_MIN = ?, COSTO=?, COSTO_INV=?, SALDO_ANT = ? where id_PRODUCTO = ? ";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = getConnection();
            for (Producto bean : list) {
                pstm = conn.prepareStatement(sql);
                pstm.setDouble(1, bean.getCubicaje());
                pstm.setInt(2, bean.getStockMin());
                pstm.setDouble(3, bean.getCosto());
                pstm.setDouble(4, bean.getCostoInv());
                pstm.setInt(5, bean.getSaldoAnt());
                pstm.setInt(6, bean.getId());
                pstm.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println("Error de BD");
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    public void updateDemanda(ArrayList<VistaDemandaBean> list) {
        String sql = "update TB_PRODUCTO_MES set DEMANDA = ? where id_PRODUCTO = ? and id_MES=?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = getConnection();
            for (VistaDemandaBean bean : list) {
                for (Demanda demanda : bean.getDemanda()) {
                    pstm = conn.prepareStatement(sql);
                    pstm.setInt(1, demanda.getCantidad());
                    pstm.setInt(2, demanda.getProducto().getId());
                    pstm.setInt(3, demanda.getMes().getId());
                    pstm.executeUpdate();
                }

            }
        } catch (Exception e) {
            System.out.println("Error de BD");
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    public void updateMes(ArrayList<Mes> list) {
        String sql = "update TB_Mes set capacidad = ? ";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = getConnection();
            Mes bean = list.get(0);

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, bean.getCapacidad());
            pstm.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error de BD");
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }


    public ArrayList<Producto> getProductos() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Producto> list = new ArrayList<Producto>();
        String sql = null;
        try {
            conn = getConnection();

            sql = "select * from TB_PRODUCTO";

            pstm = conn.prepareStatement(sql);

            rs = pstm.executeQuery();
            while (rs.next()) {
                Producto bean = new Producto();
                bean.setId(rs.getInt(1));
                bean.setDescripcion(rs.getString(2));
                bean.setCubicaje(rs.getDouble(3));
                bean.setStockMin(rs.getInt(4));
                bean.setCosto(rs.getDouble(5));
                bean.setCostoInv(rs.getDouble(6));
                bean.setSaldoAnt(rs.getInt(7));
                list.add(bean);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error de BD");
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }

            return list;
        }
    }

    public ArrayList<Mes> getMeses() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Mes> list = new ArrayList<Mes>();
        String sql = null;
        try {
            conn = getConnection();

            sql = "select * from TB_MES ORDER BY 1";

            pstm = conn.prepareStatement(sql);

            rs = pstm.executeQuery();
            while (rs.next()) {
                Mes bean = new Mes();
                bean.setId(rs.getInt(1));
                bean.setNombre(rs.getString(2));
                bean.setCapacidad(rs.getInt(3));
                list.add(bean);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error de BD");
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }

            return list;
        }
    }

    public ArrayList<Demanda> getDemanda(Integer productId) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Demanda> demandaList = new ArrayList<Demanda>();
        String sql = null;
        try {
            conn = getConnection();

            sql = "SELECT  TB_PRODUCTO.DESCRIPCION, TB_MES.NOMBRE,TB_PRODUCTO_MES.DEMANDA,TB_PRODUCTO_MES.Id_Mes FROM "
                    + "(TB_PRODUCTO_MES INNER JOIN TB_PRODUCTO ON TB_PRODUCTO_MES.Id_PRODUCTO = TB_PRODUCTO.Id_PRODUCTO) "
                    + "INNER JOIN TB_MES ON TB_PRODUCTO_MES.Id_MES = TB_MES.Id_MES WHERE TB_PRODUCTO.ID_PRODUCTO=" + productId + ";";

            pstm = conn.prepareStatement(sql);

            rs = pstm.executeQuery();
            while (rs.next()) {
                Demanda demanda = new Demanda();
                Producto producto = new Producto();
                producto.setId(productId);
                Mes mes = new Mes();
                mes.setNombre(rs.getString(2));
                demanda.setCantidad(rs.getInt(3));
                mes.setId(rs.getInt(4));
                demanda.setMes(mes);
                demanda.setProducto(producto);
                demandaList.add(demanda);

            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error de BD");
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }

            return demandaList;
        }
    }

    public ArrayList<Pedido> getPedido(Integer productId) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Pedido> pedidoList = new ArrayList<Pedido>();
        String sql = null;
        try {
            conn = getConnection();

            sql = "SELECT TB_PRODUCTO.DESCRIPCION, TB_MES.NOMBRE, TB_PEDIDO.X "
                    + "FROM (TB_PEDIDO INNER JOIN TB_PRODUCTO ON TB_PEDIDO.Id_PRODUCTO=TB_PRODUCTO.Id_PRODUCTO) "
                    + "INNER JOIN TB_MES ON TB_PEDIDO.Id_MES=TB_MES.Id_MES WHERE TB_PRODUCTO.ID_PRODUCTO=" + productId + ";";

            pstm = conn.prepareStatement(sql);

            rs = pstm.executeQuery();
            while (rs.next()) {
                Pedido pedido = new Pedido();

                Mes mes = new Mes();
                mes.setNombre(rs.getString(2));
                pedido.setCantidad(rs.getInt(3));
                pedido.setMes(mes);

                pedidoList.add(pedido);

            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error de BD");
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }

            return pedidoList;
        }
    }

    public ArrayList getCantidadXProductoXMes() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList list = new ArrayList();
        try {
            conn = getConnection();
            String sql = "SELECT TB_MES.Id_MES,TB_MES.NOMBRE,TB_PRODUCTO.DESCRIPCION, TB_PEDIDO.X "
                    + "FROM (TB_PEDIDO INNER JOIN TB_PRODUCTO ON TB_PEDIDO.Id_PRODUCTO=TB_PRODUCTO.Id_PRODUCTO) "
                    + "INNER JOIN TB_MES ON TB_PEDIDO.Id_MES=TB_MES.Id_MES ORDER BY 1,4;";

//            String sql = "SELECT TB_MES.Id_MES,TB_PRODUCTO.DESCRIPCION,TB_MES.NOMBRE, TB_PEDIDO.X "
//                   + "FROM (TB_PEDIDO INNER JOIN TB_PRODUCTO ON TB_PEDIDO.Id_PRODUCTO=TB_PRODUCTO.Id_PRODUCTO) " 
//                   + "INNER JOIN TB_MES ON TB_PEDIDO.Id_MES=TB_MES.Id_MES ORDER BY 1,4;";
//            

            pstm = conn.prepareStatement(sql);

            rs = pstm.executeQuery();
            while (rs.next()) {
                Map map = new HashMap();
                map.put("serie", rs.getString(2));
                map.put("category", rs.getString(3));
                map.put("value", rs.getString(4));
                list.add(map);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error de BD");
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }

            return list;
        }
    }

    private Connection getConnection() throws SQLException {
        return Conexion.getInstance().getConnection();
    }
}
