/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

/**
 *
 * @author carlo
 */
import java.util.ArrayList;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Graficar{
    
    private ChartPanel grafica;
    private DefaultCategoryDataset dataset;

    public Graficar() {
    }

   public void Grafica( String applicationTitle , String chartTitle, String ejeX ) {
      JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "Dias",ejeX,
         dataset,
         PlotOrientation.VERTICAL,
         true,true,false);
         
      grafica = new ChartPanel( lineChart );
      grafica.setBounds(15, 25, 580, 380);
   }

    public ChartPanel getGrafica() {
        return grafica;
    }

   public DefaultCategoryDataset createDataset(ArrayList<Recta> lineas, ArrayList<Integer> dias) {
      dataset = new DefaultCategoryDataset( );
       for (Recta linea : lineas) {
            for (int i = 0; i < dias.size(); i+=10) {
                dataset.addValue( linea.getPoint(i) , linea.getNombre(), Integer.toString(dias.indexOf(i)) );
                System.out.println(linea.getNombre());
            }
       }
      
      return dataset;
   }
   
   public void cls(){
       dataset = null;
   }

}
