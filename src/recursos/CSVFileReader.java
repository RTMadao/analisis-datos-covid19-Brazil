/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author carlo
 */
public class CSVFileReader {
    
    private ArrayList<Integer> dia;
    private ArrayList<Integer> infectados;
    private ArrayList<Integer> rescuperados;
    private ArrayList<Integer> muertos;

    public CSVFileReader() {
        this.dia = new ArrayList<Integer>();
        this.infectados = new ArrayList<Integer>();
        this.rescuperados = new ArrayList<Integer>();
        this.muertos = new ArrayList<Integer>();
    }
    
    public void readData(String ruta) throws IOException{
        BufferedReader data = null;
        try {
         
         data = new BufferedReader(new FileReader(ruta));
         String line = data.readLine();
         while (null!=line) {
            String [] fields = line.split(";");
            this.dia.add(Integer.parseInt(fields[0]));
            this.rescuperados.add(Integer.parseInt(fields[1]));
            this.muertos.add(Integer.parseInt(fields[2]));
            this.infectados.add(Integer.parseInt(fields[3]));
            
            line = data.readLine();
         }
         
      } catch (Exception e) {System.out.println("fallo pai, " +e);} 
      finally {
        if (null!=data) {
           data.close();
        }
      }
    }

    public ArrayList<Integer> getDia() {
        return dia;
    }

    public ArrayList<Integer> getInfectados() {
        return infectados;
    }

    public ArrayList<Integer> getRescuperados() {
        return rescuperados;
    }

    public ArrayList<Integer> getMuertos() {
        return muertos;
    }
    
    
    
}
