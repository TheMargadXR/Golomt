package com.margad.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrequencyTransactionRepository extends MongoRepository<TransactionRepository , String> {
}
