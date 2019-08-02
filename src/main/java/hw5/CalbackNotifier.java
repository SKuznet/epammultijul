package hw5;

import java.util.concurrent.Callable;

public class CalbackNotifier implements Runnable {

    private final Callable<Boolean> callable;
    private final Callback callback;

    public CalbackNotifier(Callable<Boolean> callable, Callback callback) {
        this.callable = callable;
        this.callback = callback;
    }

    @Override
    public void run() {
        try {
            if (callable.call())
                callback.complete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
