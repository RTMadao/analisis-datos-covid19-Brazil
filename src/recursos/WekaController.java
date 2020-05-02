/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import java.util.ArrayList;
import weka.classifiers.functions.LinearRegression;
import weka.clusterers.SimpleKMeans;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;

/**
 *
 * @author carlo
 */
public class WekaController {
    
    private static WekaController instanceController;
    private Instances dataset;

    public WekaController() {
    }
    
    public static WekaController getInstance(){
        if (instanceController == null) instanceController = new WekaController();
        return instanceController;
    }

    public void setDataset(Instances dataset) {
        this.dataset = dataset;
    }
    
    public void setData(String Xname, String Yname, ArrayList<Integer> x, ArrayList<Integer> y){
        FastVector vector = new FastVector(2);
        vector.addElement(new Attribute(Xname));
        vector.addElement(new Attribute(Yname));
        
        dataset = new Instances("dataset",vector,61);
        dataset.setClassIndex(1);
        
        for (int i = 0; i <= 60; i++) {
            Instance instancia = new Instance(2);
            
            instancia.setValue((Attribute)vector.elementAt(0), x.get(i));
            instancia.setValue((Attribute)vector.elementAt(1) , y.get(i));
            
            dataset.add(instancia);
        }
    }
    
    public LinearRegression getLinearRegression() throws Exception{
        LinearRegression lr = new LinearRegression();
        lr.buildClassifier(dataset);
        return lr;
    }
    
    public SimpleKMeans getCluster() throws Exception{
        SimpleKMeans skm = new SimpleKMeans();
        dataset.setClassIndex(-1);
        skm.buildClusterer(dataset);
        dataset.setClassIndex(1);
        return skm;
    }
    
}
