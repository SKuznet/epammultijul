package com.epam.multi.lesson3;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        TimeUnit.MILLISECONDS.sleep(10);
        return "result TaskWithResult " + id;
    }
}
