package com.jpmc.transactions.processor.models;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class PaymentInfo {

	private String paymentId;

	private String currency;

	private BigDecimal amount;

	private Long timeStamp;
	
}
