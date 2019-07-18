package light.hw0;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private final static Logger mainLogger = LogManager.getLogger(Main.class);
    private static final int sleepTime = 3000;

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^[0-9]+$");
        int numberOfThreads = 5;
        mainLogger.info("Creating ThreadPool with " + numberOfThreads + " threads.");
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        mainLogger.info("ThreadPool is created");
        mainLogger.warn("\n\nEnter amount of minutes ('exit' for stop the program):");
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String scanString = bufferedReader.readLine();
            Matcher matcher = pattern.matcher(scanString);
            while (!scanString.equalsIgnoreCase("exit") && matcher.find()) {
                Light light = new Light(Integer.parseInt(scanString), sleepTime - 250);
                executorService.execute(light);
                sleep();
                mainLogger.warn("\n\nTry one more time!\nEnter amount of minutes ('exit' for stop the program):");
                scanString = bufferedReader.readLine();
                matcher = pattern.matcher(scanString);
            }
        } catch (IOException e) {
            mainLogger.error("It seems like there is some problems with entering data:\n", e);
        }
        mainLogger.warn("End of the programme executing.");
        executorService.shutdown();
        mainLogger.fatal("ExecutorService is shutted down.");
    }

    private static void sleep() {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            mainLogger.error("Thread.sleep() is broken");
        }
    }
}