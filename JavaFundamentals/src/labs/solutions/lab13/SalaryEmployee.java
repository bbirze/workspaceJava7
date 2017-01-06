package labs.solutions.lab13;


public class SalaryEmployee extends Employee {

	float basePay;
	
	public SalaryEmployee(float basePay, String name, int id, String department)  {
		super(name, id, department);
		this.basePay = basePay;		
	}
	
	public float computePay()  {
		return basePay;
	}

	public String toString() {
		return super.toString() + " Salary: $" + basePay + " per week";
	}

}
