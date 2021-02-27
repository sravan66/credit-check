package com.jpmc.transactions.processor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.jpmc.transactions.processor.models.Account;
import com.jpmc.transactions.processor.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepository accountrepo;
	
	@Autowired
	MongoTemplate mongoTemplate;


	@Override
	public Account createaccounts(Account account) {
		// TODO Auto-generated method stub
		return accountrepo.save(account);
	}

	@Override
	public Account updateaccounts(Account account) {
		return accountrepo.save(account);	
	}

	@Override
	public List<Account> getaccounts() {
		// TODO Auto-generated method stub
		return accountrepo.findAll();
	}

	@Override
	public Account getaccountByAccNum(String accountId) {
		// TODO Auto-generated method stub
		return accountrepo.findById(accountId).get();
	}

}
