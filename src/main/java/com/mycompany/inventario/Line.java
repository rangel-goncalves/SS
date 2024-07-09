package com.mycompany.inventario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author range
 */
public class Line {
    
    public HashMap<String, String> L;
    public String name ="";
    public HashMap<String, Integer> Cabecalho;
    
    public Line(HashMap<String, String> l, String name){
        Cabecalho = new HashMap<>();
        this.L = new HashMap<>();
        this.name =  name;
        /*
        for (Map.Entry<Integer, String> entry : l.entrySet()) {
            System.out.println(entry.getKey());
            L.put(entry.getKey(), entry.getValue());
        }*/
        for (Map.Entry<String, String> entry : l.entrySet()) {
            System.out.println(entry.getKey()+"--"+entry.getValue());
            this.L.put(entry.getKey(), entry.getValue());
        }
        //System.out.println(this.L.get("Manufacturer Part Number 1")+"<<- ");
    }

    public String getName() {
        return name;
    }
    
}