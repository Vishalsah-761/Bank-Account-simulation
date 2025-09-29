package accounts;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    protected String accountHolderName;
    protected String accountNumber;
    protected double balance;
    protected double loanBalance;
    protected ArrayList<String> transactionHistory;

    public Account(String accountHolderName, String accountNumber, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = Math.max(0, initialBalance);
        this.loanBalance = 0;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: ₹" + this.balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: ₹" + amount);
            System.out.println("Successfully deposited ₹" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawn: ₹" + amount);
            System.out.println("Successfully withdrawn ₹" + amount);
        } else {
            System.out.println("Invalid withdrawal or insufficient funds.");
        }
    }

    public void applyLoan(double amount) {
        if (amount > 0) {
            loanBalance += amount;
            balance += amount;
            transactionHistory.add("Loan approved: ₹" + amount);
            System.out.println("Loan of ₹" + amount + " approved and credited.");
        } else {
            System.out.println("Loan amount must be positive.");
        }
    }

    public void repayLoan(double amount) {
        if (amount > 0 && amount <= balance) {
            if (loanBalance == 0) {
                System.out.println("No loan to repay.");
                return;
            }
            if (amount > loanBalance) {
                amount = loanBalance;
            }
            balance -= amount;
            loanBalance -= amount;
            transactionHistory.add("Loan repaid: ₹" + amount);
            System.out.println("Loan repaid: ₹" + amount);
        } else {
            System.out.println("Invalid repayment or insufficient funds.");
        }
    }

    public abstract void applyInterest(double rate);

    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public double getLoanBalance() { return loanBalance; }

    public void showDetails() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + this.getClass().getSimpleName());
        System.out.println("Current Balance: ₹" + balance);
        System.out.println("Loan Balance: ₹" + loanBalance);
    }

    public void showTransactionHistory() {
        System.out.println("\n--- Transaction History for " + accountHolderName + " ---");
        for (String record : transactionHistory) {
            System.out.println(record);
        }
    }
}
