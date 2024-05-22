package com.margad.controller;

import com.margad.model.Transaction;
import com.margad.model.Users;
import com.margad.repository.TransactionRepository;
import com.margad.scheme.AccountScheme;
import com.margad.scheme.ResponseScheme;
import com.margad.scheme.TransactionScheme;
import com.margad.service.Transaction.TransactionService;
import com.margad.service.Users.UsersService;
import com.margad.util.Account;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*" , allowedHeaders = "*")
@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private UsersService usersService;

    @PostMapping("/")
    public ResponseScheme transaction(@RequestBody TransactionScheme scheme){
        try {
            Users transferUser = usersService.findUserByAccountID(scheme.getTransferAccount());
            Users recipientUser = usersService.findUserByAccountID(scheme.getRecipientAccount());
            Account transferAccount = findAccountByAccountID(transferUser, scheme.getTransferAccount());
            Account recipientAccount = findAccountByAccountID(recipientUser, scheme.getRecipientAccount());

            if (transferAccount == null || recipientAccount == null) {
                return ResponseScheme.getInstance(false, "AccountNotFound");
            } else {
                if (transferAccount.getBalance() < scheme.getTransactionAmount()) {
                    return ResponseScheme.getInstance(false, "Insufficient");
                }
                transferAccount.setBalance(transferAccount.getBalance() - scheme.getTransactionAmount());
                recipientAccount.setBalance(recipientAccount.getBalance() + scheme.getTransactionAmount());
                usersService.saveUsers(transferUser);
                usersService.saveUsers(recipientUser);

                Transaction transaction = new Transaction();
                transaction.setTransferAccount(scheme.getTransferAccount());
                transaction.setRecipientAccount(scheme.getRecipientAccount());
                transaction.setTransactionAmount(scheme.getTransactionAmount());
                transaction.setTransactionDate(new Date());
                transaction.setTransactionDescription(scheme.getTransactionDescription());
                transaction.setTransferBank(scheme.getTransferBank());
                transaction.setRecipientBank(scheme.getRecipientBank());
                transaction.setCurrency(scheme.getCurrency());
                transaction.setIncome(scheme.getIncome());
                transactionService.saveTransaction(transaction);
                addTransactionToUser(transferUser, transaction);
                addTransactionToUser(recipientUser, transaction);

                usersService.saveUsers(transferUser);
                usersService.saveUsers(recipientUser);

                return ResponseScheme.getInstance(true, "TransactionSuccessful");
            }
        } catch(Exception e){
            return ResponseScheme.getInstance(false, e.getMessage());
        }
    }

    private Account findAccountByAccountID(Users user, String accountID) {
        if (user != null && user.getAccounts() != null) {
            for (Account account : user.getAccounts()) {
                if (accountID.equals(account.getAccountID())) {
                    return account;
                }
            }
        }
        return null;
    }

    private void addTransactionToUser(Users user, Transaction transaction) {
        if (user.getTransactions() == null) {
            user.setTransactions(new ArrayList<>());
        }
        user.getTransactions().add(transaction);
    }
}
