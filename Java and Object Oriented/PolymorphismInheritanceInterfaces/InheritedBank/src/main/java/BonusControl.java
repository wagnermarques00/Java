public class BonusControl {
	private double totalBonus;

	public void register(Employee employee) {
		double bonus = employee.calculateBonusSalary();
		this.totalBonus = this.totalBonus + bonus;
	}

	public double getTotalBonus() {
		return totalBonus;
	}
}
