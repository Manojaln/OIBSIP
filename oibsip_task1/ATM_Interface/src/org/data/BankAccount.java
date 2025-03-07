package org.data;

import java.util.ArrayList;

public class BankAccount {
	private double balance;
	private ArrayList<Transaction> transactions;

	public BankAccount() {
		this.balance = 0.0;
		this.transactions = new ArrayList<>();
	}

	public double getBalance() {
		return balance;
	}

	public void withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			addTransaction("Withdraw", amount);
			System.out.println("Withdrawal successful. New Balance: " + balance);
		} else {
			System.out.println("Insufficient balance or invalid amount.");
		}
	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			addTransaction("Deposit", amount);
			System.out.println("Deposit successful. New Balance: " + balance);
		} else {
			System.out.println("Invalid deposit amount.");
		}
	}

	public void transfer(BankAccount recipient, double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			recipient.balance += amount;
			addTransaction("Transfer Sent", amount);
			recipient.addTransaction("Transfer Received", amount);
			System.out.println("Transfer successful. New Balance: " + balance);
		} else {
			System.out.println("Insufficient balance or invalid amount.");
		}
	}

	public void addTransaction(String type, double amount) {
		transactions.add(new Transaction(type, amount));
	}

	public void getTransactionHistory() {
		if (transactions.isEmpty()) {
			System.out.println("No transactions available.");
		} else {
			for (Transaction t : transactions) {
				System.out.println(t.getTransactionDetails());
			}
		}
	}
	

}
