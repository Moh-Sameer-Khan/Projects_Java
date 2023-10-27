package com.atmmachineprogramming;

import java.util.Scanner;

public class MainClass {
	
	public static Scanner input = new Scanner(System.in);
	
    public static void main (String [] args) {
//    	creating an object for AtmOperationImpl and we can access all operation in this class
    	AtmOperationInterf atmOperation = new AtmOperationImpl();
//    	Set the ATM PIN and ATM Number hard coded
        final int atmnumber = 1;
        final int atmpin = 1;
//        Taking the input for some users account number
        System.out.println("Enter the First Account Number:");
        String user1AccNum = input.next();
        System.out.println("Enter the Second Account Number:");
        String user2AccNum = input.next();
        
//        creating an object for user class and pass the data
        User user1 = new User("Sameer", user1AccNum, 1000.0);
        User user2 = new User("Same", user2AccNum, 5000.0);
        
//        adding user in the list
        atmOperation.addUser(user1);
        atmOperation.addUser(user2);
        
//        Select the user
        System.out.println("Please enter an option for taking any one user ..There is a two user..");
        int option = input.nextInt();
        
//        initialize because we are using here and inside loop in below
        User user;
        
        if(option == 1) {
        	user = atmOperation.getUser(user1AccNum);
        }else {
        	user = atmOperation.getUser(user2AccNum);
        }
//        Showing a message for Interface 
        System.out.println("Welcome to ATM Machine !!!");
        
//          Authentication
        System.out.print("Enter Your Atm Number : ");
        int atmNumber = input.nextInt();
        System.out.print("Enter Your Atm Pin: ");
        int pin = input.nextInt();
        	
//        Enter the details and taking the Authority if ATM Number and ATM Pin is right otherwise not applicable
        
        if((atmnumber == atmNumber) && (atmpin == pin)) {
        	
//        	if ATM Number and PIN are correct the we can performs the task
        	System.out.println("Authentication successful. Access granted to ATM !!!");
        	 
//        	 Performing operation until it's true
            while(true) {
//            	Showing details here...
                System.out.println(" 1. Check Available Balance\n 2. Withdraw Amount\n 3. Deposit Amount\n 4. View Ministatement\n 5. Previous Transaction By Days\n 6. User Information \n 7. Swith Users \n 8. Exit");

                if(user != null) {
                	
                    
//                  Taking an choice by user
                	System.out.println("Enter Choice : ");
                	int ch = input.nextInt();
                  
//                 Checking the choice and then perform that operation otherwise exit 
                	if(ch == 1) {
//                  	Checking the balance here
                		atmOperation.viewBalance(user);
                	}
                	else if(ch == 2){
//                  	Withdraws Money here...
                		System.out.println("Enter the amount to withdraw : ");
                		double withdrawAmount = input.nextDouble();
                		atmOperation.withdrawAmount(user, withdrawAmount);

                	}else if(ch == 3){
//                  	Deposit Money here
                		System.out.println("Enter the amount to Deposit : ");
                		double depositAmount = input.nextDouble();//5000
                		atmOperation.depositAmount(user, depositAmount);
                    
                	}else if(ch == 4){
//                		checking the transaction history
                		atmOperation.viewMiniStatement(user);
                  	
                	}else if(ch == 5) {
//                		checking the history according passing the days
                		System.out.println("Please enter trnsaction days...");
                		try {
                			int days = input.nextInt();
                			atmOperation.transactionByDaysByUser(user, days);
                		}catch(Exception e) {
                			System.out.println("Please enter a valid days for tanscaton history...");
//                  		System.exit(0);
                		}
                	}else if(ch == 6){
//                		get the user information
                		atmOperation.getUserInformation(user);
                	}else if(ch == 7) {
//                		switching the users
                		System.out.println("Please enter an option for swith the user anyone ..There is a two user..");
                        option = input.nextInt();
                		if(option == 1) {
                        	user = atmOperation.getUser(user1AccNum);
                        }else if(option == 2){
                        	user = atmOperation.getUser(user2AccNum);
                        }else {
                        	System.out.println("User Not Found Please enter a valid option");
                        }
                	}else if(ch == 8){
//                		if we want to exit from the ATM 
                		System.out.println("Please Collect Your ATM Card\n Thank you for using ATM Machine!!");
                		System.exit(0);
                     
                	}else{
//                		if user enter the incorrect choice then
                		System.out.println("Please Enter Correct Choice");
                	}
                }else {
//                	if there is not found not user then 
                	System.out.println("User not found.");
                }
            }
        }else{
//        	when wrong pin or atm number
            System.out.println("Authentication failed.Invalid Your Atm Number or ATM pin");
            System.exit(0);
            
        }
    }
}
