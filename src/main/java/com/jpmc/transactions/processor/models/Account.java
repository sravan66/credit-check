package com.jpmc.transactions.processor.models;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "account")
@Data
public class Account {
	
	@Id
	private String accountId;
	
	private String accountName;
	
	private String accountType;
	
	private BigDecimal accountBalance;
	
	private Address address;

}
