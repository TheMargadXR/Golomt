package com.margad.service.Transaction;

import com.margad.model.Transaction;

import java.util.List;

public interface TransactionService {
    public Transaction saveTransaction(Transaction transaction);
    public List<Transaction> getAllTransaction();
}
