package com.epam.multi.hw3;

public class BankAccount {
    private Integer accountId;
    Integer moneyAmount;
/**
     * Class that wraps bank account information.
     * Constructor that creates new BankAccounts with chosen moneyAmount on account
     * and new account Id.
     * @param moneyAmount chosen amount of money.
     */
    public BankAccount(Integer moneyAmount, int accountId) {
        this.accountId = accountId;
        this.moneyAmount = moneyAmount > 0 ? moneyAmount : 0;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public Integer getMoneyAmount() {
        return moneyAmount;
    }

    /**
     * Withdraw money from account.
     * @param moneyAmount chosen money amount
     * @return            true, if operation was a success, otherwise false
     */
    public boolean withdraw(int moneyAmount) {
        if (this.moneyAmount < moneyAmount) {
            return false;
        } else {
            this.moneyAmount -= moneyAmount;
            return true;
        }
    }

    public void deposit(int moneyAmount) {
        this.moneyAmount += moneyAmount;
    }
}
