package hw1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int green = setValueFor("green", reader);
            int yellow = setValueFor("yellow", reader);
            int red = setValueFor("red", reader);

            TrafficLights trafficLights = new TrafficLights(green, yellow, red);
            Thread work = new Thread(trafficLights);

            work.start();
            while (!reader.readLine().equals("stop")) {
                System.out.println(trafficLights.getLight());
            }
            trafficLights.shutdown();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sayGoodbye();
        }
    }

    private static int setValueFor(String name, BufferedReader reader) throws IOException{
        int result;
        System.out.print("Input the time for " + name +  " light: ");
        while (true) {
            try {
                result = Integer.valueOf(reader.readLine());
                if (result <= 0) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.print("Wrong input, try again: ");
            }
        }
        return result;
    }

    private static void sayGoodbye() {
        System.out.println("Have a nice day");
    }
}
