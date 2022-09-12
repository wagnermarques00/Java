public class Administrator extends Employee implements Authenticable { //Administrator is an employee and signs an "Authenticable" contract
	private int password;

	@Override
	public double calculateBonusSalary() {
		System.out.println("calculating administrator bonus");
		return 5000.0;
	}

	@Override
	public boolean authenticate(int password) {
		return this.password == password;
	}

	@Override
	public void setPassword(int password) {
		this.password = password;
	}

}
