package com.margad.service.Bank;

import com.margad.model.Bank;
import com.margad.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankServiceImpl implements BankService{
    @Autowired
    private BankRepository bankRepository;

    @Override
    public Bank saveBank(Bank bank){
        return bankRepository.save(bank);
    }


    @Override
    public List<Bank> getAllBank(){
        return bankRepository.findAll();
    }
    @Override
    public Bank findByBankID(String bankID){
        return bankRepository.findByBankID(bankID);
    }

}
