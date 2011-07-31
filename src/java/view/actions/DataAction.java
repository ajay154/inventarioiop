/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Demanda;
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
 * @author Carlos
 */
public class DataAction extends DispatchAction {

    private final static String INICIO = "inicio";
    private final static String CONFIGURAR = "configurar";

    @Override
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        CustomActionForm f = (CustomActionForm) form;
        f.setMapList(new HashMap());
        f.setReadOnly("");
        return mapping.findForward(INICIO);
    }

    public ActionForward configurar(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        CustomActionForm f = (CustomActionForm) form;
        List list = null;
        String tipo = request.getParameter("tipo");
        String title = null;
        if (tipo == null) {
            return mapping.findForward(INICIO);
        } else if (tipo.equals("productos")) {
            list = LingoDao.getInstance().getProductos();
            title = "Productos";
        } else if (tipo.equals("meses")) {
            list = LingoDao.getInstance().getMeses();
            title = "Meses";
        } else if (tipo.equals("demanda")) {
            
            List<Producto> productos = LingoDao.getInstance().getProductos();
            List<VistaDemandaBean> vistaDemandaList = new ArrayList<VistaDemandaBean>();
            List<Demanda> demandaList = new ArrayList<Demanda>();
            for (Producto prod : productos) {
                demandaList = LingoDao.getInstance().getDemanda(prod.getId());
                VistaDemandaBean vista = new VistaDemandaBean();
                vista.setProducto(prod);
                vista.setDemanda(demandaList);
                vistaDemandaList.add(vista);
            }
            request.setAttribute("vistaDemanda", demandaList);
            list = vistaDemandaList;
            title = "Demanda";
        
        } else {
            return mapping.findForward(INICIO);
        }
        f.setReadOnly(tipo);
        f.setBeanList(list);
        f.setTitle(title);
        return mapping.findForward(CONFIGURAR);
    }

    public ActionForward grabar(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        CustomActionForm f = (CustomActionForm) form;
        String tipo = f.getReadOnly();
        ArrayList list = (ArrayList) f.getBeanList();
        if (tipo.equals("productos")) {
            LingoDao.getInstance().updateProducto(list);
        } else if (tipo.equals("meses")) {
            LingoDao.getInstance().updateMes(list);
        } else {
            
            LingoDao.getInstance().updateDemanda(list);
            
        }
        return mapping.findForward(INICIO);
    }
}