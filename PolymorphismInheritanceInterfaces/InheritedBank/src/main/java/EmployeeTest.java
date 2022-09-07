public class EmployeeTest {

	public static void main(String[] args) {
		Employee employee = new Employee();
		employee.setName("Kujo Jotaro");
		employee.setEmployeeId("3");
		employee.setSalary(1970.00);

		System.out.println(employee.getName()); // Kujo Jotaro
		System.out.println(employee.getEmployeeId()); // 3
		System.out.println(employee.getSalary()); // 1970.0
		System.out.println(employee.calculateBonusSalary()); // 197.0 (10% of bonus)
	}
}
