package com.margad.service.Bank;

import com.margad.model.Bank;

import java.util.List;

public interface BankService {
    public Bank saveBank(Bank bank);
    public List<Bank> getAllBank();
}
