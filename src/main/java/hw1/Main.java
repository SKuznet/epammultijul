package hw1;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Pattern pattern = Pattern.compile("\\d+");
        Scanner scanner = new Scanner(System.in);
        System.out.println("To stop write 'buy'");
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.trim().toLowerCase().equals("buy"))
                break;
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                TrafficLight trafficLight = new TrafficLight(Integer.valueOf(matcher.group()));
                try {
                    System.out.println(executorService.submit(trafficLight).get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
        executorService.shutdown();
    }

}
