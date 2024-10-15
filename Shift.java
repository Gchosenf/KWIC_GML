import java.util.ArrayList;
import java.util.StringTokenizer;

public class Shift {
    private ArrayList<String> kwicList = new ArrayList<>();
    private ArrayList<String> lineTxt;

    public Shift(ArrayList<String> lineTxt) {
        this.lineTxt = lineTxt;
    }

    public ArrayList<String> getKwicList() {
        return kwicList;
    }

    public void shift() {
        for (String line : lineTxt) {
            StringTokenizer token = new StringTokenizer(line);
            ArrayList<String> tokens = new ArrayList<>();
            while (token.hasMoreTokens()) {
                tokens.add(token.nextToken());
            }
            int count = tokens.size();
            for (int i = 0; i < count; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < count; j++) {
                    sb.append(tokens.get((i + j) % count)).append(" ");
                }
                kwicList.add(sb.toString().trim());
            }
        }
    }
}
