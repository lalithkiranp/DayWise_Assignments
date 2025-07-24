package day2_assignment;

import java.util.Scanner;

public class Quest10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("number1: ");
		int num1 = sc.nextInt();
		System.out.print("number2: ");
		int num2 = sc.nextInt();
		int res = 0;
		System.out.println("\n1.Addition\n2.Subtraction\n3.Multiplication\n4.Division");
		System.out.println("Choose one option");
		int ch = sc.nextInt();
		switch(ch) {
		
		case 1: res = num1+num2;
				break;
		case 2: res = num1-num2;
				break;
		case 3: res = num1*num2;
				break;
		case 4: res = num1/num2;
				break;
		default: System.out.println("Invalid Input !");
		}
		System.out.println("Answer: "+res);
		sc.close();
		
	}

}
