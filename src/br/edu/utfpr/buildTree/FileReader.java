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

    public List<String[][]> readFile(String path) {
        String line = null;
        int nVertex;
        String breakLabel = null;

        String matrix[][];
        List<String[][]> listMatrix = new ArrayList<>();

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

        matrix = new String[nVertex][nVertex];
        int i = 0;
        try {
            while ((line = bufferReader.readLine()) != null) {

                if (!line.equals("")) {
                    String splitLine[] = line.split(" ");
                    for (int j = 0; j < splitLine.length; j++) {
                        matrix[i][j] = splitLine[j];
                    }
                    i++;
                } else {
                    listMatrix.add(matrix);
                    matrix = new String[nVertex][nVertex];
                    i = 0;
                }
            }
        } catch (IOException ex) {
            System.err.println("Erro: " + ex.getMessage());
        }

        printMatrix(listMatrix);
        return listMatrix;
    }

    public void printMatrix(List<String[][]> listMatrix) {
        System.out.println("=== Print List Matrix ===");
        for (String[][] matrix : listMatrix) {
            for (int i = 0; i < matrix.length; i++) {
                System.out.println();
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][j] != null) {
                        System.out.print(matrix[i][j] + " ");
                    }
                }
            }

        }
    }

}
