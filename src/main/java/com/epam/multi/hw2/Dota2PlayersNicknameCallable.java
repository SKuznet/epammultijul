package com.epam.multi.hw2;

import java.util.ArrayList;
import java.util.concurrent.*;

public class Dota2PlayersNicknameCallable implements Callable<String> {
    private int id;

    public Dota2PlayersNicknameCallable(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "Callable Dota2Player id " + id;
    }
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            results.add(executorService.submit(new Dota2PlayersNicknameCallable(i)));
        }

        for (Future<String> futureString : results) {
            try{
                System.out.println(futureString.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } finally {
                executorService.shutdown();
            }
        }
    }
}
