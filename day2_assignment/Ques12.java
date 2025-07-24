package day2_assignment;

import java.util.Scanner;

public class Ques12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sums=0;
		Scanner sc = new Scanner(System.in);
		System.out.print("Numbers: ");
		String str = sc.nextLine();
		String[] strArray = str.split(",");
		int []nums= new int[strArray.length];
		for(int i=0;i<strArray.length;i++) {
			nums[i] = Integer.parseInt(strArray[i]);
			sums+=nums[i];
		}
		System.out.println("Average is : "+(sums/strArray.length));
		sc.close();
	}

}
