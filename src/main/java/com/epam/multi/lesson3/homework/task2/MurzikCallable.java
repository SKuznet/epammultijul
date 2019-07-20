package com.epam.multi.lesson3.homework.task2;

import java.util.concurrent.Callable;

public class MurzikCallable implements Callable<String> {
    private int id;

    public MurzikCallable(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "Callable Murzik id " + id;
    }
}
