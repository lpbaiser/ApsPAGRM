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

//    public List<Integer> individuo(GrafoMatriz grafo) {
//
//        List<Integer> labelsUsed = new ArrayList<>();
//        List<List<Integer>> adjacencyList = new ArrayList<>();
//        for (int i = 0; i < grafo.getSize(); i++) {
//            List a = new ArrayList();
//            for (int j = 0; j < grafo.getSize(); j++) {
//                a.add(null);
//            }
//            adjacencyList.add(i, a);
//        }
//        List<Integer> nodeList = grafo.getLabels();
//
//        while (existsNotConnected(nodeList)) {
//            if (grafo.getLabels().size() <= 0) {
//                return null;
//            }
//            Random r = new Random();
//            int randomLabel = r.nextInt(grafo.getLabels().size());//Pega um rótulo aleatório
//            grafo.getLabels().remove(randomLabel);
//            labelsUsed.add(randomLabel);
//
//            int line = 0, column = 0;
//            for (List<Integer> lineOfGraph : grafo.getGrafo()) {
//                for (Integer columnOfGrapf : lineOfGraph) {
//                    if (columnOfGrapf == randomLabel) {//se o valor do vértice for igual ao rótulo escolhido
//                        List columns = adjacencyList.get(line);
//                        columns.set(column, column+1);
//                        adjacencyList.set(line, columns);//Add vértice da coluna em uma lista de vértices
//                    }
//                    column++;//?
//                }
//                line++;
//                column = 0;
//            }
//            line = 0;
//            column = 0;
//
//        }
//
//        for (List<Integer> list : adjacencyList) {
//            for (Integer value : list) {
//                if (nodeList.contains(value)) {
//                    nodeList.remove(value);
//                }
//            }
//
//        }
//
//        Collections.sort(labelsUsed);
//        return labelsUsed;
//
//    }

    public boolean existsNotConnected(List<Integer> labelList) {
        if (labelList.size() > 0) {
            return true;
        }
        return false;
    }

}
