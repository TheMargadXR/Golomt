package com.margad.model;

import com.margad.util.Frequency;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transactions")
public class Transaction {
    @Id
    private String ID;
    private String transferAccount;
    private String transderBank;
    private String recipientAccount;
    private String recipientBank;
    private double transactionAmount;
    private String currency;
    private Frequency frequency;

    public Transaction(Frequency frequency, String currency, double transactionAmount, String recipientBank, String recipientAccount, String transderBank, String transferAccount, String ID) {
        this.frequency = frequency;
        this.currency = currency;
        this.transactionAmount = transactionAmount;
        this.recipientBank = recipientBank;
        this.recipientAccount = recipientAccount;
        this.transderBank = transderBank;
        this.transferAccount = transferAccount;
        this.ID = ID;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTransferAccount() {
        return transferAccount;
    }

    public void setTransferAccount(String transferAccount) {
        this.transferAccount = transferAccount;
    }

    public String getTransderBank() {
        return transderBank;
    }

    public void setTransderBank(String transderBank) {
        this.transderBank = transderBank;
    }

    public String getRecipientAccount() {
        return recipientAccount;
    }

    public void setRecipientAccount(String recipientAccount) {
        this.recipientAccount = recipientAccount;
    }

    public String getRecipientBank() {
        return recipientBank;
    }

    public void setRecipientBank(String recipientBank) {
        this.recipientBank = recipientBank;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }
}
