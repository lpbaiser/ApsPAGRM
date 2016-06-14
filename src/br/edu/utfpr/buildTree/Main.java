package br.edu.utfpr.buildTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Leonardo Baiser <lpbaiser@gmail.com>
 */
public class Main {

    public static void main(String[] args) {
        FileReader fr = new FileReader();
//        fr.readFile("/home/leonardo/Dropbox/Grafos/ApsPAGRM/instances/group_1/HDGraph20_20.txt");
        List<GrafoMatriz> grafos = fr.readFile("/home/leonardo/Dropbox/Grafos/ApsPAGRM/instances/group_1/HDGraph20_20.txt");
//        List<GrafoMatriz> grafos = fr.readFile("/home/leonardo/Dropbox/Grafos/ApsPAGRM/instances/test.txt");
//        System.out.println("Labels" + grafos.get(0).getLabels().size());
        MLSTAlgorithm mlst = new MLSTAlgorithm();
        List<Integer> listLabels1 = mlst.individuo(grafos.get(0));
        System.out.print("[ ");
        for (Integer integer : listLabels1) {
            System.out.print(integer + ", ");
        }
        System.out.println(" ]");
        List<Integer> listLabels2 = mlst.individuo(grafos.get(0));
        System.out.print("[ ");
        for (Integer integer : listLabels2) {
            System.out.print(integer + ", ");
        }
        System.out.println(" ]");
        Integer[] v = {1, 4, 5, 6, 10, 11, 16, 17, 18, 19};
        Integer[] c = {1, 2, 3, 4, 6, 7, 8, 10, 11, 13, 16, 17, 19};
//        listLabels1 = Arrays.asList(v);
//        listLabels2 = Arrays.asList(c);
        listLabels1 = new ArrayList<>(Arrays.asList(v));
        listLabels2 = new ArrayList<>(Arrays.asList(c));
       listLabels1 = uniao(listLabels1, listLabels2);
        System.out.println("S: " + listLabels1);
        List<Integer> crossover = mlst.crossover(grafos.get(0), listLabels1);
        System.out.print("[ ");
        for (Integer integer : crossover) {
            System.out.print(integer + ", ");
        }
        System.out.println(" ] \n + SIzE:" + crossover.size());
        
        List<Integer> mutation = mlst.mutation(grafos.get(0), crossover);
        System.out.print("[ ");
        for (Integer integer : mutation) {
            System.out.print(integer + ", ");
        }
        System.out.println(" ] \n + SIzE:" + crossover.size());
        

//        System.out.print("]");
//        fr.readFile("/home/leonardo/Dropbox/Grafos/ApsPAGRM/instances/group_1/MDGraph50_50.txt");
//        fr.readFile("/home/leonardo/Dropbox/Grafos/ApsPAGRM/instances/group_2_with_n=500/MDGraph500_625.txt");
    }
    
    public static List<Integer> uniao(List<Integer> lista1, List<Integer> lista2){
        for (Integer integer : lista2) {
            if (!lista1.contains(integer)){
                lista1.add(integer);
            }
        }
        Collections.sort(lista1);
        return lista1;
    }

}
