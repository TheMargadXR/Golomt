package com.margad.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transactions")
public class Transaction {
    @Id
    private String transcationID;
    private String transferAccount;
    private String transderBank;
    private String recipientAccount;
    private String recipientBank;
    private double transactionAmount;
    private String currency;
    private String transactionDescription;

    public Transaction( String currency, double transactionAmount, String recipientBank, String recipientAccount, String transderBank, String transferAccount, String transcationID , String transactionDescription) {
        this.currency = currency;
        this.transactionAmount = transactionAmount;
        this.recipientBank = recipientBank;
        this.recipientAccount = recipientAccount;
        this.transderBank = transderBank;
        this.transferAccount = transferAccount;
        this.transcationID = transcationID;
        this.transactionDescription = transactionDescription;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getID() {
        return transcationID;
    }

    public void setID(String transcationID) {
        this.transcationID = transcationID;
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

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    public String getTranscationID() {
        return transcationID;
    }

    public void setTranscationID(String transcationID) {
        this.transcationID = transcationID;
    }
}
