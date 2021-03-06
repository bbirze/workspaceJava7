package labs.solutions.lab13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import labs.solutions.lab13.compensation.Payroll;

abstract public class Employee implements IEmployee {
	public static enum EmpType {Salary, Hourly} 
	
	private String name;
	private int id;
	private String department;
	
	public Employee(String name, int id, String department) {
		this.name = name;
		this.id = id;
		this.department = department;
	}
	
	public String toString() {
		return "ID: " + id + " Name: " + name + " Department: " + department;
	}
	
	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public String getDepartment() {
		return department;
	}

	
	public static void main(String[] args) {
		
		IEmployee[] employees = new Employee[5];
		employees[0] = new SalaryEmployee(2200, "Fred", 2232, "Sales");
		employees[1] = new HourlyEmployee((float)15.50, "Tom", 4532, "Operator");
		((HourlyEmployee)employees[1]).setHoursWorked(40);
		employees[2] = new SalaryEmployee((float)2500, "Sue", 9876, "Manager");
		employees[3] = new HourlyEmployee((float)10.50, "Jenny", 54433, "Receptionist");	
		((HourlyEmployee)employees[3]).setHoursWorked(30);
		employees[4] = new SalaryEmployee((float)2500, "David", 55467, "Accountant");		
	
		Map<Integer, IEmployee> myMap = new HashMap<>();
		List<Integer> alst = new ArrayList<>();   
		
		for (int i = 0; i<employees.length; i++)  {
			alst.add(employees[i].getId());    
			myMap.put(employees[i].getId(), employees[i]);
		}

		Payroll pr = new Payroll();
		pr.runPayroll(alst, myMap);
	}

}
