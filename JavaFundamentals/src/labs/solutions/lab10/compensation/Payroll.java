package labs.solutions.lab10.compensation;

import labs.solutions.lab10.IEmployee;

public class Payroll {

	public Payroll() {
		// TODO Auto-generated constructor stub
	}

	public void runPayroll(IEmployee[] emps) {
		int i= 0;
		while(i < emps.length) {
			System.out.println("Employee : " + emps[i]);
			System.out.println("\t of type: " + emps[i].getClass());
			System.out.println("\t Cut Check For: " + emps[i].computePay());
			i++;
		}	
	}

}
