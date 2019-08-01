package com.epam.multi.lesson4.hw3;

import com.epam.multi.lesson4.hw3.entities.ATM;
import com.epam.multi.lesson4.hw3.entities.User;

import java.util.ArrayList;
import java.util.List;

public class ATMApp {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("John", 50000));
        users.add(new User("Al Pachino", 100000));
        users.add(new User("Becky", 20000));

        ATM atm = new ATM(45000);

        Thread thread1 = new Thread(new GetMoneyEmulation(users.get(0), atm, 20000));
        Thread thread2 = new Thread(new GetMoneyEmulation(users.get(1), atm, 30000));
        Thread thread3 = new Thread(new GetMoneyEmulation(users.get(2), atm, 4000));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
