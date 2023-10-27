package com.atmmachineprogramming;

public interface AtmOperationInterf {
    public void viewBalance(User user);
    public void withdrawAmount(User user, double withdrawAmount);
    public void depositAmount(User user, double depositAmount);
    public  void viewMiniStatement(User user);
    public void transactionByDaysByUser(User user, int days);
    public void getUserInformation(User user);
    public void addUser(User user);
    public User getUser(String accountNumber);
}
