package com.epam.multi.homework3;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Singleton class ATM has logic of ATM with getMoney class protected from multithreading operations
 */
public class ATM {

    private static ATM instance;
    private static final Object mutex = new Object();
    private BigDecimal balance = new BigDecimal("1000000");

    private ATM() {
    }

    /**
     * Creates one and only instance of ATM class (if its not exist)
     */
    static ATM getInstance() {
        ATM result = instance;
        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null) {
                    instance = result = new ATM();
                }

            }
        }
        return result;
    }

    /**
     * Taking money from account if it is possible
     *
     * @param debit Amount of money to take
     * @param id    Id of customer
     */
    void getMoney(BigDecimal debit, int id) {
        synchronized (mutex) {
            if (balance.compareTo(debit) >= 0) {
                balance = balance.subtract(debit);
                System.err.println("Customer " + id + " received " + debit.toString());
                System.err.println("New balance: " + balance.toString());
            } else {
                System.err.println("Low balance! Customer " + id);
            }
        }
    }

    /**
     * Initializes three customers trying to took money in the same time
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(new Customer(1, "10000"));
        executorService.submit(new Customer(2, "70000"));
        executorService.submit(new Customer(3, "950000"));

        executorService.shutdown();
    }
}
