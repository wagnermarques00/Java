public class Administrator extends Employee implements Authenticable { //Administrator is an employee and signs an "Authenticable" contract
	private Authenticator authenticator;

	public Administrator() {
		this.authenticator = new Authenticator();
	}

	@Override
	public double calculateBonusSalary() {
		System.out.println("calculating administrator bonus");
		return 5000.0;
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
