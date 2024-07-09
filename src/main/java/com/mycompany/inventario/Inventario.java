/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.inventario;

import com.mycompany.inventario.view.Busca;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

public class Inventario {
    static final int numMaxarq = 3;
    public static void main(String[] args) {
        
        Busca b = new Busca();
        b.setVisible(true);
        /*
        int numArquivos = 0;
        Hashtable<Integer,ArrayList<Line>> arquivos = new Hashtable<>();
        /*
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Integer, String> L = new HashMap<>();
        ArrayList<planilha> P = new ArrayList();
        */
        /*
        arquivos.put(numArquivos,OpenTable.openFile());
        numArquivos ++;
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Digite O PN ");
            String PN = scanner.next();
            if(PN.equals("sair")){
                break;
            }
            
            if(PN.equals("add")){
                if (numArquivos < numMaxarq){
                    arquivos.put(numArquivos,OpenTable.openFile());
                    numArquivos ++;
                }else{
                    System.out.println("ja tem 3");
                }
            }
            
            for (int i = 0; i < numArquivos; i++) {
                for (Line lin : arquivos.get(i)) {
                    String s = lin.L.get("Manufacturer Part Number 1");
                    if(s == null){
                        continue;
                    } 
                    if(s.equalsIgnoreCase(PN)){
                        System.out.println(lin.L.get("Value")+ " ---> projeto: "+ lin.getName());
                        break;
                    }
                }
            }
           
        }
        */
    }
}
