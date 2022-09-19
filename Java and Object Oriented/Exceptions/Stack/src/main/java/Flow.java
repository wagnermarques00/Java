public class Flow {

	public static void main(String[] args) {
		System.out.println("Start of the main");
		try {
			method1();
		} catch (ArithmeticException | NullPointerException | MyException ex) {
			System.out.println("Exception: " + ex.getMessage()); // Exception: message of the exception
			ex.printStackTrace(); // It will show the standard exception message, but it will follow the execution flow
		}
		System.out.println("End of the main");
	}

	private static void method1() throws MyException {
		System.out.println("Start of the method1");
		method2();
		System.out.println("End of the method1");
	}

	private static void method2() {
		System.out.println("Start of the method2");
		for (int i = 1; i <= 5; i++) {
			System.out.println(i);
			int a = i / 0;  // --> Will cause an Arithmetic exception
			NullClass nullClass = null;
			nullClass.deposit(); // --> Will cause a Null Pointer exception
		}
		System.out.println("End of the method2");
	}

}
/* *** Following the flow, the expected result will be as below ***
 * Start of the main
 * Start of the method1
 * Start of the method2
 * 1
 * 2
 * 3
 * 4
 * 5
 * End of the method2
 * End of the method1
 * End of the main
 */

/* ** Example of ArithmeticException: int a=i/0; **
 * *** If you caused this exception inside the for structure in method2, the output will be as below ***
 *
 * Start of the main
 * Start of the method1
 * Start of the method2
 * 1
 * Exception in thread "main" java.lang.ArithmeticException: / by zero
 * 	at Flow.method2(Flow.java:19)
 * 	at Flow.method1(Flow.java:11)
 * 	at Flow.main(Flow.java:5)
 */

/* ** Example of NullPointerException: NullClass nullClass = null;  ->  nullClass.deposit(); **
 * *** If you caused this exception inside the for structure in method2, the output will be as below ***
 *
 * Start of the main
 * Start of the method1
 * Start of the method2
 * 1
 * Exception in thread "main" java.lang.NullPointerException
 * 	at Flow.method2(Flow.java:22)
 * 	at Flow.method1(Flow.java:11)
 * 	at Flow.main(Flow.java:5)
 */