package com.jpmc.transactions.processor.models;

import lombok.Data;

@Data	
public class ResponseData {
	
	private String transId;
	
	private String messageId;
	
	private String e2eId;
	
	private String transactionStatus;
	


}
