package com.margad.controller;


import com.margad.model.Bank;
import com.margad.repository.BankRepository;
import com.margad.scheme.BankScheme;
import com.margad.scheme.ResponseScheme;
import com.margad.service.Bank.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*" , allowedHeaders = "*")
@RestController
@RequestMapping("/bank")
public class BankController {
    @Autowired
    private BankService bankService;


    @PostMapping("/")
    public ResponseScheme addBankAccount(@RequestBody BankScheme scheme){
        try{

            String bankID = scheme.getBankID();
            Bank bankCheck = bankService.findByBankID(bankID);

            if(bankCheck!=null){
                return ResponseScheme.getInstance(false,"BankIDisAllreadyUsed");
            }else{
                Bank bank = new Bank();
                bank.setBankID(scheme.getBankID());
                bank.setBankName(scheme.getBankName());
                bankService.saveBank(bank);
                return ResponseScheme.getInstance(true,"SuccessAccountCreated");
            }

        }catch(Exception e){
            return ResponseScheme.getInstance(false, e.getMessage());
        }
    }


    @GetMapping("/all")
    public List<Bank> getAllBanks() {
        try {
            List<Bank> banks = bankService.getAllBank();
            return banks;
        } catch (Exception e) {
            return null;
        }
    }
}
