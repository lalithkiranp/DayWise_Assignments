package day3_assignment;

import java.util.ArrayList;
import java.util.List;

public abstract class Account implements BankOperations {
    protected String accountNumber;
    protected double balance;
    protected List<String> transactionHistory = new ArrayList<>();

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        addTransaction("Account created with balance: ₹" + initialBalance);
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);

    public void transfer(Account target, double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            target.balance += amount;
            addTransaction("Transferred " + amount + " to Account " + target.accountNumber);
            target.addTransaction("Received " + amount + " from Account " + this.accountNumber);
        } else {
            System.out.println("Insufficient balance for transfer.");
        }
    }

    public double checkBalance() {
        return balance;
    }

    protected void addTransaction(String info) {
        transactionHistory.add(info);
    }

    public void showTransactionHistory() {
        System.out.println("Account: " + accountNumber);
        for (String entry : transactionHistory) {
            System.out.println("- " + entry);
        }
    }
}
