package com.epam.multi.homework.hw2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExampleMain {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        List<CallableExample> callings = Arrays.asList(new CallableExample(3.6),
                new CallableExample(5.2), new CallableExample(2.9));

        List<Future<Double>> futures = null;

        try {
            futures = executorService.invokeAll(callings);
            System.out.println("Result from Tread1: " + futures.get(0).get());
            System.out.println("Result from Tread2: " + futures.get(1).get());
            System.out.println("Result from Tread3: " + futures.get(2).get());
        } catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}