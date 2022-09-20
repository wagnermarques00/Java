public class Connection implements AutoCloseable {

	public Connection() {
		System.out.println("Opening connection");
	}

	public void readData() {
		System.out.println("Reading data");
		throw new IllegalStateException();
	}

	@Override
	public void close() {
		System.out.println("Closing connection");
	}
}
