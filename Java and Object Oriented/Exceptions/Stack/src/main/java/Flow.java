public class Flow {

	public static void main(String[] args) {
		System.out.println("Start of the main");
		method1();
		System.out.println("End of the main");
	}

	private static void method1() {
		System.out.println("Start of the method1");
		method2();
		System.out.println("End of the method1");
	}

	private static void method2() {
		System.out.println("Start of the method2");
		for (int i = 1; i <= 5; i++) {
			System.out.println(i);
		}
		System.out.println("End of the method2");
	}

	/* *** Following the flow, the result will be as below ***
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

}
