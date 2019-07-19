package hw2;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample implements Callable<String> {

    private int luckyNumber;

    private CallableExample() {
        luckyNumber = (int) (Math.random() * 100);
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(500);
        return "Your lucky number is " + luckyNumber;
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> futuresResults = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            futuresResults.add(executorService.submit(new CallableExample()));
        }

        for (Future<String> fs : futuresResults) {
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }
}
