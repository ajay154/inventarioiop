/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package view.common;

import java.util.List;
import java.util.Map;

import org.jfree.data.category.*;
import org.jfree.data.general.DefaultPieDataset;


/**
 *
 * @author Inventario
 */
public class ChartData {
    
    public static CategoryDataset createDefaultDataset(List list) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Map row=null;
        if(list!=null)
            for (int i=0; i<list.size(); i++){
                row=(Map)list.get(i);
                dataset.addValue(new Double(String.valueOf(row.get("value"))), String.valueOf(row.get("serie")), String.valueOf(row.get("category")) );
            }
        return dataset;
    }

    public static CategoryDataset createDefaultDataset_SerieCategory(List list) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Map row=null;
        if(list!=null)
            for (int i=0; i<list.size(); i++){
                row=(Map)list.get(i);
                dataset.addValue(new Double(String.valueOf(row.get("value"))), String.valueOf(row.get("category")), String.valueOf(row.get("category")) );
            }
        return dataset;
    }
    
    public static DefaultPieDataset createPieDataset(List list) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        Map row=null;
        if(list!=null)
            for (int i=0; i<list.size(); i++){
                row=(Map)list.get(i);
                dataset.setValue(String.valueOf(row.get("category")),new Double(String.valueOf(row.get("value"))));
            }
        return dataset;
    }

}
