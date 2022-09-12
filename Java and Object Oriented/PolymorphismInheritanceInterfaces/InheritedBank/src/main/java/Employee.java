public abstract class Employee { // cannot instantiate this class because it is abstract
	private String name;
	private String employeeId;
	private double salary;

	public abstract double calculateBonusSalary(); // method without body, there is no implementation in it

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
