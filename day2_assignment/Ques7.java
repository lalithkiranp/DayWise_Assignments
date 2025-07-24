package day2_assignment;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Ques7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter amount: ");
		Scanner sc = new Scanner(System.in);
		double amount = sc.nextDouble();
		LocalDate date = LocalDate.now();
		
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		System.out.println("Current Date: " + date.format(dateFormat));
		NumberFormat deFormat = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("Currency: " + deFormat.format(amount));
        sc.close();
	}

}
