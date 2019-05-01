package Aufgabe1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created to fit the right json output format
 */
public class JsonOutput {

    private List<String> onlyInList1;
    private List<String> onlyInList2;
    private List<String> inBothLists;

    public JsonOutput(List<String> onlyInList1, List<String> onlyInList2, List<String> inBothLists){
        this.onlyInList1 = onlyInList1;
        this.onlyInList2 = onlyInList2;
        this.inBothLists = inBothLists;
    }
}
