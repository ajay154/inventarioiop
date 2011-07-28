/*
 * CreateChart.java
 *
 * Created on February 26, 2008, 6:47 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package view.common;

import java.awt.*;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.renderer.category.*;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.TextAnchor;

/**
 *
 * @author cdiaz
 */
public class ChartUtil {

    public static JFreeChart createLineChart(List list, String title, String domainsAxis, String rangesAxis) {
        DefaultCategoryDataset dataset = (DefaultCategoryDataset) ChartData.createDefaultDataset(list);
        JFreeChart chart = ChartFactory.createLineChart(
                title, domainsAxis, rangesAxis, dataset,
                PlotOrientation.VERTICAL,
                true, // include legend
                true, // tooltips?
                false // URLs?
                // URLs?
                );
        //Dataset
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        //RANGE
        plot.getRangeAxis().setLowerBound(minLimit(list));
        plot.getRangeAxis().setUpperBound(maxLimit(list));

        //plot.setBackgroundPaint(Color.lightGray);
        //plot.setRangeGridlinePaint(Color.white);
        plot.setBackgroundPaint(Color.white);
        plot.setRangeGridlinePaint(Color.lightGray);

        // customise the range axis...
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        // customise the renderer...
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        renderer.setShapesVisible(true);
        renderer.setDrawOutlines(true);
        renderer.setUseFillPaint(true);
        renderer.setFillPaint(Color.white);

        //Item Label
        CategoryItemLabelGenerator generator = new StandardCategoryItemLabelGenerator();
        renderer.setBaseItemLabelGenerator(generator);
        renderer.setItemLabelsVisible(true);
//        ItemLabelPosition p = new ItemLabelPosition(
//                ItemLabelAnchor.INSIDE12, TextAnchor.CENTER_RIGHT,
//                TextAnchor.CENTER_RIGHT, -Math.PI / 2.0);

        ItemLabelPosition p = new ItemLabelPosition(
                ItemLabelAnchor.OUTSIDE1, TextAnchor.BASELINE_LEFT, TextAnchor.BASELINE_LEFT, 0);
        renderer.setItemLabelAnchorOffset(2.5);
        renderer.setPositiveItemLabelPosition(p);
        renderer.setItemLabelFont((new Font("SansSerif", Font.PLAIN, 9)));

        return chart;
    }

    public static JFreeChart createBarChart(List list, String title, String domainsAxis, String rangesAxis) {
        DefaultCategoryDataset dataset = (DefaultCategoryDataset) ChartData.createDefaultDataset(list);
        JFreeChart chart = ChartFactory.createBarChart(
                title, domainsAxis, rangesAxis,
                dataset, // data
                PlotOrientation.VERTICAL, // Orientation
                true, // include legend
                true, // tooltips?
                false // URLs?
                );

        chart.setBackgroundPaint(Color.white);

        CategoryPlot plot = chart.getCategoryPlot();
        //plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setDomainGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.white);

        //Define Range
        plot.getRangeAxis().setLowerBound(0);
        plot.getRangeAxis().setUpperBound(maxLimit(list));

        // set the range axis to display integers only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        // disable bar outlines...
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        // set up gradient paints for series...
        GradientPaint gp0 = new GradientPaint(
                0.3f, 0.0f, Color.yellow,
                0.0f, 0.0f, new Color(159, 160, 48));
        GradientPaint gp1 = new GradientPaint(
                0.0f, 0.0f, Color.green,
                0.0f, 0.0f, new Color(0, 64, 0));
        GradientPaint gp2 = new GradientPaint(
                0.0f, 0.0f, Color.orange,
                0.0f, 0.0f, new Color(181, 83, 11));
        renderer.setSeriesPaint(0, gp0);
        renderer.setSeriesPaint(1, gp1);
        renderer.setSeriesPaint(2, gp2);
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
                CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0));
        // OPTIONAL CUSTOMISATION COMPLETED.
        //Bar Spacing
        CategoryAxis axis = plot.getDomainAxis();
        axis.setLowerMargin(0.02); // two percent

        axis.setCategoryMargin(0.25); // ten percent

        axis.setUpperMargin(0.02); // two percent
        //Item Label

        CategoryItemLabelGenerator generator = new StandardCategoryItemLabelGenerator();
        renderer.setBaseItemLabelGenerator(generator);
        renderer.setItemLabelsVisible(true);

        return chart;
    }

    public static JFreeChart createPieChart3D(List list,String title) {
        DefaultPieDataset dataset = ChartData.createPieDataset(list);

        JFreeChart chart = ChartFactory.createPieChart3D(title, dataset, true,
                true, true);
        return chart;
    }

    private static double maxLimit(List list) {
        double maxValue = 0;
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                Map map = (HashMap) list.get(i);
                String str = map.get("value").toString();
                double value = Double.parseDouble(str);
                if (value > maxValue) {
                    maxValue = value;
                }
            }
        }
        if (maxValue < 400) {
            maxValue = maxValue + 10;
        } else if (maxValue < 600) {
            maxValue = maxValue + 50;
        } else if (maxValue < 800) {
            maxValue = maxValue + 90;
        } else {
            maxValue = maxValue + 130;
        }
        return maxValue;
    }

    private static double minLimit(List list) {
        double minValue = 0;
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                Map map = (HashMap) list.get(i);
                String str = map.get("value").toString();
                double value = Double.parseDouble(str);
                if (value < minValue) {
                    minValue = value;
                }
            }
        }
        return minValue - 5;
    }
}

 
