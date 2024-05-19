package com.margad.util;

import com.margad.model.Bank;
import org.springframework.data.annotation.PersistenceConstructor;

public class Account extends Bank {
    private String accountID;
    private String currency;
    private double balance;

    // Default constructor
    public Account() {
        super();
    }

    @PersistenceConstructor
    public Account(String accountID, String currency, double balance, String bankID, String bankName) {
        super();
        this.accountID = accountID;
        this.currency = currency;
        this.balance = balance;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
