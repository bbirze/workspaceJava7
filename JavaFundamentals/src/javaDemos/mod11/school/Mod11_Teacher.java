package javaDemos.mod11.school;

import javaDemos.mod11.students.Mod11_Student;

public class Mod11_Teacher {
	Mod11_Student[] myClass;    // association aggregation

	public Mod11_Teacher() {
		myClass = new Mod11_Student[4];
		myClass[0] = new Mod11_Student("Jenny Smith", 'B');
		myClass[1] = new Mod11_Student("Sam Hill", 'D');
		myClass[2] = new Mod11_Student("Notty Brook", 'A');
		myClass[3] = new Mod11_Student("Abraham Knight", 'C');
	}


	protected void printGradePeriod() {
		System.out.println("Grade Period Results");
		for (int i = 0; i< myClass.length; i++) {
			System.out.println("\t" + myClass[i]);
		}
	}
	
	public static void main(String[] args) {
		Mod11_Teacher teach = new Mod11_Teacher();
		
		teach.printGradePeriod();
		teach. printGradePeriod();
	}
} 
