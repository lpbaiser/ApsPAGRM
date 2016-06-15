package br.edu.utfpr.buildTree;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javafx.print.Collation;

/**
 *
 * @author Leonardo Baiser <lpbaiser@gmail.com>
 */
public class Label {
    
    private Integer label;

    public Label() {
    }
    
    public Label(int label) {
        this.label = label;
    }

    public Integer getLabel() {
        return label;
    }

    public void setLabel(Integer label) {
        this.label = label;
    }
    
    public static List<Label> sort (List<Label> labels){
        LabelComparator labelComparator = new LabelComparator();
        Collections.sort(labels, labelComparator);
        return labels;
    }
    
    public static class LabelComparator implements Comparator<Label> {
    public int compare(Label label, Label outraLabel) {
        return label.getLabel().
                compareTo(outraLabel.getLabel());
    }
}

}
