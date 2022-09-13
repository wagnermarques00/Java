public class Authenticator {
	private int password;

	public boolean authenticate(int password) {
		return this.password == password; // since this is an equality (true or false) operator, there is no need to make the if else statement
	}

	public void setPassword(int password) {
		this.password = password;
	}
}
