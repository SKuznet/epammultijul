package hw1;

import java.util.Arrays;
import java.util.List;

public class ConsoleReader {
    private LightController controller = new LightController();
    private List<Double> entries = Arrays.asList(1.0, 2.0, 2.1, 3.0, 5.0, 5.1, 6.0, 9.1);

    public static void main(String[] args) {
        ConsoleReader consoleReader = new ConsoleReader();
        consoleReader.readFromCollection();
    }

    private void readFromCollection() {
        entries.forEach(entry -> controller.getLightByMinute(entry));
    }
}
