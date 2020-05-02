/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import weka.clusterers.SimpleKMeans;

/**
 *
 * @author carlo
 */
public class Recta {
    
    private String nombre;
    private double factorX;
    private double terminoIndependiente;
    private SimpleKMeans cluster;

    public Recta(String nombre, double factorX, double terminoIndependiente, SimpleKMeans cluster) {
        this.nombre = nombre;
        this.factorX = factorX;
        this.terminoIndependiente = terminoIndependiente;
        this.cluster = cluster;
    }

    public String getNombre() {
        return nombre;
    }

    public double getFactorX() {
        return factorX;
    }

    public double getTerminoIndependiente() {
        return terminoIndependiente;
    }

    public SimpleKMeans getCluster() {
        return cluster;
    }
    
    public double getPoint(int dia){
        return (factorX*dia)+ this.terminoIndependiente;
    }
    
}
