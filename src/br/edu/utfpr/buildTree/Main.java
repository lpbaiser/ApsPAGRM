package br.edu.utfpr.buildTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Leonardo Baiser <lpbaiser@gmail.com>
 */
public class Main {

    public static void main(String[] args) {
        FileReader fr = new FileReader();
        List<GrafoMatriz> grafos = fr.readFile("/home/leonardo/Dropbox/Grafos/ApsPAGRM/instances/group_1/HDGraph20_20.txt");
        Genetic mlst = new Genetic();
        List<Integer> quantidadeLabels = new ArrayList<>();
        List<Float> tempoPorGrafo = new ArrayList<>();

            for (GrafoMatriz grafo : grafos) {
                long tempoInicial = System.currentTimeMillis();
                List<Integer> listLabels1 = mlst.individuo(grafo);

                List<Integer> listLabels2 = mlst.individuo(grafo);
                if (listLabels1 != null && listLabels2 != null) {
                    listLabels1 = union(listLabels1, listLabels2);
                    List<Integer> crossover = mlst.crossover(grafo, listLabels1);
                    List<Integer> mutation = mlst.mutation(grafo, crossover);
                    quantidadeLabels.add(mutation.size());
                    long tempoFinal = System.currentTimeMillis();
                    float tempo = (tempoFinal - tempoInicial);
                    tempoPorGrafo.add(tempo);
                }
            }
        float soma = 0;
        float tempoTotal = 0;
        for (int i = 0; i < quantidadeLabels.size(); i++) {
            soma += quantidadeLabels.get(i);
            tempoTotal += tempoPorGrafo.get(i);
        }
        tempoTotal = tempoTotal / tempoPorGrafo.size();
        System.out.println("Media de labels por Grafo:" + soma / quantidadeLabels.size());

        System.out.println("Tempo médio:" + tempoTotal + " ms");

    }

    public static List<Integer> uniao(List<Integer> lista1, List<Integer> lista2) {
        for (Integer integer : lista2) {
            if (!lista1.contains(integer)) {
                lista1.add(integer);
            }
        }
        Collections.sort(lista1);
        return lista1;
    }

    public static <T> List<T> union(List<T> list1, List<T> list2) {
        Set<T> set = new HashSet<T>();

        set.addAll(list1);
        set.addAll(list2);

        return new ArrayList<T>(set);
    }

}
