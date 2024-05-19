package com.margad.repository;

import com.margad.model.FrequencyTransaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrequencyTransactionRepository extends MongoRepository<FrequencyTransaction, String> {
}
