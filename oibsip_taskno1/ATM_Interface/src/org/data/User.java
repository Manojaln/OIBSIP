package org.data;

public class User {
	private String userId;
    private String userPin;
    private BankAccount account;

    public User(String userId, String userPin) {
        this.userId = userId;
        this.userPin = userPin;
        this.account = new BankAccount();
    }

    public String getUserId() {
        return userId;
    }

    public boolean validatePin(String enteredPin) {
        return this.userPin.equals(enteredPin);
    }

    public BankAccount getBankAccount() {
        return account;
    }

}
