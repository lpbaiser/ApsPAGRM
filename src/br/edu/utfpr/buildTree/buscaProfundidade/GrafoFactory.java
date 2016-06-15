package br.edu.utfpr.buildTree.buscaProfundidade;

import br.edu.utfpr.buildTree.GrafoMatrizOld;




public class GrafoFactory implements Factory {
	public static Grafo constroiGrafo(Representacao r, int tipo ){
		switch(r){
			case MATRIZ_ADJACENCIA:
				return new GrafoMatrizAdjacencia(tipo, tipo);
		}
		return null;
	}
}
