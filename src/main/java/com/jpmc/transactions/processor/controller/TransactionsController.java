package com.jpmc.transactions.processor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpmc.transactions.processor.models.ResponseData;
import com.jpmc.transactions.processor.models.TransactionData;
import com.jpmc.transactions.processor.service.TransactionService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TransactionsController {

	@Autowired
	TransactionService transactionServiceImpl;

	@PostMapping("/process-transaction")
	public ResponseEntity<ResponseData> performTransaction(@RequestBody TransactionData transactionData) {

		log.info("Processing Transaction....");
		ResponseData response = transactionServiceImpl.processTransactions(transactionData);
		return new ResponseEntity(response, HttpStatus.OK);
	}

}
