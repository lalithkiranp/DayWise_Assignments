package day3_assignment;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	        BankBranch branch = new BankBranch("B001", "Main Branch");
	        Customer c1 = new Customer("C001", "Alice");
	        branch.addCustomer(c1);

	        SavingsAccount sAcc = new SavingsAccount("S001", 5000.0);
	        CurrentAccount cAcc = new CurrentAccount("C001", 2000.0);

	        c1.addAccount(sAcc);
	        c1.addAccount(cAcc);

	        sAcc.deposit(2000);
	        cAcc.withdraw(2500);
	        sAcc.transfer(cAcc, 1000);

	        System.out.println();
	        sAcc.showTransactionHistory();
	        System.out.println();
	        cAcc.showTransactionHistory();
	    }
	}


