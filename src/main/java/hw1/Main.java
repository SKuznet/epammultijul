package hw1;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(final String[] args) {
        Integer[] values = {1, 2, 3, 6, 9, 10, 15, 22};
        ColorCalculator colorCalculator = new ColorCalculator();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for(Integer i : values) {
            executorService.submit(() -> System.out.println(colorCalculator.calculate(i)));
        }
        executorService.shutdown();
    }
}
