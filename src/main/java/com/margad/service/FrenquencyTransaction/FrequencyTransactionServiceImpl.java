package com.margad.service.FrenquencyTransaction;

import com.margad.model.FrequencyTransaction;
import com.margad.repository.FrequencyTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FrequencyTransactionServiceImpl implements FrequencyTransactionService {
    @Autowired
    private FrequencyTransactionRepository frequencyTransactionRepository;

    @Override
    public FrequencyTransaction saveFrequencyTransaction(FrequencyTransaction frequencyTransaction) {
        return frequencyTransactionRepository.save(frequencyTransaction);
    }

    @Override
    public List<FrequencyTransaction> getAllFrequencyTransaction() {
        return frequencyTransactionRepository.findAll();
    }
}
