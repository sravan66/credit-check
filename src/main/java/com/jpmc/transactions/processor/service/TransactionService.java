package com.jpmc.transactions.processor.service;

import com.jpmc.transactions.processor.models.ResponseData;
import com.jpmc.transactions.processor.models.TransactionData;

public interface TransactionService {

	ResponseData processTransactions(TransactionData transactionData);

}
