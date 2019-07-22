package main.java.hm2;

public class RunnableClass implements Runnable {
    private static int priority = 1;
    @Override
    public void run() {
        Thread.currentThread().setPriority(priority++);
        printAnything();
    }

    private void printAnything() {
        for (int i = 0; i < 10; i++) {
        System.out.println("I'm tread - " + Thread.currentThread().getName() + ", my priority is: " + Thread.currentThread().getPriority());
        }
    }
}
