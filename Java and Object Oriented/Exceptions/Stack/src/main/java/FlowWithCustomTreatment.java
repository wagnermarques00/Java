public class FlowWithCustomTreatment {

	public static void main(String[] args) throws MyException {
		System.out.println("Start of the main");
		try {
			method1();
		} catch (Exception ex) {
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

	private static void method2() throws MyException {
		System.out.println("Start of the method2");

		throw new MyException("Got a custom exception");

//		System.out.println("End of the method2"); // -> since an exception was thrown earlier, we will have this unreachable code
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

/* ** Example of a thrown MyException: throw new MyException("Got a custom exception"); **
 * *** If you caused this exception inside the for structure in method2, the output will be as below ***
 *
 * Start of the main
 * Start of the method1
 * Start of the method2
 * Exception in thread "main" MyException: Got a custom exception
 * 	at FlowWithTreatment.method2(FlowWithTreatment.java:23)
 * 	at FlowWithTreatment.method1(FlowWithTreatment.java:16)
 * 	at FlowWithTreatment.main(FlowWithTreatment.java:6)
 */