public class ManagerTest {

	public static void main(String[] args) {
		Manager manager = new Manager();
		manager.setName("Giorno Giovanna");
		manager.setEmployeeId("5");
		manager.setSalary(1985.00);

		System.out.println(manager.getName()); // Giorno Giovanna
		System.out.println(manager.getEmployeeId()); // 5
		System.out.println(manager.getSalary()); // 1985.0
		System.out.println(manager.calculateBonusSalary()); // 197.0 (10% of bonus)

		boolean authenticated = manager.authenticate(2222);
		System.out.println(authenticated); // false (because default is 0 and the password was not changed)
		manager.setPassword(123456);
		System.out.println(manager.getPassword());
		boolean secondAuthenticated = manager.authenticate(123456);
		System.out.println(secondAuthenticated); // now the result is true

	}
}
