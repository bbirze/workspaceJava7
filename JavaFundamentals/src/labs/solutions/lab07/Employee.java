package labs.solutions.lab07;


public class Employee {
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
		Employee Fred = new Employee("Fred", 2232, "Sales");
		HourlyEmployee Tom = new HourlyEmployee((float)10.50, "Tom", 4532, "Operator");
		SalaryEmployee Sue = new SalaryEmployee((float)2500, "Sue", 9876, "Manager");
		
		System.out.println("Employee : " + Fred);
		System.out.println("HourlyEmployee : " + Tom);
		System.out.println("SalaryEmployee : " + Sue);	
	}

}
