public class Manager extends Employee{ // Manager class inherits from employee class
	private int password;

	public boolean authenticate(int password) {
		if(this.password == password) {
			return true;
		} else {
			return false;
		}
	}

	public double calculateBonusSalary() {
		return super.calculateBonusSalary() + super.getSalary(); // super -> since manager inherits information from employee, we write it as "super"
	}


	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}
}
