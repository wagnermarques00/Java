package org.example;

public class TestGettersAndSetters {
    public static void main(String[] args) {
        Customer firstCustomer = new Customer();
        firstCustomer.setName("Joseph Joestar");
        firstCustomer.setClientId("938271");
        firstCustomer.setProfession("Real Estate");

        Account account = new Account(123, 456789 );
        account.setCustomer(firstCustomer);
        account.deposit(8000);
        System.out.println(account.getCustomer().getName()); //Joseph Joestar
        System.out.println(account.getBalance()); //8000.0
        System.out.println(account.getNumber()); //456789

        //first way to change
        Customer changedCustomer = account.getCustomer();
        changedCustomer.setName("Hermit Purple");
        System.out.println(account.getCustomer().getName()); //Hermit Purple

        //second way to change
        account.getCustomer().setName("Mr. Joestar");
        System.out.println(account.getCustomer().getName()); //Mr. Joestar

        //Ways to print the customer (memory block)
        System.out.println(changedCustomer);
        System.out.println(firstCustomer);
        System.out.println(account.getCustomer());
    }
}
