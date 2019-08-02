package com.epam.multi.homeWorks.hw3.task2;

public class AtomicTaskRunnable implements Runnable {
    int amount;

    public AtomicTaskRunnable(int amount) {
        this.amount = amount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            //System.out.println(AtomicTask.incrementAtomicInteger(amount));
            AtomicTask.incrementAtomicInteger(amount);
        }
    }
}
