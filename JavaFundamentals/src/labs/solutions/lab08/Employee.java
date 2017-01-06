package labs.solutions.lab08;


abstract public class Employee {
	public static enum EmpType {Salary, Hourly} 
	
	private String name;
	private int id;
	private String department;
	
	public Employee(String name, int id, String department) {
		this.name = name;
		this.id = id;
		this.department = department;
	}
	
	abstract float computePay();
	
	protected static void runPayroll(Employee[] emps) {
		int i= 0;
		while(i < emps.length) {
			System.out.println("Employee : " + emps[i]);
			System.out.println("\t Cut Check For: " + emps[i].computePay());
			i++;
		}	
	}
	
	public static void main(String[] args) {
		
		Employee[] employees = new Employee[5];
		employees[0] = new SalaryEmployee(2200, "Fred", 2232, "Sales");
		employees[1] = new HourlyEmployee((float)15.50, "Tom", 4532, "Operator");
		((HourlyEmployee)employees[1]).setHoursWorked(40);
		employees[2] = new SalaryEmployee((float)2500, "Sue", 9876, "Manager");
		employees[3] = new HourlyEmployee((float)10.50, "Jenny", 54433, "Receptionist");	
		((HourlyEmployee)employees[3]).setHoursWorked(30);
		employees[4] = new SalaryEmployee((float)2500, "David", 55467, "Accountant");		
		
		runPayroll(employees);
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


}
