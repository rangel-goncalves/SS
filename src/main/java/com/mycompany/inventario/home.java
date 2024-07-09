package com.mycompany.inventario;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author range
 */
public class home {
    public static final int numMaxarq = 3;
    public int numArquivos;
    public Hashtable<Integer,ArrayList<Line>> arquivos = new Hashtable<>();

    public home() {
        this.arquivos = new Hashtable<>();
        this.numArquivos = 0;
    }   
}
