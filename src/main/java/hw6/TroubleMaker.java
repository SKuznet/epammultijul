package hw6;

import java.util.concurrent.Exchanger;

public class TroubleMaker implements Runnable {
    private Exchanger<String> exchanger;
    private String string;

    public TroubleMaker(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            exchanger.exchange("I need help!");
            string = exchanger.exchange("");
            System.out.println("Troublemaker got: " + string);
        } catch (InterruptedException e) {
            System.err.println("EXCEPTION!!!!");
        }

    }
}
