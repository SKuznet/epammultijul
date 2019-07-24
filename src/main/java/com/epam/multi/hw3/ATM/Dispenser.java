package com.epam.multi.hw3.ATM;

/**
 * Interface for ATMs, which can perform withdraw operation.
 */
public interface Dispenser {
    /**
     * Withdraw money from account.
     *
     * @param accountId   chosen BankAccount id.
     * @param moneyAmount chosen money amount.
     * @return            true, if operation was a success, otherwise false.
     */
    boolean withdraw(int accountId, int moneyAmount);
}