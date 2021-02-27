package com.jpmc.transactions.processor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jpmc.transactions.processor.models.Account;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

}
