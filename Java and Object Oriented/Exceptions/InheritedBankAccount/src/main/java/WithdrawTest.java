public class WithdrawTest {

	public static void main(String[] args) throws InsufficientBalanceException {
		CheckingAccount checkingAccount = new CheckingAccount(111, 222);
		checkingAccount.deposit(200.0);

		checkingAccount.withdraw(190.0); // Ok, balance is 9.80

		try {
			checkingAccount.withdraw(10.0);
		} catch (Exception e) {
			System.out.println(e.getMessage()); // Balance: 9.800000000000011 is insufficient to withdraw 10.2
		}

		System.out.println(checkingAccount.getBalance());
	}
}
