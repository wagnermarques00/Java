public class Designer extends Employee{ // Manager class inherits from employee class

	public double calculateBonusSalary() {
		System.out.println("calculating designer bonus");
		return 200; // super -> since video editor inherits information from employee, we write it as "super"
	}

}
