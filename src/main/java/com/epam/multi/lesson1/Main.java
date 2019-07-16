package main.java.com.epam.multi.lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    List<Integer> minutes = new ArrayList<>();
    static int count = 3;

    public static void main(String[] args) {

        Main main = new Main();
        main.ConsoleReader();
        TrafficLight trafficLight = new TrafficLight(2, 3, 4);
        ExecutorService service = Executors.newFixedThreadPool(count);
        for (int i = 0; i < count; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {

                }
            });
        }


        /*Thread thread = new Thread(new Runnable() {
            public void run() {
                System.out.println("Hello From another thread " + Thread.currentThread().getName());
            }
        });
        thread.start();

        System.out.println("Hello from main thread " + Thread.currentThread().getName());

        MirrirBarsik barsik1 = new MirrirBarsik();
        GlassBarsik barsik2 = new GlassBarsik();

        barsik1.start();

        Thread thread1 = new Thread(barsik2);
        thread1.start();

        Executor service = Executors.newCachedThreadPool();
        service.execute(new Runnable() {
            public void run() {
                System.out.println("Hello from another Thread with executor Service!" + Thread.currentThread().getName());
            }
        });
    }*/
    }

    public void ConsoleReader() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String s = bufferedReader.readLine();
                if (s == null) {
                    break;
                } else {
                    minutes.add(Integer.parseInt(s));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
