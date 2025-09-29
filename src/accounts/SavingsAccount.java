package accounts;

public class SavingsAccount extends Account {
    private static final long serialVersionUID = 1L;

    public SavingsAccount(String accountHolderName, String accountNumber, double initialBalance) {
        super(accountHolderName, accountNumber, initialBalance);
    }

    @Override
    public void applyInterest(double rate) {
        if (rate > 0) {
            double interest = (balance * rate) / 100;
            balance += interest;
            transactionHistory.add("Interest added: ₹" + interest + " at " + rate + "%");
            System.out.println("Interest of ₹" + interest + " applied.");
        } else {
            System.out.println("Invalid interest rate.");
        }
    }
}
