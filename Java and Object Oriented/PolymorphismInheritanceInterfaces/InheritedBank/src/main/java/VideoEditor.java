public class VideoEditor extends Employee{ // Manager class inherits from employee class

	public double calculateBonusSalary() {
		System.out.println("calculating video editor bonus");
		return super.calculateBonusSalary() + 100; // super -> since video editor inherits information from employee, we write it as "super"
	}

}
