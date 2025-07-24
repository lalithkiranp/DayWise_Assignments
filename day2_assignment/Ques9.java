package day2_assignment;

import java.util.Scanner;

public class Ques9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Marks: ");
		int marks = sc.nextInt();
		if(marks > 100) {
			System.out.println("Invalid marks!");
		}
		else if(marks > 90) {
			System.out.println("Grade: A+");
		}
		else if(marks > 80) {
			System.out.println("Grade: A");
		}
		else if(marks > 70) {
			System.out.println("Grade: B");
		}
		else if(marks > 60) {
			System.out.println("Grade: C");
		}
		else if(marks > 40) {
			System.out.println("Grade: D");
		}
		else {
			System.out.println("Failed!");
		}
		sc.close();
	}

}
