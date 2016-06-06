package br.edu.utfpr.buildTree.buscaProfundidade;

import java.util.Iterator;

public class BuscaProfundidade implements Algoritmo {

    private Grafo<VerticeBuscaProfundidade, Aresta<VerticeBuscaProfundidade, VerticeBuscaProfundidade>> g;
    private VerticeBuscaProfundidade s;
    private int tempo = 0;
    Iterator<VerticeBuscaProfundidade> iteratorVertice = g.getVertices();
    VerticeBuscaProfundidade u;

    public BuscaProfundidade(Grafo<VerticeBuscaProfundidade, Aresta<VerticeBuscaProfundidade, VerticeBuscaProfundidade>> g, VerticeBuscaProfundidade verticeInicial) {
        if (g.getVertice(verticeInicial.getId()) == null) {
            throw new RuntimeException("O vértice de índice " + verticeInicial.getId() + " não pertence ao grafo " + g.toString() + ". "
                    + "Utilize um vértice válido como argumento do construtor da classe " + this.getClass().getName());
        } else {
            this.g = g;
            this.s = verticeInicial;
            inicializaGrafo();
        }
    }

    //TODO Exercicio 4.1 - Implementar o algoritmo de inicializacao da busca em profundidade
    public void inicializaGrafo() {
        while (iteratorVertice.hasNext()) {
            u = iteratorVertice.next();
            u.setCor(new CorVertice(Cor.Branco));
            u.setPai(null);
        }
        tempo = 0;
//                iteratorVertice =  g.getVertices();
        while (iteratorVertice.hasNext()) {
            u = iteratorVertice.next();
            if (u.getCor().equals(Cor.Branco)) {
                executar();
            }
        }
    }

    //TODO Exercicio 4.2 - Implementar a busca em profundidade
    @Override
    public void executar() {
        VerticeBuscaProfundidade v;
        tempo++;
        u.setTempoDescoberta(tempo);
        u.setCor(new CorVertice(Cor.Cinza));
        Iterator<VerticeBuscaProfundidade> verticesAdjacentes;
        verticesAdjacentes = g.getVerticesAdjacentes(u);
        while (iteratorVertice.hasNext()) {
            v = verticesAdjacentes.next();
            if (v.getCor().equals(Cor.Branco)) {
                if (v.getPai().getCor().equals(Cor.Branco)) {
                    //Aresta de retorno
                    System.out.println("ARESTA DE RETONRO PAI BRANCO");
                    return;
                }
                v.setPai(u);
                executar();
            }
            if (v.getCor().equals(Cor.Preto)) {
                //Aresta de retorno
                System.out.println("ARESTA DE RETONRO VERTICE BRANCO");
                return;
            }

        }
        u.setCor(new CorVertice(Cor.Preto));
        tempo++;
        u.setTempoFinalizacao(tempo);
    }
    //TODO Exercicio 4.3 - Implementar a impressao do grafo

    public void imprimeGrafo(Grafo<VerticeBuscaProfundidade, Aresta<VerticeBuscaProfundidade, VerticeBuscaProfundidade>> g, VerticeBuscaProfundidade s, VerticeBuscaProfundidade v) {
        if (v.equals(s)) {
            System.out.print(s);
        } else if (v.getPai() == null) {
            System.out.print("não há caminho entre " + s + " e " + v);
        } else {
            imprimeGrafo(g, s, v.getPai());
            System.out.print(v);
        }
    }

}
