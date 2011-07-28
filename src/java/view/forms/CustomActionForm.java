package view.forms;

import java.util.List;
import java.util.Map;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

/**
 *
 * @author Carlos
 */
public class CustomActionForm extends ValidatorForm {
    
    private Object bean;
    private List beanList;
    private Map mapList;
    private String readOnly;
    private String title;
    private String[] selectedList;
    private String selectedIndex;
       
    /** Creates a new instance of GenericForm */
    public CustomActionForm() {
        super();
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public List getBeanList() {
        return beanList;
    }

    public void setBeanList(List beanList) {
        this.beanList = beanList;
    }

    public Map getMapList() {
        return mapList;
    }

    public void setMapList(Map mapList) {
        this.mapList = mapList;
    }

    public String getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(String readOnly) {
        this.readOnly = readOnly;
    }

    public String getSelectedIndex() {
        return selectedIndex;
    }

    public void setSelectedIndex(String selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public String[] getSelectedList() {
        return selectedList;
    }

    public void setSelectedList(String[] selectedList) {
        this.selectedList = selectedList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public ActionErrors validate(ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {        
        if( request.getParameter(mapping.getParameter())==null ) { 
            return new ActionErrors(); 
        } 
        return super.validate( mapping, request ); 
    }
    
}
