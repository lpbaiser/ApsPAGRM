package br.edu.utfpr.buildTree;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Leonardo Baiser <lpbaiser@gmail.com>
 */
public class GrafoMatriz {

    private List<List<Integer>> grafo;
    HashMap<Integer, Integer> frequancyLabel;
    private int size;

    public GrafoMatriz(List<List<Integer>> grafo, int size, HashMap<Integer, Integer> frequancyLabel) {
        this.grafo = grafo;
        this.size = size;
        this.frequancyLabel = frequancyLabel;
    }

//    public static Grafo grafoMatrixToGafo(GrafoMatriz matrix) {
//        Grafo<VerticeBuscaProfundidade, Aresta<VerticeBuscaProfundidade, VerticeBuscaProfundidade>> g;
//        g = GrafoFactory.constroiGrafo(Representacao.MATRIZ_ADJACENCIA, Grafo.NAO_DIRECIONADO);
//        VerticeBuscaProfundidade s = new VerticeBuscaProfundidade();
//        s.setId("0");
//        g.adicionaVertice(s);
//        String grafo[][] = matrix.getGrafo();
//        for (int i = 0; i < grafo.length; i++) {
//            for (int j = 0; j < grafo.length; j++) {
//                if (grafo[i][j] != null) {
//                    if (!grafo[i][j].equals(matrix.label)) {
//                        VerticeBuscaProfundidade a = new VerticeBuscaProfundidade(String.valueOf(i));
//                        VerticeBuscaProfundidade b = new VerticeBuscaProfundidade(String.valueOf(j));
//                        g.adicionaVertice(a, b);
//                    }
//                }
//            }
//
//        }
//        return g;
//    }

    public HashMap<Integer, Integer> getFrequancyLabel() {
        return frequancyLabel;
    }

    public void setFrequancyLabel(HashMap<Integer, Integer> frequancyLabel) {
        this.frequancyLabel = frequancyLabel;
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
