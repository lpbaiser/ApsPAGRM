package br.edu.utfpr.buildTree;

import java.util.List;

/**
 *
 * @author Leonardo Baiser <lpbaiser@gmail.com>
 */
public class Main3 {

    
    public static void main(String[] args) {
        FileReader fr = new FileReader();
//        fr.readFile("/home/leonardo/Dropbox/Grafos/ApsPAGRM/instances/group_1/HDGraph20_20.txt");
        List<GrafoMatriz> grafos = fr.readFile2("/home/leonardo/Dropbox/Grafos/ApsPAGRM/instances/group_1/HDGraph20_20.txt");
        Genetic genetic = new Genetic();
        for (GrafoMatriz grafo : grafos) {
            List<Label> individuo1 = genetic.individuo(grafo);
            for (Label label : individuo1) {
                System.out.print(label.getLabel() + " ");
            }
            System.out.println("");
            break;
        }
    }
    
}
