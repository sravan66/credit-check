package com.jpmc.transactions.processor.models;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NonNull;

@Document(collection = "transactions")
@Data
public class Transaction {

	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	@Id
	private String transId;

	@Indexed
	@NonNull
	private String creditorAccountId;
	
	@Indexed
	@NonNull
	private String debitorAccountId;

	private Date transactionTs;

	private BigDecimal amount;
	
	private String currency;
	

	
	

}
