public class Manager extends Employee implements Authenticable { // Manager is an employee and signs an "Authenticable" contract
	private Authenticator authenticator;

	public Manager() {
		this.authenticator = new Authenticator();
	}

	public double calculateBonusSalary() {
		System.out.println("calculating manager bonus");
		return super.getSalary(); // super -> since manager inherits information from employee, we write it as "super"
	}

	@Override
	public boolean authenticate(int password) {
		return this.authenticator.authenticate(password);
	}

	@Override
	public void setPassword(int password) {
		this.authenticator.setPassword(password);
	}

}
