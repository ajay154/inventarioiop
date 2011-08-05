/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package view.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Demanda;
import model.bean.Mes;
import model.bean.Producto;
import model.bean.VistaDemandaBean;

import model.dao.LingoDao;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import view.forms.CustomActionForm;

/**
 *
 * @author Inventario
 */
public class InfoAction extends DispatchAction {
    
    private final static String INFO = "info";
    
    @Override
    public ActionForward unspecified(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        List<Producto> productos = LingoDao.getInstance().getProductos();
        List<Mes> meses = LingoDao.getInstance().getMeses();
        List<VistaDemandaBean> vistaDemandaList = new ArrayList<VistaDemandaBean>();
        List<Demanda> demandaList = new ArrayList<Demanda>();
        for(Producto prod:productos){
            demandaList = LingoDao.getInstance().getDemanda(prod.getId());
            VistaDemandaBean vista = new VistaDemandaBean();
            vista.setProducto(prod);
            vista.setDemanda(demandaList);
            vistaDemandaList.add(vista);
        }
        
        
        request.setAttribute("productos", productos);
        request.setAttribute("meses", meses);
        request.setAttribute("vista", vistaDemandaList);
        request.setAttribute("vistaDemanda", demandaList);
        
        
        return mapping.findForward(INFO);
    }
    

    
}