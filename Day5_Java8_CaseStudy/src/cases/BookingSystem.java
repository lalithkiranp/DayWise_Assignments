package cases;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class BookingSystem {
	    public static void main(String[] args) {
	        LocalDate checkIn = LocalDate.of(2025, 7, 25);
	        LocalDate checkOut = LocalDate.of(2025, 7, 30);

	        Period stay = Period.between(checkIn, checkOut);
	        System.out.println("Stay duration: " + stay.getDays() + " days");

	        LocalDateTime now = LocalDateTime.now();
	        LocalDateTime eventTime = now.plusHours(2);
	        Duration duration = Duration.between(now, eventTime);
	        System.out.println("Event in: " + duration.toMinutes() + " minutes");
	    }
	}


