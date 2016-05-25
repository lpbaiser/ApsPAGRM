package br.edu.utfpr.buildTree;

import java.util.List;

/**
 *
 * @author Leonardo Baiser <lpbaiser@gmail.com>
 */
public class Grafo {
    
    private String grafo[][];
    private int[] quantidadeLabels;

    public Grafo(String[][] grafo, int[] quantidadeLabels) {
        this.grafo = grafo;
        this.quantidadeLabels = quantidadeLabels;
    }

    
    public String[][] getGrafo() {
        return grafo;
    }

    public void setGrafo(String[][] grafo) {
        this.grafo = grafo;
    }

    public int[] getQuantidadeLabels() {
        return quantidadeLabels;
    }

    public void setQuantidadeLabels(int[] quantidadeLabels) {
        this.quantidadeLabels = quantidadeLabels;
    }
    
}
