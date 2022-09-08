public class Employee {
	private String name;
	private String employeeId;
	private double salary;

	public double calculateBonusSalary() {
		//System.out.println("calculating employee bonus");
		return this.salary * 0.05;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
