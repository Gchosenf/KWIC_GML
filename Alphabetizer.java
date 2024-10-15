import java.util.ArrayList;
import java.util.Collections;

public class Alphabetizer {
    private ArrayList<String> kwicList;

    public Alphabetizer(ArrayList<String> kwicList) {
        this.kwicList = kwicList;
    }

    public void sort() {
        Collections.sort(this.kwicList, String.CASE_INSENSITIVE_ORDER);
    }

    public ArrayList<String> getKwicList() {
        return kwicList;
    }
}
