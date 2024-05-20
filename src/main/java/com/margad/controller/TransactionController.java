package com.margad.controller;

import com.margad.model.Transaction;
import com.margad.model.Users;
import com.margad.repository.TransactionRepository;
import com.margad.scheme.ResponseScheme;
import com.margad.scheme.TransactionScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;


@CrossOrigin(origins = "*" , allowedHeaders = "*")
@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionRepository transactionRepository;


    @PostMapping("/")
    public ResponseScheme transaction(@RequestBody TransactionScheme scheme){
        try{
            Date dNow = new Date();
            SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
            String dateTime = ft.format(dNow);
            Transaction transaction = new Transaction();
            System.out.println("Transfer Account : " + scheme.getTransferAccount());
            System.out.println("Transfer Bank : " + scheme.getTransferBank());
            System.out.println("Recipient Account : " + scheme.getRecipientAccount());
            System.out.println("Recipient Bank : " + scheme.getRecipientBank());
            System.out.println("Transaction Amount : " + scheme.getTransactionAmount());
            System.out.println("Currency : " + scheme.getCurrency());
            System.out.println("Transaction description : " + scheme.getTransactionDescription());
            System.out.println("Income : " + scheme.getIncome());
            System.out.println("User Token : " + scheme.getToken());
            return ResponseScheme.getInstance(true);
        }catch(Exception e){
            return ResponseScheme.getInstance(false , e.getMessage());
        }
    }

    @GetMapping("/add")
    public String addUser() {
        try {
            return "Амжилттай";
        } catch (Exception e) {
            return "Алдаа : " + e.getMessage();
        }
    }
}
