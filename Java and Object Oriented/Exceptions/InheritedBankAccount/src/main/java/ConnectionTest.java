public class ConnectionTest {

	public static void main(String[] args) {

		try (Connection connection = new Connection()) {
			connection.readData();
		} catch (IllegalStateException e) {
			System.out.println("Connection error");
		}

//-----------------------------------------------\\
// The lines 5-6-7 are an simplified version of the code below
//		Connection conn = null;
//
//		try {
//			conn = new Connection();
//			conn.readData();
//		} catch (IllegalStateException e) {
//			System.out.println("Connection error");
//		} finally {
//			System.out.println("Finally used");
//			if(conn != null) {
//				conn.close();
//			}
//		}
	}
}

/*
 * The console output will be:
 * Opening connection
 * Reading data
 * Connection error
 * Closing connection
 * Exception in thread "main" java.lang.IllegalStateException
 * 	at Connection.readData(Connection.java:9)
 * 	at ConnectionTest.main(ConnectionTest.java:6)
 */