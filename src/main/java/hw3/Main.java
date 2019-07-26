package hw3;

import static hw3.ATM.atm;

public class Main {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.err.println("first");
                atm.addMoney(50);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.err.println("second");
                atm.getMoney(30);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.err.println("third");
                atm.seeMoney();
            }
        }).start();
    }

}
