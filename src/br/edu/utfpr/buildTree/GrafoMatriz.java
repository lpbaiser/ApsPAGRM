package br.edu.utfpr.buildTree;

import br.edu.utfpr.buildTree.buscaProfundidade.Aresta;
import br.edu.utfpr.buildTree.buscaProfundidade.Grafo;
import br.edu.utfpr.buildTree.buscaProfundidade.GrafoFactory;
import br.edu.utfpr.buildTree.buscaProfundidade.Representacao;
import br.edu.utfpr.buildTree.buscaProfundidade.Vertice;
import br.edu.utfpr.buildTree.buscaProfundidade.VerticeBuscaProfundidade;

/**
 *
 * @author Leonardo Baiser <lpbaiser@gmail.com>
 */
public class GrafoMatriz {

    private String grafo[][];
    private int[] quantidadeLabels;
    private String label;

    public GrafoMatriz(String[][] grafo, int[] quantidadeLabels, String label) {
        this.grafo = grafo;
        this.quantidadeLabels = quantidadeLabels;
        this.label = label;
    }

    public static Grafo grafoMatrixToGafo(GrafoMatriz matrix) {
        Grafo<VerticeBuscaProfundidade, Aresta<VerticeBuscaProfundidade, VerticeBuscaProfundidade>> g;
        g = GrafoFactory.constroiGrafo(Representacao.MATRIZ_ADJACENCIA, Grafo.NAO_DIRECIONADO);
        VerticeBuscaProfundidade s = new VerticeBuscaProfundidade();
        s.setId("0");
        g.adicionaVertice(s);
        String grafo[][] = matrix.getGrafo();
        for (int i = 0; i < grafo.length; i++) {
            for (int j = 0; j < grafo.length; j++) {
                if (grafo[i][j] != null) {
                    if (!grafo[i][j].equals(matrix.label)) {
                        VerticeBuscaProfundidade a = new VerticeBuscaProfundidade(String.valueOf(i));
                        VerticeBuscaProfundidade b = new VerticeBuscaProfundidade(String.valueOf(j));
                        g.adicionaVertice(a, b);
                    }
                }
            }

        }
        return g;
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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
