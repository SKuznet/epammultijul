package hw3.atm;

import hw3.exception.NotEnoughAmountInAtm;
import hw3.exception.NotEnoughMoneyOnYourBalanceException;
import hw3.exception.UnforseenCircumstances;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ATM {

    private AtomicInteger amount = new AtomicInteger(34000);

    public int getMoney(int money, int balance) throws NotEnoughMoneyOnYourBalanceException, NotEnoughAmountInAtm, UnforseenCircumstances {

        if (money <= this.amount.get() && money < balance) {
                amount.getAndSet(amount.get() - money);
                return money;
        }
        if (money > balance) {
            throw new NotEnoughMoneyOnYourBalanceException("You do not have enough funds in the account");
        }
        if (money > this.amount.get()) {
            throw new NotEnoughAmountInAtm("There are not enough funds at the ATM to complete your transaction");
        }
        return 0;
    }

    public int putMoney(int money, int balance) {

        try {
            TimeUnit.MILLISECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // get account and increment balance
        amount.getAndSet(money);

        return balance;
    }
}
