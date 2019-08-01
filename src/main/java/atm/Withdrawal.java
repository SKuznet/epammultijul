package atm;

import java.util.concurrent.TimeUnit;

public class Withdrawal implements Runnable {

    private int amount;

    public Withdrawal() {

    }

    public Withdrawal(int amount) {
        this.amount = amount;

    }

    @Override
    public void run() {
        synchronized (Atm.INSTANCE){
            Atm.INSTANCE.setBalance(withdraw(Atm.INSTANCE.getBalance()));
        }

    }

    public int withdraw(int balance) {

            System.out.println("Withdrawal " + Thread.currentThread().getName() + " in progress...");
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                if (balance >= amount) {
                    balance -= amount;
                    System.out.println("Withdrawal " + Thread.currentThread().getName() + " complete");
                    System.out.println("New balance is: " + balance);
                    return balance;
                } else {
                    System.out.println("Balance is less than amount");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                return balance;
            }
            return balance;
    }
}
