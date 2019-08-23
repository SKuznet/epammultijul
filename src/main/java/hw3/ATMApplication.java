package hw3;

import hw3.entities.ATM;
import hw3.entities.Consumer;

import java.util.ArrayList;
import java.util.List;

public class ATMApplication {

    public static ATM atm = new ATM(20500);

    public static void main(String[] args) {
        List<Consumer> consumers = new ArrayList<>();
        consumers.add(new Consumer("Edward", 5000));
        consumers.add(new Consumer("Ron", 6700));
        consumers.add(new Consumer("Howard", 18000));

        Thread thread1 = new Thread(new GetMoney(consumers.get(0), atm, consumers.get(0).getAmountToGetFromATM()));
        Thread thread2 = new Thread(new GetMoney(consumers.get(1), atm, consumers.get(1).getAmountToGetFromATM()));
        Thread thread3 = new Thread(new GetMoney(consumers.get(2), atm, consumers.get(2).getAmountToGetFromATM()));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
