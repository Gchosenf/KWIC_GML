import java.util.ArrayList;
import java.util.Collections;

public class EventSystem {
    private ArrayList<String> lineTxt;  // 接收输入文本
    private ArrayList<String> kwicList;  // 存放结果

    public EventSystem(ArrayList<String> lineTxt) {
        this.lineTxt = lineTxt;
        this.kwicList = new ArrayList<>();
    }

    public void process() {
        for (String line : lineTxt) {
            onLineInput(line);
        }
        Collections.sort(kwicList, String.CASE_INSENSITIVE_ORDER);
    }

    private void onLineInput(String line) {
        Shift shift = new Shift(new ArrayList<>(Collections.singletonList(line))); // 使用 ArrayList
        shift.shift();
        kwicList.addAll(shift.getKwicList());
    }

    public ArrayList<String> getResults() {
        return kwicList;
    }
}
