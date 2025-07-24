package day2_assignment;

import java.util.Scanner;

public class Ques15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Name: ");
		String nm = sc.nextLine();
		
		System.out.println("Salary: ");
		int sal = sc.nextInt();
		sc.nextLine(); //nextInt() doesn't consume the newline (\n) after you press Enter. So nextLine() reads that leftover newline instead of waiting for your actual input.
		
		System.out.println("Department: ");
		String dept = sc.nextLine();
		
		Manager m1 = new Manager(nm,sal,dept);
		m1.show();
		sc.close();
	}

}
