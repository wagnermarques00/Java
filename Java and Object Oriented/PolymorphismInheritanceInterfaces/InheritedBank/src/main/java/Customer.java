public class Customer implements Authenticable { //Customer signs an "Authenticable" contract
	private int password;

	@Override
	public boolean authenticate(int password) {
		return this.password == password;
	}

	@Override
	public void setPassword(int password) {
		this.password = password;
	}

}
