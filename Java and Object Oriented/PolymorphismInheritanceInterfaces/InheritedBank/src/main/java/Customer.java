public class Customer implements Authenticable { //Customer signs an "Authenticable" contract
	private Authenticator authenticator;

	public Customer() {
		this.authenticator = new Authenticator();
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
