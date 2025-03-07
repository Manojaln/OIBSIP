package org.data;

import java.util.*;

public class ATMOperation {
	public static void withdraw(BankAccount account, Scanner scanner) {
		System.out.print("Enter withdrawal amount: ");
		double amount = scanner.nextDouble();
		account.withdraw(amount);
	}

	public static void deposit(BankAccount account, Scanner scanner) {
		System.out.print("Enter deposit amount: ");
		double amount = scanner.nextDouble();
		account.deposit(amount);
	}

	public static void transfer(BankAccount sender, BankAccount recipient, Scanner scanner) {
		System.out.print("Enter transfer amount: ");
		double amount = scanner.nextDouble();
		sender.transfer(recipient, amount);
	}

	public static void showTransactionHistory(BankAccount account) {
		account.getTransactionHistory();
	}

}
