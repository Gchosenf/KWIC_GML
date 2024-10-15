import java.util.ArrayList;
import java.util.Collections;

public class ObjectOrientedKWIC {
    private ArrayList<String> lineTxt;  // 接收输入文本
    private ArrayList<String> kwicList;  // 存放结果

    public ObjectOrientedKWIC(ArrayList<String> lineTxt) {
        this.lineTxt = lineTxt;
        this.kwicList = new ArrayList<>();
    }

    public void process() {
        for (String line : lineTxt) {
            Shift shift = new Shift(new ArrayList<>(Collections.singletonList(line))); // 使用 ArrayList
            shift.shift();
            kwicList.addAll(shift.getKwicList());
        }
        alphabetize();
    }

    private void alphabetize() {
        Collections.sort(kwicList, String.CASE_INSENSITIVE_ORDER);
    }

    public ArrayList<String> getResults() {
        return kwicList;
    }
}
