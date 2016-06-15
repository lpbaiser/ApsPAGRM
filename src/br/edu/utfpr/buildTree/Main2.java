/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.buildTree;

import com.sun.org.apache.xml.internal.utils.MutableAttrListImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author emanuel
 */
public class Main2 {

    public void processa(List<GrafoMatriz> grafos) {
        MLSTAlgorithm mlst = new MLSTAlgorithm();
        List<List<Integer>> solucao = new ArrayList<>();
        for (GrafoMatriz grafo : grafos) {
            List<Integer> individuo1 = mlst.individuo(grafo);
            List<Integer> individuo2 = mlst.individuo(grafo);
            List<Integer> union = uniao(individuo1, individuo2);
            union = mlst.crossover(grafo, union);
            List<Integer> s = mlst.mutation(grafo, union);
            if (union.size() < s.size()) {
                solucao.add(s);

            } else {
                solucao.add(union);

            }

        }
    }

    public List<Integer> uniao(List<Integer> lista1, List<Integer> lista2) {
        for (Integer integer : lista2) {
            if (!lista1.contains(integer)) {
                lista1.add(integer);
            }
        }
        Collections.sort(lista1);
        return lista1;
    }

}
