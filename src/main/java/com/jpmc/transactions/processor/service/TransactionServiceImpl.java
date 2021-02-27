package com.jpmc.transactions.processor.service;

import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpmc.transactions.processor.models.Account;
import com.jpmc.transactions.processor.models.ResponseData;
import com.jpmc.transactions.processor.models.Transaction;
import com.jpmc.transactions.processor.models.TransactionData;
import com.jpmc.transactions.processor.repository.TransactionsRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	AccountService accountServiceImpl;

	@Autowired
	TransactionsRepository transactionRepo;

	@Override
	public ResponseData processTransactions(TransactionData transactionData) {
		// TODO Auto-generated method stub
		ResponseData response = new ResponseData();
		response.setTransId(transactionData.getTransId());
		response.setMessageId(transactionData.getMessageId());
		response.setE2eId(transactionData.getE2eId());
		String debitorAccountId = transactionData.getDebitorAccountId();
		String creditorAccountId = transactionData.getCreditorAccountId();
		Account debitorAccount = accountServiceImpl.getaccountByAccNum(debitorAccountId);
		Account creditorAccount = accountServiceImpl.getaccountByAccNum(creditorAccountId);

		if (debitorAccount == null && creditorAccount == null) {
			response.setTransactionStatus("Please Provide Valid Account Details");
		} else {
			BigDecimal transferAmount = transactionData.getPaymentInfo().getAmount();
			if (debitorAccount.getAccountBalance().compareTo(transferAmount) < 1) {
				response.setTransactionStatus("Insufficient Balance");
			} else {
				creditorAccount.setAccountBalance(creditorAccount.getAccountBalance().add(transferAmount));
				debitorAccount.setAccountBalance(debitorAccount.getAccountBalance().subtract(transferAmount));
				accountServiceImpl.updateaccounts(creditorAccount);
				accountServiceImpl.updateaccounts(debitorAccount);

				response.setTransactionStatus("success");
				
				Transaction transaction = new Transaction();
				transaction.setTransId(transactionData.getTransId());
				transaction.setDebitorAccountId(debitorAccountId);
				transaction.setCreditorAccountId(creditorAccountId);
				transaction.setAmount(transferAmount);
				transaction.setCurrency(transactionData.getPaymentInfo().getCurrency());
				transaction.setTransactionTs(new Date(transactionData.getPaymentInfo().getTimeStamp()));

				transactionRepo.save(transaction);

			}

		}

		return response;
	}

}
