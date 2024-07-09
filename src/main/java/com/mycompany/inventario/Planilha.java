package com.mycompany.inventario;

import java.util.ArrayList;

/**
 *
 * @author range
 */
public class Planilha {
    
    public ArrayList<Line> lines;
    public String name = "";

    public Planilha(ArrayList<Line> lines, String name) {
        this.lines = lines;
        this.name =  name;
    }

    public String getName() {
        return name;
    }
   
}
