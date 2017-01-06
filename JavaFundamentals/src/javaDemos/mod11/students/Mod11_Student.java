package javaDemos.mod11.students;

public class Mod11_Student {
	String name;
	char grade;
	
	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	public String toString() {
		return "Student: " + name + " earned the grade " + grade;
	}
	
	public Mod11_Student(String name, char grade) {
		this.name = name;
		this.grade = grade;
	}

}
