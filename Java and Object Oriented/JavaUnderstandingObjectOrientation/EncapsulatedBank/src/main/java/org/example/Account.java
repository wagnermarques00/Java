package org.example;

public class Account {
    private double balance;
    private int agency;
    private int number;
    private Customer customer;
    private static int totalAccounts; // This will be a shared attribute (not instantiated) between account objects

    public Account(int agency, int number) {
        this.agency = agency;
        this.number = number;
        Account.totalAccounts++;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public boolean withdraw(double amount) {
        if(this.balance >= amount) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public boolean transfer(double amount, Account destinationAccount) {
        if(this.balance >= amount) {
            this.balance -= amount;
            destinationAccount.deposit(amount);
            return true;
        }
        return false;
    }

    public double getBalance() {
        return this.balance;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        if (number <= 0) {
            System.out.println("Invalid number");
            return;
        }
        this.number = number;
    }

    public int getAgency() {
        return this.agency;
    }

    public void setAgency(int agency) {
        if(agency <= 0) {
           System.out.println("Agency must be greater than zero");
           return;
        }
        this.agency = agency;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public static int getTotalAccounts() {
        return Account.totalAccounts;
    }
}
