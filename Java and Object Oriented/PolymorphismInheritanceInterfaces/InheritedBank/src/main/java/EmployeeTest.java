public class EmployeeTest {

	public static void main(String[] args) {
		Manager manager = new Manager();
		manager.setName("Kujo Jotaro");
		manager.setEmployeeId("3");
		manager.setSalary(1970.00);

		System.out.println(manager.getName()); // Kujo Jotaro
		System.out.println(manager.getEmployeeId()); // 3
		System.out.println(manager.getSalary()); // 1970.0
		System.out.println(manager.calculateBonusSalary()); // 2068.5 (manager bonus)
	}
}
