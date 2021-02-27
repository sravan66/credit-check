package com.jpmc.transactions.processor.service;

import java.util.List;

import com.jpmc.transactions.processor.models.Account;

public interface AccountService {

	Account createaccounts(Account account);

	Account updateaccounts(Account account);

	List<Account> getaccounts();

	Account getaccountByAccNum(String accountId);

}
