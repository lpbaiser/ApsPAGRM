package br.edu.utfpr.buildTree;

/**
 *
 * @author Leonardo Baiser <lpbaiser@gmail.com>
 */
public class Genetic {

    public int[] ordenar(int[] label) {
        int[] vetor = new int[label.length];
        int aux = 0;
        for (int i = 0; i < label.length; i++) {
            for (int j = 0; j < label.length; j++) {

                if (label[i] > label[aux]) {
                    aux = i;
                }
            }
        }
        int j = 0;//esse j
        label[aux] = 0;
        vetor[j] = aux;
        j++;
        
        return null;
    }

    public int[][] uniao(int[][] m1, int[][] m2, int[] labels) {

        int l = m1.length;
        int[][] mfinal = new int[l][];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {

            }

        }
        return mfinal;
    }

}
