package com.epam.multi.lesson3.hw2;

import java.util.concurrent.Callable;

public class TestCollable implements Callable<String> {
    public String call() throws Exception {
        return "Result of thread " + Thread.currentThread().getName();
    }
}
