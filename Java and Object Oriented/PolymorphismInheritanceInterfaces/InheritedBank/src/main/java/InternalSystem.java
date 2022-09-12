public class InternalSystem {
	private int password = 123456;

	public void authenticate(Authenticable authenticable) {
		boolean authenticate = authenticable.authenticate(this.password);
		if(authenticate) {
			System.out.println("Authentication successful");
		} else {
			System.out.println("Authentication failed");
		}
	}

}
