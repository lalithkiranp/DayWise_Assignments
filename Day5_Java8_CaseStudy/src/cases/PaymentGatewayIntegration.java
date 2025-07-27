package cases;


	interface Payment {
	    void pay(double amount);

	    default void logTransaction(double amount) {
	        System.out.println("Transaction logged for amount: $" + amount);
	    }
	}

	class PayPal implements Payment {
	    public void pay(double amount) {
	        System.out.println("Paid via PayPal: $" + amount);
	        logTransaction(amount);
	    }
	}

	class UPI implements Payment {
	    public void pay(double amount) {
	        System.out.println("Paid via UPI: $" + amount);
	        logTransaction(amount);
	    }
	}

	public class PaymentGatewayIntegration {
	    public static void main(String[] args) {
	        Payment p1 = new PayPal();
	        p1.pay(200);
	        Payment p2 = new UPI();
	        p2.pay(100);
	    }
	}

