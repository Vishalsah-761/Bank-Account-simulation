package accounts;

public class CurrentAccount extends Account {
    private static final long serialVersionUID = 1L;

    public CurrentAccount(String accountHolderName, String accountNumber, double initialBalance) {
        super(accountHolderName, accountNumber, initialBalance);
    }

    @Override
    public void applyInterest(double rate) {
        System.out.println("Current accounts do not earn interest.");
    }
}
