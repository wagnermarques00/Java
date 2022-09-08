public class Account {
    double balance;
    int agency;
    int number;
    String ownerName;

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
}
