package labs.solutions.lab13.compensation;

import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import labs.solutions.lab13.IEmployee;

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

	public void runPayroll(List<Integer> alst, Map<Integer, IEmployee> myMap) {

		for (ListIterator<Integer> it = alst.listIterator(0); it.hasNext(); ) {
			Integer empId = it.next();
		    IEmployee emp = myMap.get(empId);
			System.out.println("Employee : " + emp);
			System.out.println("\t of type: " + emp.getClass());
			System.out.println("\t Cut Check For: " + emp.computePay());
		}
	}

}
