package main.java.hw5;

public class Customer implements Runnable{
    private Market market;

    public Customer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.get();
        }
    }
}
