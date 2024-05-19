package com.margad.service.FrenquencyTransaction;

import com.margad.model.FrequencyTransaction;

import java.util.List;

public interface FrequencyTransactionService {
    FrequencyTransaction saveFrequencyTransaction(FrequencyTransaction frequencyTransaction);
    List<FrequencyTransaction> getAllFrequencyTransaction();
}
