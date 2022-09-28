public class TestMethods {
    public static void main(String[] args) {
        Account account = new Account();
        Account secondAccount = new Account();

        account.balance = 100;
        System.out.println("Account balance: " + account.balance);

        account.deposit(50);
        System.out.println("Account balance after deposit: " + account.balance);

        boolean withdrawSucceeded = account.withdraw(25);
        System.out.println("Account withdraw successful: " + withdrawSucceeded);
        System.out.println("Account balance after withdraw: " + account.balance);

        secondAccount.deposit(1000);
        System.out.println("Second account balance:" + secondAccount.balance);

        boolean transferSucceeded = secondAccount.transfer(300, account);
        // Change the first argument to a value greater than the balance to return the second condition
        if (transferSucceeded) {
            System.out.println("Second account transfer successful: " + transferSucceeded);
            System.out.println("First account balance after transfer: " + account.balance);
            System.out.println("Second account balance after transfer: " + secondAccount.balance);
        } else {
            System.out.println("Second account transfer failed");
        }

        account.ownerName = "Jonathan Joestar";
        System.out.println("First account owner: " + account.ownerName);

        secondAccount.ownerName = "Joseph Joestar";
        System.out.println("Second account owner: " + secondAccount.ownerName);

    }
}
