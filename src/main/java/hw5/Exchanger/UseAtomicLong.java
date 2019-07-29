package hw5.Exchanger;

import java.util.concurrent.Exchanger;

public class UseAtomicLong implements Runnable {
    private Exchanger<String> exchanger;
    private String string;

    public UseAtomicLong(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                string = exchanger.exchange("");
                System.out.println("Got: " + string);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
