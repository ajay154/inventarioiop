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
        } else if (tipo.equals("mineria")) {
            list = LingoDao.getInstance().getListMineria();
            title = "Mineria";
        } else if (tipo.equals("energia")) {
            list = LingoDao.getInstance().getListPlastico();
            title = "Energia";
        } else if (tipo.equals("alimentos")) {
            list = LingoDao.getInstance().getListAlimento();
            title = "Alimentos";
        } else if (tipo.equals("plasticos")) {
            list = LingoDao.getInstance().getListPlastico();
            title = "Plasticos";
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
        if (tipo.equals("mineria")) {
            LingoDao.getInstance().updateMineria(list);
        }
        else if (tipo.equals("energia")) {
            LingoDao.getInstance().updateEnergia(list);
        }
        else if (tipo.equals("alimentos")) {
            LingoDao.getInstance().updateAlimento(list);
        }
        else {
            LingoDao.getInstance().updatePlastico(list);
        }
        return mapping.findForward(INICIO);
    }
}