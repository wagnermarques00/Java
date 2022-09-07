public class Employee {
	private String name;
	private String employeeId;
	private double salary;
	private int password;

	public boolean authenticate(int password) {
		if(this.password == password) {
			return true;
		} else {
			return false;
		}
	}

	public double calculateBonusSalary() {
		return this.salary * 0.1;
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
