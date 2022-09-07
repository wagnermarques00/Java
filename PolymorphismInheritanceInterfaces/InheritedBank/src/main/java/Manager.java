public class Manager extends Employee{ // Manager class inherits from employee class
	private int password;

	public boolean authenticate(int password) {
		if(this.password == password) {
			return true;
		} else {
			return false;
		}
	}

//	public double calculateBonusSalary() {
//		return this.salary * 0.1;
//	}


	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}
}
