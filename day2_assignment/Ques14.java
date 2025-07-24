package day2_assignment;

import java.util.Scanner;

public class Ques14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Name: ");
		String nm = sc.nextLine();
		System.out.println("Marks: ");
		int mar = sc.nextInt();
		Student s1 = new Student(nm,mar);
		s1.displayResult();
		sc.close();
	}

}
