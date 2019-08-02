package com.epam.multi.lesson6;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerExample {
    public static void main(String[] args) {
        ExecutorService e = Executors.newCachedThreadPool();
        Exchanger<String> exchanger = new Exchanger<>();
        e.execute(new UseString(exchanger));
        e.execute(new MakeString(exchanger));
        e.shutdownNow();
    }
}
class MakeString implements Runnable {
    private Exchanger<String> exchanger;
    private String string;
    public MakeString(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        string = "";
//        new Thread(this).start();
    }
    @Override
    public void run() {
        char ch = 'A';

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                string += (char) ch++;
            }
            try {
                string = exchanger.exchange(string);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
class UseString implements Runnable {
    private Exchanger<String> exchanger;
    private String string;
    public UseString(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
//        new Thread(this).start();
    }
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                string = exchanger.exchange(new String());
                System.out.println("Got: " + string);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
