package com.epam.multi.lesson4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomickCheck implements Runnable {
    private int i = 0;

    public int getValue() {
        return i;
    }

    private synchronized void evenIncrement() {
        i++;
        i++;
    }

    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomickCheck atomickCheck = new AtomickCheck();
        executorService.execute(atomickCheck);

        while (true) {
            int val = atomickCheck.getValue();

            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
