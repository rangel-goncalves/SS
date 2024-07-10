package com.mycompany.inventario;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author range
 */
public class OpenTable {
    public static Planilha openFile(){
        HashMap<Integer,String> map = new HashMap<>();
        HashMap<String, String> L = new HashMap<>();
        ArrayList<Line> P = new ArrayList();
        
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos Excel (*.xlsx)", "xlsx");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);
        
        // Verifica se o usuário selecionou um arquivo
        if (result == JFileChooser.APPROVE_OPTION) {
            // Obtém o arquivo selecionado
            File selectedFile = fileChooser.getSelectedFile();

            FileInputStream files;
            try {
                files = new FileInputStream(selectedFile);
                XSSFWorkbook old_file = new XSSFWorkbook(files);
                XSSFSheet planilha = old_file.getSheetAt(0);

                Iterator<Row> linhas = planilha.iterator();
                int i = 0;
                Row row = linhas.next();
                Iterator<Cell> cellColum = row.cellIterator();
                while (cellColum.hasNext()) {
                    Cell cell = cellColum.next();
                    if (cell.getCellType() == CellType.STRING) {
                        String valorString = cell.getStringCellValue();
                        map.put(i,valorString);
                        i++;
                        System.out.println(valorString);
                    } else if (cell.getCellType() == CellType.NUMERIC) {
                        // Aqui pode dar algum erro caso o numero realmente precise ser um double, mas como quantidade e posição não vai ser nunca(eu acho) não tem problem
                        Integer valorNumerico = (int)cell.getNumericCellValue();
                        map.put(i,valorNumerico.toString());
                        i++;
                        System.out.println(valorNumerico);
                    } else {
                        map.put(i,""+cell.getCellType());
                        i++;
                        System.out.println(cell.getCellType()+" aqui");
                    }
                }
                //System.out.println("aqui"+map.get("Manufacturer Part Number 1"));
                
                while (linhas.hasNext()) {
                    i = 0;
                    L = new HashMap<>();
                    row = linhas.next();
                    cellColum = row.cellIterator();
                    while (cellColum.hasNext()) {
                        Cell cell = cellColum.next();
                        if (cell.getCellType() == CellType.STRING) {
                            String valorString = cell.getStringCellValue();
                            L.put(map.get(i),valorString);
                            i++;
                            //System.out.print(L.get(i-1)+" ");
                        } else if (cell.getCellType() == CellType.NUMERIC) {
                            // Aqui pode dar algum erro caso o numero realmente precise ser um double, mas como quantidade e posição não vai ser nunca(eu acho) não tem problem
                            Integer valorNumerico = (int)cell.getNumericCellValue();
                            L.put(map.get(i),valorNumerico.toString());
                            i++;
                            //System.out.print(L.get(i-1)+" ");
                        } else {
                            L.put(map.get(i),""+cell.getCellType().toString());
                            i++;
                            //System.out.print(L.get(i-1)+" ");
                        }
                    }
                    //System.out.println("");
                    Line p = new Line(L);
                    P.add(p);
                    
                }
                //System.out.println(selectedFile.getName()+" adivionado a lista");
                return new Planilha(P, selectedFile.getName());

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Nenhum arquivo selecionado.");
            return null;
        }
        return null;
    }
}
