/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.actions;

import com.lindo.Lingd10;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Pedido;
import model.bean.Producto;
import model.bean.VistaPedidoBean;

import model.dao.LingoDao;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import view.common.ChartUtil;
import view.forms.CustomActionForm;

/**
 *
 * @author Carlos
 */
public class SolverAction extends DispatchAction {

    private final static String SOLVER = "solver";
    Lingd10 lng = new Lingd10();
    int pnLngEnv;
    int nLastIterationCount;
    

    static {
        System.loadLibrary("Lingj10");
    }

    @Override
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        CustomActionForm f = (CustomActionForm)form;
        f.setReadOnly("");
        return mapping.findForward(SOLVER);
    }
    
    public ActionForward chart(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse resp) throws Exception {
        System.out.println("chart.inicio");
        List list = LingoDao.getInstance().getCantidadXProductoXMes();
        resp.setContentType("image/jpeg");
        OutputStream salida = resp.getOutputStream();
        JFreeChart grafica = ChartUtil.createBarChart(list, "Cantidad de productos a pedido X Mes","","");
        CustomActionForm f = (CustomActionForm)form;
        f.getMapList().put("chart", grafica);
        ChartUtilities.writeChartAsJPEG(salida,grafica,520,400);
        salida.close();
        System.out.println("chart.fin");
        return null;
    }

    public ActionForward zoomchart(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse resp) throws Exception {
        System.out.println("zoomchart.inicio");
        CustomActionForm f = (CustomActionForm)form;
        JFreeChart grafica = (JFreeChart) f.getMapList().get("chart");
        String width = req.getParameter("width");
        String height = req.getParameter("height");
        OutputStream salida = resp.getOutputStream();
        ChartUtilities.writeChartAsJPEG(salida,grafica,Integer.parseInt(width),Integer.parseInt(height));
        salida.close();
        System.out.println("zoomchart.fin");
        return null;
    }

    public ActionForward solver(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        CustomActionForm f = (CustomActionForm)form;
        Map map = new HashMap();
        solve();
        f.setMapList(map);
        f.setReadOnly("SOLVER");
        
        List<Producto> productos = LingoDao.getInstance().getProductos();
        List<VistaPedidoBean> vistaPedidoList = new ArrayList<VistaPedidoBean>();
        List<Pedido> pedidoList = new ArrayList<Pedido>();
        for(Producto prod:productos){
            pedidoList = LingoDao.getInstance().getPedido(prod.getId());
            VistaPedidoBean vista = new VistaPedidoBean();
            vista.setProducto(prod);
            vista.setPedido(pedidoList);
            vistaPedidoList.add(vista);
        }
        
        
        request.setAttribute("vista2", vistaPedidoList);
        request.setAttribute("vistaPedido", pedidoList);
        
        return mapping.findForward(SOLVER);
    }

    private void solve() throws Exception {
        String resourcesPath = getServlet().getServletContext().getRealPath("/") + "WEB-INF/resources/";
        int nErr;
        Double d1 = 0.;
        double dObj[] = new double[1];
        double dStatus[] = new double[1];

        System.out.println("\nSolving...");

        // create the Lingo environment
        pnLngEnv = lng.LScreateEnvLng();
        if (pnLngEnv == 0) {
            System.out.println("***Unable to create Lingo environment***");
            return;
        }

        // open a log file
        nErr = lng.LSopenLogFileLng(pnLngEnv, resourcesPath + "inventario.log");
        if (nErr != lng.LSERR_NO_ERROR_LNG) {
            System.out.println("***LSopenLogFileLng() error***: " + nErr);
            return;
        }
        int[] nPointersNow = new int[1];

        nErr = lng.LSsetPointerLng(pnLngEnv, dObj, nPointersNow);
        if (nErr != lng.LSERR_NO_ERROR_LNG) {
            System.out.println("***LSsetPointerLng() error***: " + nErr);
            return;
        }
        nErr = lng.LSsetPointerLng(pnLngEnv, dStatus, nPointersNow);
        if (nErr != lng.LSERR_NO_ERROR_LNG) {
            System.out.println("***LSsetPointerLng() error***: " + nErr);
            return;
        }

        // pass Lingo the name of the solver callback function...
        nErr = lng.LSsetCallbackSolverLng(pnLngEnv, "MySolverCallback", this);

        // ...and the error callback function
        nErr = lng.LSsetCallbackErrorLng(pnLngEnv, "MyErrorCallback", this);

        // construct the script
        String scriptPath = resourcesPath + "inventario.lng";
        String sScript = "SET ECHOIN 1" + "\n";

        // load the model from disk
        sScript = sScript + "TAKE " + scriptPath + "\n";

        // view the formulation
        sScript = sScript + "LOOK ALL" + "\n";

        // solve
        sScript = sScript + "GO" + "\n";

        // exit script processor
        sScript = sScript + "QUIT" + "\n";

        // run the script
        dStatus[0] = -1;
        nLastIterationCount = -1;
        nErr = lng.LSexecuteScriptLng(pnLngEnv, sScript);
        if (nErr != lng.LSERR_NO_ERROR_LNG) {
            System.out.println("***LSexecuteScriptLng error***: " + nErr);
            return;
        }

        // clear the pointers to force update of local arrays
        // ***NOTE*** solution won't get passed to local arrays until
        // LSclearPointersLng is called!!!
        nErr = lng.LSclearPointersLng(pnLngEnv);
        if (nErr != lng.LSERR_NO_ERROR_LNG) {
            System.out.println("***LSclearPointerLng() error***: " + nErr);
            return;
        }

        // check the solution status
        if (dStatus[0] != lng.LS_STATUS_GLOBAL_LNG) {
            System.out.println("***Unable to Solve*** dStatus:" + dStatus[0]);
        // close Lingo's log file
        }
        nErr = lng.LScloseLogFileLng(pnLngEnv);
        if (nErr != lng.LSERR_NO_ERROR_LNG) {
            System.out.println("***LScloseLogFileLng() error***: " + nErr);
            return;
        }

        // delete the Lingo environment
        lng.LSdeleteEnvLng(pnLngEnv);

    }

    private static int MySolverCallback(int pnLng, int iLoc, Object jobj) {
        SolverAction s = (SolverAction) jobj;
        int nIterations[] = new int[1];
        s.lng.LSgetCallbackInfoIntLng(s.pnLngEnv, Lingd10.LS_IINFO_ITERATIONS_LNG, nIterations);
        if (nIterations[0] != s.nLastIterationCount) {
            s.nLastIterationCount = nIterations[0];
            System.out.println("In Java callback function...iterations = " + s.nLastIterationCount);
        }
        return (0);
    }

    private static int MyErrorCallback(int pnLng, Object jobj, int nErrorCode, String jsErrMessage) {
        System.out.println("In Java callback function...Lingo error code = " + nErrorCode);
        System.out.println("In Java callback function...Lingo error message:\n\n " + jsErrMessage);
        return (0);
    }

}