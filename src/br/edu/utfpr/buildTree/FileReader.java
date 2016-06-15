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

    public List<GrafoMatrizOld> readFile(String path) {
        String line = null;
        int nLabel;

        GrafoMatrizOld grafoMatrix;

        List<List<Integer>> grafo = new ArrayList<>();

        List<GrafoMatrizOld> grafos = new ArrayList<>();

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
                    grafoMatrix = new GrafoMatrizOld(grafo, nLabel, labels);
                    grafos.add(grafoMatrix);
                    grafo = new ArrayList<>();
                }
            }
        } catch (IOException ex) {
            System.err.println("Erro: " + ex.getMessage());
        }

        return grafos;
    }
    
    public List<GrafoMatriz> readFile2(String path) {
        String line = null;
        int nLabel;

        GrafoMatriz grafoMatrix;


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

        GrafoMatrizAdjacencia grafo = new GrafoMatrizAdjacencia();
        List<Label> labels = new ArrayList<>();

        for (int i = 1; i < nLabel; i++) {
            labels.add(new Label(i));
        }

        try {
            while ((line = bufferReader.readLine()) != null) {
                if (!line.equals("")) {
                    String splitLine[] = line.split(" ");
                    List<Label> splitLineInt = new ArrayList<>();
                    for (int i = 0; i < splitLine.length; i++) {
                        splitLineInt.add(new Label(Integer.parseInt(splitLine[i])));
                    }
                    grafo.getGrafoListaAdjacencia().add(splitLineInt);
//                    grafo.add(splitLineInt);
                } else {
                    grafoMatrix = new GrafoMatriz(grafo, nLabel, labels);
                    grafos.add(grafoMatrix);
                    grafo = new GrafoMatrizAdjacencia();
                }
            }
        } catch (IOException ex) {
            System.err.println("Erro: " + ex.getMessage());
        }

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
//        for (GrafoMatrizOld grafo : grafos) {
//            String space = "0 ";
//            for (int i = 0; i < grafo.getGrafoListaAdjacencia().length; i++) {
////                System.out.print(space + " ");
////                space += "0 ";
//                for (int j = 0; j < grafo.getGrafoListaAdjacencia().length; j++) {
//                    if (grafo.getGrafoListaAdjacencia()[i][j] != null) {
//                        System.out.print(grafo.getGrafoListaAdjacencia()[i][j] + " ");
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
