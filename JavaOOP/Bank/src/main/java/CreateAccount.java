public class CreateAccount {

    public static void main(String[] args) {
        Account firstAccount = new Account();
        Account secondAccount = new Account();

        firstAccount.balance = 200;
        System.out.println("First account balance: "+ firstAccount.balance);

        firstAccount.balance += 100;
        System.out.println("First account balance: "+ firstAccount.balance);

        secondAccount.balance = 50;
        System.out.println("Second account balance: "+ secondAccount.balance);

        secondAccount.agency = 84;
        System.out.println("Second account agency: "+ secondAccount.agency);

        if(firstAccount == secondAccount) {
            System.out.println("First and second account are the same object");
        } else {
            System.out.println("First and second account are not the same object"); // This will be the result
        }
    }
}
