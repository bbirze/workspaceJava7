package labs.solutions.lab08;

public class HourlyEmployee extends Employee {

	float wage;
	int hoursWorked;
	
	public HourlyEmployee(float wage, String name, int id, String department)  {
		super(name, id, department);
		this.wage = wage;		
	}
	
	float computePay()  {
		return hoursWorked * wage;
	}


	public String toString() {
		return super.toString() + " wage: $" + wage + "/hour";
	}
	
	public int getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public float getWage() {
		return wage;
	}

}
