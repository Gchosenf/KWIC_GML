import java.util.ArrayList;

public class Input {
    private ArrayList<String> lineTxt = new ArrayList<>();

    public ArrayList<String> getLineTxt() {
        return lineTxt;
    }

    // 新增方法，用于直接设置输入文本
    public void setLines(String[] lines) {
        for (String line : lines) {
            lineTxt.add(line.trim());
        }
    }
}
