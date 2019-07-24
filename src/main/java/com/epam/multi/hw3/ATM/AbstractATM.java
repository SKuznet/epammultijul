package com.epam.multi.hw3.ATM;

import com.epam.multi.hw3.BankAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The class contains basic information for ATM - List of bank Accounts.
 * The class also contains default methods to find account in list and to get balance from account.
 */
public abstract class AbstractATM {
    List<BankAccount> bankAccounts = new ArrayList<>();

    /**
     * Method return account balance for chosen accountId.
     * Account id's are generated in BankAccount class.
     *
     * @param accountId chosen account id.
     * @return account balance.
     */
    public Integer getAccountBalance(int accountId) {
        return findAccount(accountId).getMoneyAmount();
    }

    /**
     * Method for class needs, find account in list of accounts
     * and if account is not found, throw IllegalArgumentException
     *
     * @param accountId chosen account id.
     * @return BankAccount class instance for chosen account id.
     */
    protected BankAccount findAccount(int accountId) {
        Optional<BankAccount> optionalBankAccount = bankAccounts.stream()
                .filter(e -> e.getAccountId() == accountId)
                .findFirst();
        return optionalBankAccount.orElseThrow(() -> new IllegalArgumentException("Wrong accountId"));
    }
}
