package com.margad.service.Transaction;

import com.margad.model.Transaction;
import com.margad.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Transaction saveTransaction(Transaction transaction){
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getAllTransaction(){
        return transactionRepository.findAll();
    }

}
