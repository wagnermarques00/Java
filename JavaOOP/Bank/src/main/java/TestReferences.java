public class TestReferences {

    public static void main(String[] args) {
        Account firstAccount = new Account();

        firstAccount.balance = 300;
        System.out.println("First account balance: " + firstAccount.balance);

        Account secondAccount = firstAccount; // Will reference the same object in memory, not copy to a new object
        System.out.println("Second account balance: " + secondAccount.balance);

        secondAccount.balance += 100;
        System.out.println("First account balance: " + firstAccount.balance); // Will bring the value 400
        System.out.println("Second account balance: " + secondAccount.balance); // Will bring the value 400

        if(firstAccount == secondAccount) {
            System.out.println("First and second account are the same object"); // This will be the results
        } else {
            System.out.println("First and second account are not the same object");
        }
    }
}
