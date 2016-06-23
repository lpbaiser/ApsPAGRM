package br.edu.utfpr.buildTree;

import java.util.List;

/**
 *
 * @author Leonardo Baiser <lpbaiser@gmail.com>
 */
public class GrafoMatriz {

    private List<List<Integer>> grafo;
    private List<Integer> labels;
    private int size;

    public GrafoMatriz(List<List<Integer>> grafo, int size, List<Integer> labels) {
        this.grafo = grafo;
        this.size = size;
        this.labels = labels;
    }

    public List<Integer> getLabels() {
        return labels;
    }

    public void setLabels(List<Integer> labels) {
        this.labels = labels;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Integer>> getGrafo() {
        return grafo;
    }

    public void setGrafo(List<List<Integer>> grafo) {
        this.grafo = grafo;
    }
    
   
}
