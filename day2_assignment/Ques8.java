package day2_assignment;

import java.util.Scanner;

public class Ques8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Number :");
		int a = sc.nextInt();
		if(a == 0) {
			System.out.println("ZERO");
		}
		else if(a>0) {
			System.out.println("The number is positive");
		}
		else {
			System.out.println("The number is negative");
		}
		sc.close();
	}

}
