package hw2;

import java.util.concurrent.Callable;

public class CallableCat implements Callable<String> {

    private int id;

    public CallableCat(int id) {
        this.id = id;
    }

    public String call() throws Exception {
        return "i'm callable " + id;
    }

}
