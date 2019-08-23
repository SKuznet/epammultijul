package hw3;

import hw3.entities.ATM;
import hw3.entities.Consumer;

public class GetMoney implements Runnable {

    private Consumer consumer;
    private ATM atm;
    private int amount;


    public GetMoney(Consumer consumer, ATM atm, int amount) {
        this.consumer = consumer;
        this.atm = atm;
        this.amount = amount;
    }

    @Override
    public void run() {
        System.err.println(consumer.getName());
        atm.withdrawMoney(consumer, amount);
    }
}