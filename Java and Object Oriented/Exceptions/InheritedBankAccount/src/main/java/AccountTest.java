public class AccountTest {

	public static void main(String[] args) {

		/*
		*** NullPointerException example ***
		SavingsAccount another = null;
		another.deposit(200.0);
		-> NullPointerException since the pointed object was null
		*/

		/*
		*** ArithmeticException example ***
		int a = 3;
		int b = a / 0;
		-> ArithmeticException since it is not possible to divide by zero
		*/


		CheckingAccount checkingAccount = new CheckingAccount(111, 111);
		checkingAccount.deposit(500);

		SavingsAccount savingsAccount = new SavingsAccount(111, 222);
		savingsAccount.deposit(1000);

		checkingAccount.transfer(10.0, savingsAccount);
		System.out.println("CA: " + checkingAccount.getBalance()); // 489.8 (after transfer and fee calculation)
		System.out.println("SA: " + savingsAccount.getBalance()); // 1010.0 (after transfer)
	}

}
