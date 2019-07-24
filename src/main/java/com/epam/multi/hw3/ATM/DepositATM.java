package com.epam.multi.hw3.ATM;

import com.epam.multi.hw3.BankAccount;

import java.util.List;

/**
 * ATM class that implements Deposit interface.
 */
public class DepositATM extends AbstractATM implements Deposit {
    public DepositATM(List<BankAccount> bankAccounts) {
        super.bankAccounts.addAll(bankAccounts);
    }

    @Override
    public void deposit(int accountId, int moneyAmount) {
        BankAccount bankAccount = findAccount(accountId);
        synchronized (bankAccount) {
            bankAccount.deposit(moneyAmount);
        }
    }
}
