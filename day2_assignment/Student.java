package day2_assignment;

public class Student {
	String name;
	int marks;
	public Student(String name,int marks){
		this.name = name;
		this.marks=marks;
	}
	public void displayResult() {
		System.out.println("Student Name: "+name);
		System.out.println("Marks: "+marks);
	}
}
