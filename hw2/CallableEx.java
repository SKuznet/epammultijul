package hw2;

import java.util.concurrent.Callable;

public class CallableEx implements Callable<String> {
    private int id;

    public CallableEx(int id) {
        this.id = id;
    }

    public String call() throws Exception {
        return "I'm callable " + id;
    }
}
