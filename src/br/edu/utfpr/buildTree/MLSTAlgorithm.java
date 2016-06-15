package br.edu.utfpr.buildTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Leonardo Baiser <lpbaiser@gmail.com>
 */
public class MLSTAlgorithm {

    public List<Integer> individuo(GrafoMatrizOld grafo) {
        
        //lista de labels usados
        List<Integer> labelsUsed = new ArrayList<>();

        //lista de labels do grafo
        //lista de vertices de grafo
        List<Integer> labelsGrafo = new ArrayList();
        List<Integer> verticesGrafo = new ArrayList();
        for (int i = 1; i < grafo.getSize(); i++) {
            labelsGrafo.add(i);
            verticesGrafo.add(i);
        }
        
        // Cria uma matriz de adjacencia
        List<List<Integer>> subgrafo = new ArrayList<>();
        for (int i = 0; i < grafo.getSize() - 1; i++) {
            List a = new ArrayList();
            subgrafo.add(i, a);
        }

        //equanto houver vertices nao conectados 
        while (existsNotConnected(verticesGrafo)) {
            
            //se não existi labels no grafo, não há como gerar um indivíduo
            if (labelsGrafo.size() <= 0) {
                return null;
            }
            //Embaralha a lista de labels do grafo
            Collections.shuffle(labelsGrafo);
            //Pega o primeiro label, este label é randômico devido a linha acima
            Integer randomLabel = labelsGrafo.get(0);
//            Integer randomLabel = 10;
//            System.out.println("Label:" + randomLabel);
            labelsGrafo.remove(randomLabel);
            labelsUsed.add(randomLabel);

            int line = 0, column = 0;
            //Determine the number of connected components when inserting all edges with label i in H
            for (List<Integer> lineOfGraph : grafo.getGrafo()) {
                for (Integer columnOfGrapf : lineOfGraph) {
                    if (columnOfGrapf.equals(randomLabel)) {//se o valor do vértice for igual ao rótulo escolhido
                        subgrafo.get(line).add(column + 1);//Add vértice da coluna em uma lista de vértices
                    }
                    column++;
                }
                line++;
                column = 0;
            }
            line = 0;
            column = 0;

            //Remove da lista de vétices do grafo todos os vértices que compunham o subgrafo
            for (List<Integer> list : subgrafo) {
                for (Integer value : list) {
                    if (verticesGrafo.contains(value)) {
                        verticesGrafo.remove(value);
                    }
                }
            }

        }

        Collections.sort(labelsUsed);
        return labelsUsed;
    }

    public List<Integer> crossover(GrafoMatrizOld grafo, List<Integer> s) {

        List<Integer> frequencia = new ArrayList<>();
        for (int i = 0; i < s.size(); i++) {
            frequencia.add(0);
        }
        int i = 0; //posição que será incrementado a frequencia
        for (Integer label : s) {
            for (List<Integer> lineOfGraph : grafo.getGrafo()) {
                for (Integer columnOfGrapf : lineOfGraph) {
                    if (columnOfGrapf.equals(label)) {
                        frequencia.set(i, frequencia.get(i) + 1);
                    }
                }
            }
            i++;
        }

        System.out.println("Freq: " + frequencia);

        List<Integer> labelsGrafo = new ArrayList();
        for (i = 1; i < grafo.getSize(); i++) {
            labelsGrafo.add(i);
        }
        List<Integer> labelsUsed = new ArrayList<>();

        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (i = 0; i < grafo.getSize() - 1; i++) {
            List a = new ArrayList();
            adjacencyList.add(i, a);
        }

        int line = 0, column = 0;
        while (existsNotConnected(labelsGrafo)) {
            int indexMaxValor = frequencia.indexOf(Collections.max(frequencia));
//            System.out.println("index" + indexMaxValor);
            frequencia.set(indexMaxValor, 0);
            int maxValorDeS = s.get(indexMaxValor);
            if (!labelsUsed.contains(maxValorDeS)) {
                labelsUsed.add(maxValorDeS);
            }

            for (List<Integer> lineOfGraph : grafo.getGrafo()) {
                for (Integer columnOfGrapf : lineOfGraph) {
                    if (columnOfGrapf.equals(maxValorDeS)) {
                        adjacencyList.get(line).add(column + 1);//Add vértice da coluna em uma lista de vértices
                    }
                    column++;
                }
                column = 0;
                line++;
            }
            line = 0;
            column = 0;

            for (List<Integer> list : adjacencyList) {
                for (Integer value : list) {
                    if (labelsGrafo.contains(value)) {
                        labelsGrafo.remove(value);
                    }
                }
            }
        }
        Collections.sort(labelsUsed);
        return labelsUsed;
    }

