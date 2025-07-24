package day3_assignment;

public class SavingsAccount extends Account {
    private final double MIN_BALANCE = 500.0;

    public SavingsAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
    }

    public void deposit(double amount) {
        balance += amount;
        addTransaction("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (balance - amount >= MIN_BALANCE) {
            balance -= amount;
            addTransaction("Withdrawn: " + amount);
        } else {
            System.out.println("Withdrawal would breach minimum balance.");
        }
    }
}
