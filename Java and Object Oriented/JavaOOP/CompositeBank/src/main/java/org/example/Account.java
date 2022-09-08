package org.example;

public class Account {
    private double balance;
    int agency;
    int number;
    Customer customer;

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

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
