package com.margad.repository;

import com.margad.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends MongoRepository<Users , String>  {
    Users findByToken(String token);

}
