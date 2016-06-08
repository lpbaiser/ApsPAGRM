//package br.edu.utfpr.buildTree.buscaProfundidade;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;
//
////TODO Exercício 2.1 - Implementar os métodos para o grafo representado
////por matriz de adjacências
//public class GrafoMatrizAdjacencia implements Grafo<Vertice, Aresta<Vertice, Vertice>> {
//
//    int tipo;
//
//    private int tamanhoMatriz;
//    private int tamanho = 0;
//
//    private Integer[][] matrizAdj;
//
//    private HashMap<Vertice, Integer> verticeToInt = new HashMap<>();
//
//    private HashMap<Integer, Vertice> intToVertice = new HashMap<>();
//
//    private ArrayList<Integer> labels;
//
//    public GrafoMatrizAdjacencia(int tipo, int tamanho) {
//        this.tipo = tipo;
//        this.setLabels(new ArrayList<Integer>());
//        this.setTamanhoMatriz(tamanho);
//    }
//
//    public ArrayList<Integer> getLabels() {
//        return labels;
//    }
//
//    public void setLabels(ArrayList<Integer> labels) {
//        this.labels = labels;
//    }
//
//    public int getTamanhoMatriz() {
//        return tamanhoMatriz;
//    }
//
//    public void setTamanhoMatriz(int tamanhoMatriz) {
//        this.tamanhoMatriz = tamanhoMatriz;
//    }
//
//    @Override
//    public Iterator<Vertice> getVerticesAdjacentes(Vertice u) {
//        getVertices();
//
//        int linha = verticeToInt.get(u);
//        //itera sobre as colunas da matriz
//        for (int j = 0; j < matrizAdj.length; j++) {
//            //tem vertice?
//            if (tipo == 0 && (matrizAdj[linha][j] == 1 || matrizAdj[j][linha] == 1)) {
//                //itera sobre o Map do verticeToInt
//                for (Map.Entry<Vertice, Integer> entry : verticeToInt.entrySet()) {
//                    //o valor da entrada é igual ao valor do id do vértice procurado?
//                    // se sim put o vertice no Map intToVertice
//                    if (entry.getValue() == j) {
//                        intToVertice.put(j, entry.getKey());
//                    }
//                }
//            } else if (matrizAdj[linha][j] == 1 && tipo == 1) {
//                //itera sobre o Map do verticeToInt
//                for (Map.Entry<Vertice, Integer> entry : verticeToInt.entrySet()) {
//                    //o valor da entrada é igual ao valor do id do vértice procurado?
//                    // se sim put o vertice no Map intToVertice
//                    if (entry.getValue() == j) {
//                        intToVertice.put(j, entry.getKey());
//                    }
//                }
//            }
//        }
//        return intToVertice.values().iterator();
//    }
//
//    public Iterator<Vertice> getVerticesAdjacentes2(Vertice u) {
//        Integer v = Integer.parseInt(u.getId());
//        if (u != null && this.getIntToVertice().containsKey(v)) {
//            ArrayList<Vertice> adjs = new ArrayList<Vertice>();
//            int key = this.getVerticeToInt().get(u);
//            /*
//			 * Percorro o matriz na linha [key], variando a coluna, se
//			 * matriz[key][i] == 1 adiciona em uma lista que contem os vertices
//			 * adjacentes.
//             */
//            for (int i = 0; i < this.tamanhoMatriz; i++) {
//                try {
//                    if (this.getMatrizAdj()[key][i] != null && this.getMatrizAdj()[key][i] != this.tamanhoMatriz) {
//                        adjs.add(this.getIntToVertice().get(i));
//                    }
//                    if (this.getMatrizAdj()[i][key] != null && this.getMatrizAdj()[i][key] != this.TamanhoMatrizAdj) {
//                        adjs.add(this.getIntToVert().get(i));
//                    }
//                } catch (NullPointerException e) {
//                    System.out.println("err: " + e);
//                }
//            }
//            return adjs.iterator();
//        } else {
//            return null;
//        }
//    }
//
//    public Integer[][] getMatrizAdj() {
//        return matrizAdj;
//    }
//
//    public void setMatrizAdj(Integer[][] matrizAdj) {
//        this.matrizAdj = matrizAdj;
//    }
//
//    @Override
//    public Iterator<Vertice> getVertices() {
//        return this.verticeToInt.keySet().iterator();
//    }
//
//    @Override
//    public Iterator<Aresta<Vertice, Vertice>> getArestas() {
//        Set<Aresta<Vertice, Vertice>> arestas = new HashSet<>();
//        getVertices();
//
//        for (Map.Entry<Vertice, Integer> entry : verticeToInt.entrySet()) {
//            intToVertice = new HashMap<>();
//            getVerticesAdjacentes(entry.getKey());
//            for (Map.Entry<Integer, Vertice> entry1 : intToVertice.entrySet()) {
//                arestas.add(new Aresta<Vertice, Vertice>(entry.getKey(), entry1.getValue()));
//            }
//        }
//        return arestas.iterator();
//    }
//
//    @Override
//    public Vertice getVertice(String idVertice) {
//        for (Map.Entry<Vertice, Integer> entry : verticeToInt.entrySet()) {
//            if (entry.getKey().getId().equals(idVertice)) {
//                return entry.getKey();
//            }
//
//        }
//        return null;
//    }
//
//    @Override
//    public void adicionaVertice(Vertice verticeNoGrafo, Vertice verticeAdicionado) {
//        Vertice v = getVertice(verticeNoGrafo.getId());
//
//        if (v == null) {
//            throw new RuntimeException("O vértice com identificador "
//                    + verticeNoGrafo.getId()
//                    + " precisa necessariamente estar no grafo.");
//        } // else -> vertice esta no grafo !
//        else {
//            Vertice v2 = getVertice(verticeAdicionado.getId());
//            int idV1 = verticeToInt.get(v);
//            //vertice adicionado não esta no grafo? se estiver no else apenas insere a aresta,
//            //caso não, insere o vertice e aresta
//            if (v2 == null && matrizAdj.length == tamanhoMatriz) {
//                matrizAdj = copyMatriz(tamanhoMatriz + 1, matrizAdj);
//                tamanhoMatriz++;
//                matrizAdj[idV1][tamanhoMatriz - 1] = 1;
//                verticeToInt.put(verticeAdicionado, tamanhoMatriz - 1);
//            } else {
//                int idV2 = verticeToInt.get(v2);
//                matrizAdj[idV1][idV2] = 1;
//            }
//        }
//    }
//
//    @Override
//    public void adicionaVertice(Vertice verticeAdicionado) {
//        /*
//		 * Mapeia no HashMap, mas não coloca na matriz pois nao tem vertice
//		 * adjacente.
//         */
//        Vertice v = getVertice(verticeAdicionado.getId());
//        if (v == null) {
//            if (getVertice(verticeAdicionado.getId()) == (null)) {
//                if (this.intToVertice == null && this.verticeToInt == null) {
//                    mapeiaVertice(verticeAdicionado);
//                }
//            }
//        } else {
//            System.out.println("Este vértice já foi inserido no grafo");
//            verticeAdicionado = v;
//        }
//    }
//
//    @Override
//    public void adicionaAresta(Aresta<Vertice, Vertice> arestaAdicionada) {
//        if (arestaAdicionada.getVertice1() == null || arestaAdicionada.getVertice2() == null) {
//            throw new RuntimeException("Não é possível adicionar uma aresta com vértice nulos no grafo");
//        } else {
//            // vertice 1 da aresta já existe no grafo ?
//            // se não, adiciona o vertice na matriz grafo
//            Vertice v1 = getVertice(arestaAdicionada.getVertice1().getId());
//            if (v1 == null) {
//                adicionaVertice(arestaAdicionada.getVertice1());
//            }
//            // vertice 2 da aresta já existe no grafo ?
//            // se não, adiciona o vertice na matriz grafo
//            Vertice v2 = getVertice(arestaAdicionada.getVertice2().getId());
//            if (v2 == null) {
//                adicionaVertice(arestaAdicionada.getVertice2());
//            }
//
//            int line = 0, col = 0;
//            v1 = getVertice(arestaAdicionada.getVertice1().getId());
//            v2 = getVertice(arestaAdicionada.getVertice2().getId());
//            for (Map.Entry<Vertice, Integer> entry : verticeToInt.entrySet()) {
//                if (entry.getKey() == v1) {
//                    line = entry.getValue();
//                }
//                if (entry.getKey() == v2) {
//                    col = entry.getValue();
//                }
//            }
//
//            matrizAdj[line][col] = 1;
//
//        }
//    }
//
//    /**
//     * Busca em profundidade que verifica quantas compenentes há no grafo.
//     *
//     * @param vertice
//     * @param id
//     */
//    private void dfs2Cc(Vertice vertice, int id) {
//        vertice.setComponenteConexa(id);
//
//        Iterator<Vertice> it = this.getVerticesAdjacentes2(vertice);
//        while (it.hasNext()) {
//            Vertice aux = it.next();
//
//            if (aux.getComponenteConexa() == -1) {
//                dfs2Cc(aux, id);
//            }
//        }
//    }
//
//    public int connectedComponent() {
//        int id = 0;
//
//        for (Vertice vertice : this.intToVertice.values()) {
//            if (vertice.getComponenteConexa() == -1) {
//                dfs2Cc(vertice, id++);
//            }
//        }
//
//        return id;
//    }
//
//    /**
//     * Função responsável por mapear um novo vertice ao HashMap.
//     *
//     * @param vertice vertice a ser adicionado ao HashMap
//     */
//    public void mapeiaVertice(Vertice vertice) {
//        if (!getIntToVertice().containsKey(this.tamanho)
//                && !getVerticeToInt().containsValue(vertice)) {
//            this.getIntToVertice().put(tamanho, vertice);
//            this.getVerticeToInt().put(vertice, tamanho);
//            // System.out.println("key: " + this.VertToInt.get(vertice) +
//            // "value: " + this.IntToVert.get(TamanhoAtual).getId());
//            this.tamanho++;
//        } else {
//            throw new RuntimeException("A key " + this.tamanho
//                    + "já está mapeada no HashMap.");
//        }
//    }
//
//    public HashMap<Vertice, Integer> getVerticeToInt() {
//        return verticeToInt;
//    }
//
//    public void setVerticeToInt(HashMap<Vertice, Integer> verticeToInt) {
//        this.verticeToInt = verticeToInt;
//    }
//
//    public HashMap<Integer, Vertice> getIntToVertice() {
//        return intToVertice;
//    }
//
//    public void setIntToVertice(HashMap<Integer, Vertice> intToVertice) {
//        this.intToVertice = intToVertice;
//    }
//
//}
