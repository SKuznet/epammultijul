package main.java.hm2.callable;

import java.util.concurrent.Callable;

public class CallableClass implements Callable<String> {

    @Override
    public String call() throws Exception {
        String s = "Hello from callable " + Thread.currentThread().getName();
        return s;
    }
}
