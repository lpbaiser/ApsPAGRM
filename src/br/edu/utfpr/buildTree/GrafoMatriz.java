package br.edu.utfpr.buildTree;

import java.util.List;

/**
 *
 * @author Leonardo Baiser <lpbaiser@gmail.com>
 */
public class GrafoMatriz {

    private GrafoMatrizAdjacencia grafoListaAdjacencia;
    private List<Label> labels;
    private int size;

    public GrafoMatriz(GrafoMatrizAdjacencia grafo, int size, List<Label> labels) {
        this.grafoListaAdjacencia = grafo;
        this.size = size;
        this.labels = labels;
    }

    public GrafoMatrizAdjacencia getGrafo() {
        return grafoListaAdjacencia;
    }

    public void setGrafo(GrafoMatrizAdjacencia grafo) {
        this.grafoListaAdjacencia = grafo;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
