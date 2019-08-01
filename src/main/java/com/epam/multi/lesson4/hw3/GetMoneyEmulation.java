package com.epam.multi.lesson4.hw3;

import com.epam.multi.lesson4.hw3.entities.ATM;
import com.epam.multi.lesson4.hw3.entities.User;

public class GetMoneyEmulation implements Runnable {

    private User user;
    private ATM atm;
    private int amount;


    public GetMoneyEmulation(User user, ATM atm, int amount) {
        this.user = user;
        this.atm = atm;
        this.amount = amount;
    }

    @Override
    public void run() {
        System.err.println(user.getName());
        atm.withdrawCash(amount, user);
    }
}
