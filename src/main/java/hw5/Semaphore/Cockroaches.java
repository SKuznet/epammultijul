package hw5.Semaphore;

import java.util.concurrent.atomic.AtomicInteger;

public class Cockroaches {
    AtomicInteger amount;

    public Cockroaches(AtomicInteger amount) {
        this.amount = amount;
    }

    public void setAmount(AtomicInteger amount) {
        this.amount = amount;
    }

    public AtomicInteger getAmount() {
        return amount;
    }
}
