package com.epam.multi.homework5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Class creates 2 threads: seller and buyer, exchanging prices
 */
public class ExchangerExample {

    /**
     * Runs 2 threads with common exchange object
     */
    public static void main(String[] args) {
        Exchanger<Integer> exchanger = new Exchanger<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new Buyer(exchanger, 200));
        executorService.submit(new Seller(exchanger, 500));

        executorService.shutdown();
    }
}

/**
 * Class Buyer sending low price to another class Seller with Exchanger
 */
class Buyer implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(Buyer.class);
    private final Exchanger exchanger;
    private Object object;

    Buyer(Exchanger exchanger, Object object) {
        this.exchanger = exchanger;
        this.object = object;
    }

    /**
     * Sending his price to Seller`s thread
     */
    @Override
    public void run() {
        try {
            Object previous = this.object;
            this.object = this.exchanger.exchange(this.object);
            System.err.println(Thread.currentThread().getName() + " exchanged " + previous + " for " + this.object);
        } catch (InterruptedException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}

/**
 * Class Seller sending high price to another class Buyer with Exchanger
 */
class Seller implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(Seller.class);
    private final Exchanger exchanger;
    private Object object;

    Seller(Exchanger exchanger, Object object) {
        this.exchanger = exchanger;
        this.object = object;
    }

    /**
     * Sending his price to Buyer`s thread
     */
    @Override
    public void run() {
        try {
            Object previous = this.object;
            this.object = this.exchanger.exchange(this.object);
            System.err.println(Thread.currentThread().getName() + " exchanged " + previous + " for " + this.object);
        } catch (InterruptedException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}