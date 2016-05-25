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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leonardo
 */
public class FileReader {

    private java.io.FileReader fileReader;
    private BufferedReader bufferReader;

    public List<Grafo> readFile(String path) {
        String line = null;
        int nVertex;
        String breakLabel = null;

        Grafo grafo;

        String matrix[][];
        List<Grafo> grafos = new ArrayList<>();

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
        breakLabel = line1[1];

        int[] quantidadeLabels = new int[nVertex];

        matrix = new String[nVertex][nVertex];
        int i = 0;
        try {
            while ((line = bufferReader.readLine()) != null) {
                if (!line.equals("")) {
                    String splitLine[] = line.split(" ");
                    for (int j = 0; j < splitLine.length; j++) {
                        matrix[i][j] = splitLine[j];
                        int label = Integer.parseInt(splitLine[j]);
                        if (label != nVertex){
                            quantidadeLabels[label]++;
                        }
                    }
                    i++;
                } else {
                    grafo = new Grafo(matrix, quantidadeLabels);
                    grafos.add(grafo);
                    matrix = new String[nVertex][nVertex];
                    quantidadeLabels = new int[nVertex];
                    i = 0;
                }
            }
        } catch (IOException ex) {
            System.err.println("Erro: " + ex.getMessage());
        }

        printMatrix(grafos);
        return grafos;
    }

    public void printMatrix(List<Grafo> grafos) {
        System.out.println("=== Print List Matrix ===");
        for (Grafo grafo : grafos) {
            for (int i = 0; i < grafo.getGrafo().length; i++) {
                System.out.println();
                for (int j = 0; j < grafo.getGrafo().length; j++) {
                    if (grafo.getGrafo()[i][j] != null) {
                        System.out.print(grafo.getGrafo()[i][j] + " ");
                    }
                }
            }

        }
    }

}
