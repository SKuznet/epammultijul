package hw3;

import hw3.atm.ATM;
import hw3.atm.Account;
import hw3.exception.NotEnoughAmountInAtm;
import hw3.exception.NotEnoughMoneyOnYourBalanceException;
import hw3.exception.UnforseenCircumstances;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        final ATM atm = new ATM();

        Executor executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 7; i++) {
            final Account account = new Account(10000, "#" + i);
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        int money = atm.getMoney(5000, account.getBalance());
                        System.out.println("I'm " + account.getAccountNumber() + " get money: " + money);
                    } catch (NotEnoughMoneyOnYourBalanceException | NotEnoughAmountInAtm | UnforseenCircumstances e) {
                        System.err.println(account.getAccountNumber() + " " + e.getMessage());
                    }
                }
            });
        }

    }

}
