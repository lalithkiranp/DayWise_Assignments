package cases;

import java.util.Optional;

class User {
	    private Optional<String> email;

	    User(String email) {
	        this.email = Optional.ofNullable(email);
	    }

	    public void printEmail() {
	        email.ifPresentOrElse(
	            e -> System.out.println("Email: " + e),
	            () -> System.out.println("Email not provided")
	        );
	    }
	}

	public class UserProfile {
	    public static void main(String[] args) {
	        User u1 = new User("lalith@example.com");
	        User u2 = new User(null);

	        u1.printEmail();
	        u2.printEmail();
	    }
	}

