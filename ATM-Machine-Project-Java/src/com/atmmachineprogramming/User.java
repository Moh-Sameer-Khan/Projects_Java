package com.atmmachineprogramming;

import java.util.ArrayList;
import java.util.List;

class User {
	private String name;
	private String accountNumber;
	private double balance;
	private List<Transaction> transactionHistoroy; 
	
//	Getter Method to access these data memeber
	public User(String name, String accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactionHistoroy = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public List<Transaction> getTransactionHistory() {
        return transactionHistoroy;
    }

}
