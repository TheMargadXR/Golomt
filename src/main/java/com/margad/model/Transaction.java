package com.margad.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "transactions")
public class Transaction {
    @Id
    private String transcationID;
    private String transferAccount;
    private String transferBank;
    private String recipientAccount;
    private String recipientBank;
    private double transactionAmount;
    private String currency;
    private String transactionDescription;
    private Date transactionDate;
    private Boolean income;

    public Transaction() {
        this("", 0.0, "", "", "", "", "", "", "", false);
    }


    public Transaction(String currency, double transactionAmount, String recipientBank, String recipientAccount, String transferBank, String transferAccount, String transcationID , String transactionDescription, Object o, boolean b ) {
        this.currency = currency;
        this.transactionAmount = transactionAmount;
        this.recipientBank = recipientBank;
        this.recipientAccount = recipientAccount;
        this.transferBank = transferBank;
        this.transferAccount = transferAccount;
        this.transcationID = transcationID;
        this.transactionDescription = transactionDescription;
        this.transactionDate = transactionDate;
        this.income = income;
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

    public String getTransferBank() {
        return transferBank;
    }

    public void setTransferBank(String transderBank) {
        this.transferBank = transderBank;
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

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Boolean getIncome() {
        return income;
    }

    public void setIncome(Boolean income) {
        this.income = income;
    }

}
