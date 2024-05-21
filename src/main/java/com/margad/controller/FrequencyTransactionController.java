package com.margad.controller;

import com.margad.model.FrequencyTransaction;
import com.margad.model.Transaction;
import com.margad.model.Users;
import com.margad.repository.UsersRepository;
import com.margad.scheme.ResponseScheme;
import com.margad.scheme.TransactionScheme;
import com.margad.service.Transaction.TransactionService;
import com.margad.service.Users.UsersService;
import com.margad.util.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/frequencytransaction")
public class   FrequencyTransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private UsersRepository usersRepository;

    @PostMapping("/")
    public ResponseScheme frequencyTransaction(@RequestBody TransactionScheme scheme) {
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

                List<Transaction> transferUserTransactions = transferUser.getTransactions();
                if (transferUserTransactions == null) {
                    transferUserTransactions = new ArrayList<>();
                }
                transferUserTransactions.add(transaction);
                transferUser.setTransactions(transferUserTransactions);

                List<Transaction> recipientUserTransactions = recipientUser.getTransactions();
                if (recipientUserTransactions == null) {
                    recipientUserTransactions = new ArrayList<>();
                }
                recipientUserTransactions.add(transaction);
                recipientUser.setTransactions(recipientUserTransactions);

                // Add frequency transaction to user's frequency list
                FrequencyTransaction frequencyTransaction = new FrequencyTransaction(scheme.getCurrency(),
                        transaction.getTranscationID(), true, scheme.getTransferAccount(), scheme.getTransferBank(),
                        scheme.getRecipientAccount(), scheme.getRecipientBank(), scheme.getTransactionAmount(),
                        new Date(), new Date(), scheme.getTransactionDescription());
                List<FrequencyTransaction> userFrequencies = transferUser.getFrequencies();
                if (userFrequencies == null) {
                    userFrequencies = new ArrayList<>();
                }
                userFrequencies.add(frequencyTransaction);
                transferUser.setFrequencies(userFrequencies);

                usersRepository.save(transferUser);
                usersRepository.save(recipientUser);

                return ResponseScheme.getInstance(true, "TransactionSuccessful");
            }
        } catch (Exception e) {
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
}
