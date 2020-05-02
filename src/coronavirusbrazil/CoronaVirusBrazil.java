/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronavirusbrazil;

import java.io.IOException;
import recursos.CSVFileReader;
import recursos.WekaController;
import weka.clusterers.SimpleKMeans;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;

/**
 *
 * @author carlo
 */
public class CoronaVirusBrazil {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, Exception{
        // TODO code application logic here
        
        String ruta = "CasosCOVID_Brazil.csv"; 
        CSVFileReader data = new CSVFileReader();
        data.readData(ruta);
        
        WekaController.getInstance().setData("dia", "infectados", data.getDia(), data.getInfectados());
        System.out.println(WekaController.getInstance().getLinearRegression());
        System.out.println(""+WekaController.getInstance().getCluster());
        
        
        
        
    }
    
}
