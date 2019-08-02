package main.java.hw5;

public class Deliver implements Runnable {
    private Market market;

    public Deliver(Market market){
        this.market = market;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.put();
        }
    }
}
