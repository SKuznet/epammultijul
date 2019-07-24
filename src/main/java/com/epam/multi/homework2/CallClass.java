package com.epam.multi.homework2;

import java.util.concurrent.Callable;

public class CallClass implements Callable<String> {
    private int id;

    public CallClass (int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return null;
    }
}
