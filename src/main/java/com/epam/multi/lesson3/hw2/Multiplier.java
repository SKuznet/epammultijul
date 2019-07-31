package com.epam.multi.lesson3.hw2;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Multiplier implements Callable<String> {
    private int number;

    public Multiplier(int number) {
        this.number = number;
    }

    public int myltiplyByTen(int number) {
        return number * 10;
    }

    @Override
    public String call() throws Exception {
        TimeUnit.MILLISECONDS.sleep(10);
        return number + " * 10 = " + myltiplyByTen(number);
    }

}
