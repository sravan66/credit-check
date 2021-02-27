package com.jpmc.transactions.processor.models;

import lombok.Data;

@Data
public class TransactionData {
	
	
private String transId;
	
	private String messageId;
	
	private String e2eId;
	
	private String transactionStatus;
	
	private String debitorAccountId;
	
	private String creditorAccountId;
	
	private PaymentInfo paymentInfo; 
	
	

}
