package com.atmmachineprogramming;


import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class AtmOperationImpl implements AtmOperationInterf{
	
	
    private HashMap<String, User> users; 

//    constructor
    public AtmOperationImpl() {
    	this.users = new HashMap<>();
    }
    
//    adding the User
    @Override
    public void addUser(User user) {
    	users.put(user.getAccountNumber(), user);
    }
    
    
//    Get user
    @Override
    public User getUser(String accountNumber) {
        return users.get(accountNumber);
    }
    
    @Override
    public void viewBalance (User user) {
        System.out.println("Available Balance is : " + user.getBalance());
    }

    @Override
    public void withdrawAmount (User user, double withdrawAmount) {
//    	first i want to get the total balance 
    	double balance = user.getBalance();
    	
//    	check the withdraw amount is divisible 500 or not
//    	if divisible then we can withdraw the money
        if(withdrawAmount % 500 == 0) {
//        	check the withdraw amount is less than or equal available balance 
//        	if true --> the withdraw amount is less than or equal available balance
            if (withdrawAmount <= balance) {
//                	And add in transaction History
            	user.getTransactionHistory().add(new Transaction(new Date(), withdrawAmount));

                System.out.println(" Collect the Cash " + withdrawAmount);
//                	reduce the balance after withdraw amount
                user.setBalance(balance - withdrawAmount);
//                	show the total balance
                System.out.println("Withdrawal successful. Current balance: " + user.getBalance());
            } else {
//            	if Amount is not available then show this message
                System.out.println("Insufficient Balance !!");
            }
        }
        else {
//        	if not multiple of 500 
            System.out.println("Please enter the amount in multiple of 500");
        }

    }
    @Override
    public void depositAmount(User user, double depositAmount) {
//    	adding in the transaction history
		user.getTransactionHistory().add(new Transaction(new Date(), depositAmount));
        System.out.println(depositAmount + " Deposited Successfully !!");
//        Update the total Balance
        user.setBalance(user.getBalance() + depositAmount);
//        show balance
        System.out.println("Deposited successful. Current balance: " + user.getBalance());

    }
    
    @Override
    public void viewMiniStatement(User user) {
//    	if size 0 then no transaction
    	List<Transaction> transactions = user.getTransactionHistory();
    	if(transactions.size() == 0) {
    		System.out.println("Sorry !!! \n No transaction Found!!");
    	}else {
    		System.out.println("Mini Statements are showing ..");
            for(Transaction transaction : transactions){
            	System.out.println(transaction.getDate() + " - Amount: $" + transaction.getAmount());
            }
            
    	}
    	
    }
    
    @Override
    public void transactionByDaysByUser(User user, int days) {
    	System.out.println("Last " + days + " Days Transactions:");
    	List<Transaction> transactions = user.getTransactionHistory();
    	
    	
    	if(transactions.size() == 0) {
    		System.out.println("Sorry !!! \n No transaction Found!!");
    	}else {
    		int count = 0;
    		for(int i = transactions.size() - 1; i >= 0; i --) {
    			Transaction transaction = transactions.get(i);
    			System.out.println(transaction.getDate() + " - Amount: $" + transaction.getAmount());
    			count ++;
    			if(count == days) {
    				break;
    			}
    		}
    	}
    }
    @Override
    public void getUserInformation(User user) {
        System.out.println("User Information:");
        System.out.println("Name: " + user.getName());
        System.out.println("Account Number: " + user.getAccountNumber());
        System.out.println("Current Balance: $" + user.getBalance());
    }
}
