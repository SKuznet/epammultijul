package main.java.hw1.util;

public class ThreadStarter {
    public static void startThreads(Thread ... threads){
        for (Thread t : threads) {
            t.start();
        }
    }
}
