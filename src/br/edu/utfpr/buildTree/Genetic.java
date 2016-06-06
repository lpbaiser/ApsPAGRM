package br.edu.utfpr.buildTree;

/**
 *
 * @author Emanuel Mazzer - Joao Gris
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

    public int[][] uniao(int[][] m1, int[][] m2, int[] labels, int indice) {

        int l = m1.length;
        int label = labels[indice];
        int[][] mfinal = m2;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (m1[i][j] == label) {
                    mfinal[i][j] = label;
                } else {
                    mfinal[i][j] = -1;
                }

            }

        }

        int[] vetor = new int[m1.length];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (mfinal[i][j] != -1) {
                    vetor[i] = 1;
                    vetor[j] = 1;

                }

            }
        }
        int j;
        for (j = 0; j < vetor.length; j++) {
            if (vetor[j] != 1) {
                break;
            }

        }
        if (j != vetor.length) {
            uniao(m1, mfinal, labels, indice += 1);

        } else {
            //buscaProfundidade;
        }

        return mfinal;
    }

}
