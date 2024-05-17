package com.margad.util;

public class Account {
    private String accountID;
    private String currency;
    private double balance;

    public Account(String accountID, String currency, double balance) {
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
