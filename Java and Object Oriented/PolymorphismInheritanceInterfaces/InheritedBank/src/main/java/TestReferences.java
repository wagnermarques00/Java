public class TestReferences {

	public static void main(String[] args) {
		VideoEditor ve = new VideoEditor();
		ve.setName("Jean Pierre Polnareff");
		ve.setSalary(3000.0);

		Designer d1 = new Designer();
		d1.setName("Caesar Anthonio Zeppeli");
		d1.setSalary(3500.0);

		Manager m1 = new Manager();
		m1.setName("Giorno Giovanna");
		m1.setSalary(5000.0);

		BonusControl control = new BonusControl();
		control.register(m1); // calculating manager bonus
		control.register(ve); // calculating video editor bonus
		control.register(d1); // calculating designer bonus

		System.out.println(m1.calculateBonusSalary()); // 5250.0
		System.out.println(ve.calculateBonusSalary()); //  250.0
		System.out.println(d1.calculateBonusSalary()); //  200.0
		System.out.println(control.getTotalBonus());   // 5800.0 -> 5250.0 + 100.0 + 250.0 + 200.0
	}
}
