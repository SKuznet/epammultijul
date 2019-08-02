package hw6;

import java.util.concurrent.Exchanger;

public class Helper implements Runnable {
    private Exchanger<String> exchanger;
    private String string;

    public Helper(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            string = exchanger.exchange("");
            System.out.println("Helper got: " + string);
            exchanger.exchange("Here my help");
        } catch (InterruptedException e) {
            System.err.println("EXCEPTION!!!!");
        }
    }
}
