/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.buildTree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leonardo
 */
public class FileReader {

    private java.io.FileReader fileReader;
    private BufferedReader bufferReader;

    public List<GrafoMatriz> readFile(String path) {
        String line = null;
        int nLabel;

        GrafoMatriz grafoMatrix;

        List<List<Integer>> grafo = new ArrayList<>();

        List<GrafoMatriz> grafos = new ArrayList<>();

        try {
            fileReader = new java.io.FileReader(path);
            bufferReader = new BufferedReader(fileReader);

            line = bufferReader.readLine();
        } catch (Exception ex) {
            System.err.println("Erro: " + ex.getMessage());
            return null;
        }

        String line1[] = line.split(" ");
        nLabel = Integer.parseInt(line1[0]);

        List<Integer> labels = new ArrayList<>();

        for (int i = 1; i < nLabel; i++) {
            labels.add(i);
        }

        try {
            while ((line = bufferReader.readLine()) != null) {
                if (!line.equals("")) {
                    String splitLine[] = line.split(" ");
                    List<Integer> splitLineInt = new ArrayList<>();
                    for (int i = 0; i < splitLine.length; i++) {
                        splitLineInt.add(Integer.parseInt(splitLine[i]));

                    }
                    grafo.add(splitLineInt);
                } else {
                    grafoMatrix = new GrafoMatriz(grafo, nLabel, labels);
                    grafos.add(grafoMatrix);
                    grafo = new ArrayList<>();
                }
            }
        } catch (IOException ex) {
            System.err.println("Erro: " + ex.getMessage());
        }

        return grafos;
    }

    
    public static void gravar(List<List<Integer>> adjacentList, List<Integer> labels) {
        File file = new File("/home/leonardo/Documents/matrizAdj.txt");
        try {
            FileWriter writer = new FileWriter(file);

            Collections.sort(labels);
            writer.write("Mutation: [");
            for (Integer label : labels) {
                writer.write(label + " ");
            }

            writer.write("]\n");
            
            int i = 0;
            for (List<Integer> lineOfGraph : adjacentList) {
//                System.out.print("(" + i + ") ->");
                writer.write("(" + i + ") ->");
                Collections.sort(lineOfGraph);
                for (Integer columnOfGrapf : lineOfGraph) {
                    writer.write(columnOfGrapf + " ");
                }
                writer.write("\n");
                i++;
            }
            writer.close();

        } catch (IOException ex) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

  

}
