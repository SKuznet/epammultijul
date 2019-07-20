package com.epam.multi.homework.hw2;

import java.util.concurrent.Callable;

public class CallableExample implements Callable<Double> {

    private Double startingPoint;

    public Double getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(Double startingPoint) {
        this.startingPoint = startingPoint;
    }

    public CallableExample(Double startingPoint) {
        this.startingPoint = startingPoint;
    }

    @Override
    public Double call() {
        Double result = startingPoint;
        for (int i = 1; i < 10; i++) {
            System.out.println("Thread " + Thread.currentThread().getName() + ": " + result);
            result *= i;
        }
        return result;
    }
}