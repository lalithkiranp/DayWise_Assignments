package day2_assignment;

import java.util.Scanner;

public class Ques13 {
	enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.print("Day: ");
        String inp = sc.nextLine().trim().toUpperCase();
        try {
            Day day = Day.valueOf(inp);

           
            switch (day) {
                case MONDAY:
                    System.out.println("Start of the work week!");
                    break;
                case TUESDAY:
                    System.out.println("Keep going, it's only Tuesday.");
                    break;
                case WEDNESDAY:
                    System.out.println("Midweek hustle!");
                    break;
                case THURSDAY:
                    System.out.println("Almost there.");
                    break;
                case FRIDAY:
                    System.out.println("Last working day for many!");
                    break;
                case SATURDAY:
                    System.out.println("Weekend begins. Relax!");
                    break;
                case SUNDAY:
                    System.out.println("Rest well for the week ahead.");
                    break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid day entered. Please enter a valid day in uppercase.");
        }
        sc.close();
	}

}
