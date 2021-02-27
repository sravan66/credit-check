package com.jpmc.transactions.processor.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpmc.transactions.processor.models.Account;
import com.jpmc.transactions.processor.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountServiceImpl;

	private static Logger logger = LoggerFactory.getLogger(AccountController.class);

	@PostMapping("/accounts")
	public Account saveaccounts(@RequestBody Account account) {

		logger.info("Saving accounts for Account -- " + account.getAccountId());
		return accountServiceImpl.createaccounts(account);
	}

	@PutMapping("/accounts")
	public Account updateaccounts(@RequestBody Account account) {

		logger.info("Updating accounts for Account -- " + account.getAccountId());
		return accountServiceImpl.updateaccounts(account);
	}

	@GetMapping("/accounts")
	public List<Account> getaccounts() {

		logger.info("Getting Account accounts Data..");
		return accountServiceImpl.getaccounts();
	}

	@GetMapping("/accounts/{accountId}")
	public Account getAccountById(@PathVariable String accountId) {
		logger.info("Getting Account accounts Data..");
		return accountServiceImpl.getaccountByAccNum(accountId);
	}

}
