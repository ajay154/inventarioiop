/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package view.actions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Producto;

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
public class InfoAction extends DispatchAction {
    
    private final static String INFO = "info";
    
    @Override
    public ActionForward unspecified(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        CustomActionForm f = (CustomActionForm)form;   
        Map map = new HashMap();
        map.put("productos", LingoDao.getInstance().getProductos());
        map.put("meses", LingoDao.getInstance().getMeses());
        List<Producto> productos = LingoDao.getInstance().getProductos();
        f.setMapList(map);
        request.setAttribute("lista", productos);
        return mapping.findForward(INFO);
    }
    

    
}