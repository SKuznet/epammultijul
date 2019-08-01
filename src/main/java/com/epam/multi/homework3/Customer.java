package com.epam.multi.homework3;

import java.math.BigDecimal;

/**
 * Class shows logic of user taking money
 */
public class Customer implements Runnable {
    private int id;
    private BigDecimal debet;
    private ATM atm = ATM.getInstance();

    /**
     * Sets new user if and amount of money he wants to take
     *
     * @param id         User id
     * @param moneyToGet Amount of money he wants
     */
    Customer(int id, String moneyToGet) {
        this.id = id;
        this.debet = new BigDecimal(moneyToGet);
    }

    /**
     * Trying to take money from ATM
     */
    @Override
    public void run() {
        System.err.println("Customer " + id + " trying to get money!");
        atm.getMoney(debet, id);
    }
}
