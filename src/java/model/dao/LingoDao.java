/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Inversion;
import model.bean.Sector;
import model.bean.XInversion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.bean.Mes;
import model.bean.Producto;
import model.bean.Usuario;

/**
 *
 * @author cdiaz
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
    
    public ArrayList<Sector> getSectores() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Sector> list = new ArrayList<Sector>();
        try {
            conn = getConnection();
            String sql = " select * from sectores ";

            pstm = conn.prepareStatement(sql);

            rs = pstm.executeQuery();
            while (rs.next()) {
                Sector bean = new Sector();
                bean.setDescripcion(rs.getString(1));
                bean.setNumero(rs.getInt(2));
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

    public void updateSectores(ArrayList<Sector> list) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = getConnection();
            for (Sector bean : list) {

                String sql = " update sectores set sectores = ? where indice = ? ";

                pstm = conn.prepareStatement(sql);
                pstm.setInt(1, bean.getNumero());
                pstm.setString(2, bean.getDescripcion());

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
    
    public void updateMineria(ArrayList<Inversion> list) {
        String sql = "update mineria set invami = ?, invbmi = ?, camimi=?, camami = ? where id = ? ";
        updateInversiones(list, sql);
        
    }
    
    public void updateAlimento(ArrayList<Inversion> list) {
        String sql = "update alimentos set invaali = ?, invbali = ?, camiali=?, camaali = ? where id = ? ";
        updateInversiones(list, sql);
    }
    
    public void updateEnergia(ArrayList<Inversion> list) {
        String sql = "update energia set invaene = ?, invbene = ?, camiene=?, camaene = ? where id = ? ";
        updateInversiones(list, sql);
    }
    
    public void updatePlastico(ArrayList<Inversion> list) {
        String sql = "update plasticos set invaplas = ?, invbplas = ?, camiplas=?, camaplas = ? where id = ? ";
        updateInversiones(list, sql);
    }
    
    public ArrayList<Inversion> getListMineria() {
        return getInversiones("SELECT id,invami, invbmi, camimi, camami, asgmi, Ymineria,nombre FROM mineria");
    }

    public ArrayList<Inversion> getListAlimento() {
        return getInversiones("SELECT id,invaali, invbali, camiali, camaali, asgali, Yalimentos,nombre FROM alimentos");
    }

    public ArrayList<Inversion> getListEnergia() {
        return getInversiones("SELECT id,invaene, invbene, camiene, camaene, asgene, Yenergia,nombre FROM energia");
    }

    public ArrayList<Inversion> getListPlastico() {
        return getInversiones("SELECT id,invaplas, invbplas, camiplas, camaplas, asgplas, Yplasticos,nombre FROM plasticos");
    }
    
    public ArrayList<XInversion> getListXMineria() {
        return getXInversiones("select mineria, Xmineria from Xmineria");
    }

    public ArrayList<XInversion> getListXAlimento() {
        return getXInversiones("SELECT alimentos, Xalimentos FROM Xalimentos");
    }

    public ArrayList<XInversion> getListXEnergia() {
        return getXInversiones("select energia, Xenergia from Xenergia");
    }

    public ArrayList<XInversion> getListXPlasticos() {
        return getXInversiones("select plasticos, Xplasticos from Xplasticos");
    }
    
    public ArrayList getCantidadXSectores() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList list = new ArrayList();
        try {
            conn = getConnection();
            String sql = " select * from vw_cantidadXSectores ";

            pstm = conn.prepareStatement(sql);

            rs = pstm.executeQuery();
            while (rs.next()) {
                Map map = new HashMap();
                map.put("category", rs.getString(1));
                map.put("value", rs.getString(2));
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
    
    public ArrayList getCantidadXEmpresaXSector() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList list = new ArrayList();
        try {
            conn = getConnection();
            String sql = " select * from vw_cantidadXEmpresaXSector ";

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

    private void updateInversiones(ArrayList<Inversion> list, String sql) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = getConnection();
            for (Inversion bean : list) {
                pstm = conn.prepareStatement(sql);
                pstm.setDouble(1, bean.getRendimientoA());
                pstm.setDouble(2, bean.getRendimientoB());
                pstm.setInt(3, bean.getCantMinima());
                pstm.setInt(4, bean.getCantMaxima());
                pstm.setInt(5, bean.getId());
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
    
    private ArrayList<Inversion> getInversiones(String sql) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Inversion> list = new ArrayList<Inversion>();
        try {
            conn = getConnection();

            pstm = conn.prepareStatement(sql);

            rs = pstm.executeQuery();
            while (rs.next()) {
                Inversion bean = new Inversion();
                bean.setId(rs.getInt(1));
                bean.setRendimientoA(rs.getDouble(2));
                bean.setRendimientoB(rs.getDouble(3));
                bean.setCantMinima(rs.getInt(4));
                bean.setCantMaxima(rs.getInt(5));
                bean.setBinEspecifico(rs.getInt(6));
                bean.setBinGeneral(rs.getInt(7));
                bean.setNombre(rs.getString(8));
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

    private ArrayList<XInversion> getXInversiones(String sql) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<XInversion> list = new ArrayList<XInversion>();
        try {
            conn = getConnection();

            pstm = conn.prepareStatement(sql);

            rs = pstm.executeQuery();

            XInversion bean = new XInversion();
            int i = 0;
            while (rs.next()) {
                if(i%2==0){
                    bean = new XInversion();
                    bean.setDescripcion(rs.getString(1).split("_")[0]);
                    bean.setCantidadA(rs.getInt(2));
                }else{
                    bean.setCantidadB(rs.getInt(2));
                    list.add(bean);
                }
                i = i + 1;
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
    
    
    public ArrayList<Producto> getProductos() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Producto> list = new ArrayList<Producto>();
        String sql = null;
        try {
            conn = getConnection();
            
            sql="select * from TB_PRODUCTO";
            
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
            
            sql="select * from TB_MES";
            
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


    private Connection getConnection() throws SQLException {
        return Conexion.getInstance().getConnection();
    }
}