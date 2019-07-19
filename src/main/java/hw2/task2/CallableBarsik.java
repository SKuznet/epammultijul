package hw2.task2;

import java.util.concurrent.Callable;

public class CallableBarsik implements Callable {
    private int id;

    public CallableBarsik(int id) {
        this.id = id;
    }

    @Override
    public Object call() throws Exception {
        return "Callable Barsik id " + id;
    }
}
