package cases;



	class NotificationService {
	    public static void sendEmail(String msg) {
	        System.out.println("Email: " + msg);
	    }

	    public void sendSMS(String msg) {
	        System.out.println("SMS: " + msg);
	    }
	}

	public class NotificationSystem {
	    public static void main(String[] args) {
	        NotificationService service = new NotificationService();

	        // Static method reference
	        Runnable email = () -> NotificationService.sendEmail("Welcome");
	        email.run();

	        // Instance method reference
	        Runnable sms = () -> service.sendSMS("OTP");
	        sms.run();
	    }
	}


