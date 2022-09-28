package org.example;

public class TestValues {

	public static void main(String[] args) {
		Account firstAccount = new Account(123456, 789);

		firstAccount.setAgency(-50); // Agency must be greater than zero
		firstAccount.setNumber(-1);  // Invalid number
		System.out.println(firstAccount.getAgency()); // 123456
		System.out.println(firstAccount.getNumber()); // 789

		System.out.println(Account.getTotalAccounts()); // Because the element is static, we have to call it like this
		Account secondAccount = new Account(789012, 123);
		System.out.println(Account.getTotalAccounts()); // Because the element is static, we have to call it like this

	}
}
