package br.edu.utfpr.buildTree.buscaProfundidade;

public class Vertice {

    private String id;
    private int componenteConexa = -1;

    public Vertice() {
        this.id = String.valueOf(getClass().hashCode());
    }

    public Vertice(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getComponenteConexa() {
        return componenteConexa;
    }

    public void setComponenteConexa(int componenteConexa) {
        this.componenteConexa = componenteConexa;
    }

}
