package br.edu.utfpr.buildTree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonardo Baiser <lpbaiser@gmail.com>
 */
public class GrafoMatrizAdjacencia {

    private List<List<Label>> grafoListaAdjacencia;

    public GrafoMatrizAdjacencia(int size) {
        this.grafoListaAdjacencia = new ArrayList<>();
        for (int i = 0; i < size - 1; i++) {
            List<Label> a = new ArrayList();
            grafoListaAdjacencia.add(i, a);
        }
    }

    public GrafoMatrizAdjacencia() {
        this.grafoListaAdjacencia = new ArrayList<>();
    }
    
    
    
    public List<List<Label>> getGrafoListaAdjacencia() {
        return grafoListaAdjacencia;
    }

    public void setGrafoListaAdjacencia(List<List<Label>> grafo) {
        this.grafoListaAdjacencia = grafo;
    }

}
