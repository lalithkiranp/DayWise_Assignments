package day2_assignment;
import java.util.Scanner;
public class Ques56 {

	public static void main(String[] args) {
		//Task - 5
		Scanner sc = new Scanner(System.in);
		System.out.print("Input: ");
		String str = sc.nextLine();
		System.out.println("Original: "+str);
		StringBuilder sb = new  StringBuilder(str);
		sb.reverse();
		System.out.println("Reversed: "+sb.toString());
		
		//Task 6
		int count = 0;
		System.out.print("\nInput: ");
		String inp = sc.nextLine();
		System.out.print("Character: ");
		char ch = sc.next().charAt(0);
		for(int i =0; i<inp.length();i++) {
			if(inp.charAt(i) == ch) {
				count+=1;
			}
		}
		System.out.println("Character "+ch+" appears "+count+" times.");
		sc.close();
	}

}
