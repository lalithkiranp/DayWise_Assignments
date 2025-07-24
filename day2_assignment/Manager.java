package day2_assignment;

public class Manager extends Employee{
	String dept;
	public Manager(String name,int salary,String dept) {
		super(name,salary);
		this.dept = dept;
			
	}
	public void show() {
		displayInfo();
		System.out.println("department: "+dept);
	}

}
