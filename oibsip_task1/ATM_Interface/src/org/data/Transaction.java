package org.data;

import java.time.LocalDateTime;

public class Transaction {
	private String type;
	private double amount;
	private LocalDateTime timestamp;

	Transaction(String type, double amount) {
		this.type = type;
		this.amount = amount;
		this.timestamp = LocalDateTime.now();

	}

	public String getTransactionDetails() {
		return timestamp + " - " + type + "; " + amount;
	}
}
