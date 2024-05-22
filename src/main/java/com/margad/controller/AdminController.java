package com.margad.controller;


import com.margad.model.Transaction;
import com.margad.repository.BankRepository;
import com.margad.service.Bank.BankService;
import com.margad.service.Transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin(origins = "*" , allowedHeaders = "*")
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private BankService bankService;

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/transaction")
    public List<Transaction> getTransactions(){
        try{
            return transactionService.getAllTransaction();
        }catch(Exception e){
            return null;
        }
    }


}
