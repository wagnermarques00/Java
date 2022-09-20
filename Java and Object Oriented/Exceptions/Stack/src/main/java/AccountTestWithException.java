public class AccountTestWithException {

	public static void main(String[] args) {
		Account account = new Account();

		try {
			account.deposit();
		} catch (MyException me) {
			System.out.println("MyException treatment");
		}
	}

}
