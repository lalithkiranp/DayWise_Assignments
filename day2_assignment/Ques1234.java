package day2_assignment;
import java.util.Scanner;
public class Ques1234 {

	public static void main(String[] args) {
		//Task 1 -  Primitive Data Types
		Scanner sc = new Scanner(System.in);
		System.out.println("Age: ");
		int age = sc.nextInt();
		System.out.println("Height: ");
		double height = sc.nextDouble();
		System.out.println("Weight: ");
		double weight = sc.nextDouble();
		System.out.println("Age: "+age);
		System.out.println("Height: "+height);
		System.out.println("Weight: "+weight);
		
		//Task 2 - Variables
		int studentId = 101;
        String name = "Arun";
        double marks = 89.5;
        char grade = 'A';
        System.out.println("\nStudent ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
        
        //Task 3 - Operators
        System.out.println("Number1: ");
        int a = sc.nextInt();
        System.out.println("Number2: ");
        int b = sc.nextInt();
        System.out.println("Addition: "+(a+b));
        System.out.println("Greater number: "+(a>b?a:b));
        System.out.println("Are both positive? : "+(a>0 && b>0));
        
        //Task 4 - String Concatenation
        sc.nextLine();//If you used something like sc.nextInt() or sc.next() before calling sc.nextLine(), 
        			//the newline (\n) character is left in the input buffer,
        			//so the first sc.nextLine() picks it up as an empty string.
        System.out.println("\nFirst Name: ");
        String fn = sc.nextLine();
        System.out.println("Last Name: ");
        String ln = sc.nextLine();
        System.out.println("Hello, "+fn+" "+ln+" Welcome to the system.");
        
        sc.close();
	}

}
