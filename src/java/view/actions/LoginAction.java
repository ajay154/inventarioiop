/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Usuario;
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
public class LoginAction extends DispatchAction {

    private final static String LOGIN = "login";
    private final static String INFO = "info";

    @Override
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.getSession().removeAttribute("SessionUsuario");
        CustomActionForm f = (CustomActionForm)form;    
        f.setBean(new Usuario());
        return mapping.findForward(LOGIN);
    }

    public ActionForward login(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        CustomActionForm f = (CustomActionForm)form; 
        Usuario usuario = (Usuario)f.getBean();
        usuario = LingoDao.getInstance().getUsuario(usuario);
        if(usuario!=null){
            request.getSession().setAttribute("SessionUsuario", usuario);
            return mapping.findForward(INFO);
        }
        return mapping.findForward(LOGIN);
    }
}