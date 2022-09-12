public class InternalSystemTest {

	public static void main(String[] args) {
		InternalSystem internalSystem = new InternalSystem();
		Administrator administrator = new Administrator();
		Manager manager = new Manager();

		manager.setPassword(123456);
		internalSystem.authenticate(manager); // Authentication successful

		manager.setPassword(111222);
		internalSystem.authenticate(manager); // Authentication failed

		administrator.setPassword(123456);
		internalSystem.authenticate(administrator); // Authentication successful

	}
}
