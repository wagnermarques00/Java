package org.example;

public class TestRelations {

    public static void main(String[] args) {
        Customer firstCustomer = new Customer();
        firstCustomer.name = "Jonathan Joestar";
        firstCustomer.clientId = "123456789";
        firstCustomer.profession = "Archaeologist";

        Account firstAccount = new Account();
        firstAccount.agency = 123;
        firstAccount.setBalance(8000.00);
        firstAccount.number = 456789;
        firstAccount.customer = firstCustomer; // associate first customer with first account

        System.out.println(firstAccount.customer.name); //is referencing the customer object inside the account object
    }
}
