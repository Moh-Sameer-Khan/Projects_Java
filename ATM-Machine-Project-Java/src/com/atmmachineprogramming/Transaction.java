package com.atmmachineprogramming;

import java.util.Date;

class Transaction {
	private Date date;
	private double amount;

	 public Transaction(Date date, double amount) {
	        this.date = date;
	        this.amount = amount;
	    }

	    public Date getDate() {
	        return date;
	    }

	    public double getAmount() {
	        return amount;
	    }

}
