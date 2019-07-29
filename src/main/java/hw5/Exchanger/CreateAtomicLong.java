package hw5.Exchanger;

import java.util.Random;
import java.util.concurrent.Exchanger;
import java.util.concurrent.atomic.AtomicLong;

public class CreateAtomicLong implements Runnable {
    private Exchanger<String> exchanger;
    private AtomicLong atomicLong;
    private String string;

    public CreateAtomicLong(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        atomicLong = new AtomicLong(15L);
        new Thread(this).start();
    }

    @Override
    public void run() {
        Random random = new Random(20);
        AtomicLong atomicLong = this.atomicLong;
        string = "";

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                atomicLong.getAndAdd(random.nextLong());
                string += atomicLong.toString() + " ";
            }
            try {
                string = exchanger.exchange(string);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
