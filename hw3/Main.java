package hw3;

import static hw3.ATM.atm;

public class Main {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                System.err.println("First");
                atm.addMoney(50);
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                System.err.println("Second");
                atm.getMoney(30);
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                System.err.println("Third");
                atm.seeMoney();
            }
        }).start();
    }

}