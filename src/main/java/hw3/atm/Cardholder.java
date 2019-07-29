package main.java.hm3.atm;

public class Cardholder extends Thread{

    public Cardholder(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ATM.getMoney(200);
    }
}
