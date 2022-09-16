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

}
