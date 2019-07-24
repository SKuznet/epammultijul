package com.epam.multi.hw3.ATM;

import com.epam.multi.hw3.BankAccount;

import java.util.List;

/**
 * ATM class that implements both Deposit and Dispenser interfaces.
 */
public class UniversalATM extends AbstractATM implements Dispenser, Deposit {
    public UniversalATM(List<BankAccount> bankAccounts) {
        this.bankAccounts.addAll(bankAccounts);
    }

    @Override
    public boolean withdraw(int accountId, int moneyAmount) throws IllegalArgumentException {
        BankAccount bankAccount = findAccount(accountId);
        synchronized (bankAccount) {
            return bankAccount.withdraw(moneyAmount);
        }
    }

    @Override
    public void deposit(int accountId, int moneyAmount) {
        BankAccount bankAccount = findAccount(accountId);
        synchronized (bankAccount) {
            bankAccount.deposit(moneyAmount);
        }
    }
}