    public List<Integer> mutation(GrafoMatrizOld grafo, List<Integer> s) {

        List<Integer> rotulosNaoUtilizados = new ArrayList<>();
        for (int i = 1; i < grafo.getSize(); i++) {
            rotulosNaoUtilizados.add(i);
        }
        System.out.println("S antes: " + s);

        //Encontre um rótulo não utilizado em 's' e adicione em s
        while (true) {
            Collections.shuffle(rotulosNaoUtilizados);
            Integer randomLabel = 7;
//            Integer randomLabel = rotulosNaoUtilizados.get(0);
            if (!s.contains(randomLabel)) {
                System.out.println("Adicionando o rotulo: " + randomLabel);
                s.add(randomLabel);
                Collections.sort(s);
                break;
            }
        }

        System.out.println("S depois: " + s);

        List<Integer> frequencia = new ArrayList<>();
        for (int i = 0; i < s.size(); i++) {
            frequencia.add(0);
        }

        int i = 0; //posição que será incrementado a frequencia
        for (Integer label : s) {
            for (List<Integer> lineOfGraph : grafo.getGrafo()) {
                for (Integer columnOfGrapf : lineOfGraph) {
                    if (columnOfGrapf.equals(label)) {
                        frequencia.set(i, frequencia.get(i) + 1);
                    }
                }
            }
            i++;
        }
//        frequencia.set(6, frequencia.get(6) + 1);
//        System.out.println("Freq/Rotulo: " + frequencia);

        int column = 0;
        int line = 0;
        for (int j = 0; j < s.size(); j++) {
            
            List<List<Integer>> adjacencyList = new ArrayList<>();
            for (i = 0; i < grafo.getSize() - 1; i++) {
                List a = new ArrayList();
                adjacencyList.add(i, a);
            }
            
            List<Integer> listLabel = new ArrayList<>();
            for (int k = 1; k < grafo.getSize(); k++) {
                listLabel.add(k);
            }
            
            System.out.println("Freq/Rótulo: " + frequencia);
            
            int indexMinValor = frequencia.indexOf(Collections.min(frequencia));
            Integer verticeRemovido = s.get(indexMinValor);
            frequencia.remove(indexMinValor);
            s.remove(indexMinValor);

            System.out.println("");
            System.out.println("Rótulos: " + s);
            System.out.println("Lista de nós: " + listLabel);
            System.out.println("Freq/Rótulo: " + frequencia);
            System.out.println("Index: " + indexMinValor);
            System.out.println("Tentando remover: " + verticeRemovido);
            System.out.println("");

            for (Integer label : s) {
                for (List<Integer> lineOfGraph : grafo.getGrafo()) {
                    for (Integer columnOfGrapf : lineOfGraph) {
                        if (columnOfGrapf.equals(label)) {
                            adjacencyList.get(line).add(column + 1);//Add vértice da coluna em uma lista de vértices
                        }
                        column++;
                    }
                    column = 0;
                    line++;
                }
                line = 0;
                column = 0;
            }

            for (List<Integer> list : adjacencyList) {
                for (Integer value : list) {
                    if (listLabel.contains(value)) {
                        listLabel.remove(value);
                    }
                }
            }
            if (existsNotConnected(listLabel)) {
                frequencia.set(indexMinValor, 10000);
                s.add(verticeRemovido);
//                s.set(indexMinValor, verticeRemovido);
                Collections.sort(s);
            } else {
                System.out.println("Removeu o nó " + verticeRemovido);
            }
        }

        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (i = 0; i < grafo.getSize() - 1; i++) {
            List a = new ArrayList();
            adjacencyList.add(i, a);
        }

        line = 0;
        column = 0;

        for (Integer label : s) {
            for (List<Integer> lineOfGraph : grafo.getGrafo()) {
                for (Integer columnOfGrapf : lineOfGraph) {
                    if (columnOfGrapf.equals(label)) {
                        adjacencyList.get(line).add(column + 1);//Add vértice da coluna em uma lista de vértices
                    }
                    column++;
                }
                column = 0;
                line++;
            }
            line = 0;
            column = 0;
        }

//        for (List<Integer> list : adjacencyList) {
//            for (Integer integer : list) {
//                integer = grafo.getSize() - integer;
//            }
//        }
//        
//        
//        List<List<Integer>> newAdjacencyList = new ArrayList<>();
//        for (i = 0; i < grafo.getSize() - 1; i++) {
//            List a = new ArrayList();
//            newAdjacencyList.add(i, a);
//        }
//        List<Integer> verticesUsados = new ArrayList<>();
//        for (i = 1; i < grafo.getSize(); i++) {
//            verticesUsados.add(i);
//        }
//        
//        for (List<Integer> list : adjacencyList) {
//            for (Integer integer : list) {
//                for (Integer vertice :verticesUsados) {
//                    if (integer.equals(vertice)){
//                        verticesUsados.remove(vertice);
//                        newAdjacencyList.get(line).add(integer);
//                    }
//                }
//            }
//        }
        Collections.sort(s);
        return s;
    }

    public boolean existsNotConnected(List<Integer> labelList) {
        if (labelList.size() > 0) {
            return true;
        }
        return false;
    }

    public Integer getLabelMaxFrequency(List<Integer> labels) {
        int max = 0;
        Integer labelEscolhido = 0;
        Integer i = 0;
        for (Integer label : labels) {
            if (label > max) {
                labelEscolhido = i;
                max = label;
            }
            i++;
        }
        return labelEscolhido;
    }

//    public int getIndexMaxFrequency(List<Integer> frequencyList){
//        
//        for (int i = 0; i < frequencyList.size(); i++) {
//            
//            
//        }
//    }
}
