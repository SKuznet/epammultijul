package com.epam.multi.homework2;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Class implements Callable logic
 */
public class CallClass implements Callable<String> {
    private int id;

    CallClass(int id) {
        this.id = id;
    }

    /**
     * Make thread sleep before returning id
     * @return id of thread
     * */
    @Override
    public String call() throws Exception {
        TimeUnit.MILLISECONDS.sleep(1000);
        return "Return from call: " + id;
    }
}
