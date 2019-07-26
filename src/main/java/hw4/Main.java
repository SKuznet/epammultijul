package hw4;

import static hw4.ATM.atm;

public class Main {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.err.println("first");
                atm.addMoney(100);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.err.println("Additional first");
                atm.getMoney(100);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.err.println("second");
                atm.getMoney(70);
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
