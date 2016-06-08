/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.buildTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leonardo
 */
public class FileReader {

    private java.io.FileReader fileReader;
    private BufferedReader bufferReader;

    public List<GrafoMatriz> readFile(String path) {
        String line = null;
        int nVertex;

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
        nVertex = Integer.parseInt(line1[0]);

        List<Integer> labels = new ArrayList<>();
        for (int i = 0; i < nVertex-1; i++) {
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
                    grafoMatrix = new GrafoMatriz(grafo, nVertex, labels);
                    grafos.add(grafoMatrix);
                    grafo = new ArrayList<>();
                    labels = new ArrayList<>();
                }
            }
        } catch (IOException ex) {
            System.err.println("Erro: " + ex.getMessage());
        }

//        printMatrix(grafos);
//        printLabel(grafos);
        return grafos;
    }

//    public void printLabel(List<GrafoMatriz> grafos) {
//        int[] label = grafos.get(0).getQuantidadeLabels();
//        int i = 0;
//        System.out.println("=== Print Label of Matrix ===");
//        for (i = 0; i < label.length; i++) {
//            System.out.println(label[i]);
//        }
//        System.out.println("i: " + i);
//    }
//
//    public void printMatrix(List<GrafoMatriz> grafos) {
//
//        System.out.println("=== Print List of Matrix ===");
//        for (GrafoMatriz grafo : grafos) {
//            String space = "0 ";
//            for (int i = 0; i < grafo.getGrafo().length; i++) {
////                System.out.print(space + " ");
////                space += "0 ";
//                for (int j = 0; j < grafo.getGrafo().length; j++) {
//                    if (grafo.getGrafo()[i][j] != null) {
//                        System.out.print(grafo.getGrafo()[i][j] + " ");
//                    }
//                }
//
//                System.out.println("");
//            }
////            break;
////            System.out.println("");
//
//        }
//    }
}
