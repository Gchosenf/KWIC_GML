import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Output {
    private ArrayList<String> kwicList;

    public Output(ArrayList<String> kwicList) {
        this.kwicList = kwicList;
    }

    public void output(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String s : kwicList) {
                writer.write(s + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
