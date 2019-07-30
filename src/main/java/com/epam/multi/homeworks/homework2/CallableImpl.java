package com.epam.multi.homeworks.homework2;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CallableImpl implements Callable<String> {
    private double id;

    public CallableImpl(int id) {
        this.id = Math.log10(id);
    }

    @Override
    public String call() throws Exception {
        TimeUnit.MILLISECONDS.sleep(50);
        return "result log= " + id;
    }
}
