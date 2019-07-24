package com.epam.multi.lesson3.homework2;


import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ThreadWithSomeResult implements Callable<String> {
    private String someString;
    public ThreadWithSomeResult(String inputString) {
        this.someString = inputString;
    }


    public String call() throws Exception {
        TimeUnit.MILLISECONDS.sleep(100);
        return someString.toUpperCase();
    }
}
