package org.example;

public class TestWithdrawNegativeValues {

    public static void main(String[] args) {
        Account secondAccount = new Account();
        secondAccount.deposit(100);
        System.out.println(secondAccount.withdraw(200));
        System.out.println(secondAccount.getBalance());



    }
}
