import accounts.Account;
import accounts.SavingsAccount;
import accounts.CurrentAccount;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();
        int choice;

        do {
            System.out.println("\n--- Banking System Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Apply Interest");
            System.out.println("5. Apply Loan");
            System.out.println("6. Repay Loan");
            System.out.println("7. Check Balance");
            System.out.println("8. Account Details");
            System.out.println("9. Transaction History");
            System.out.println("10. Show All Accounts");
            System.out.println("11. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Account Holder Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Account Number: ");
                    String accNo = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double bal = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter Account Type (1 = Savings, 2 = Current): ");
                    int type = sc.nextInt();
                    sc.nextLine();

                    Account account;
                    if (type == 1) account = new SavingsAccount(name, accNo, bal);
                    else account = new CurrentAccount(name, accNo, bal);

                    bank.addAccount(account);
                }
                case 2 -> {
                    System.out.print("Enter Account Number: ");
                    Account depAccount = bank.findAccount(sc.nextLine());
                    if (depAccount != null) {
                        System.out.print("Enter amount to deposit: ");
                        depAccount.deposit(sc.nextDouble());
                        sc.nextLine();
                        bank.saveAccounts();
                    } else System.out.println("Account not found.");
                }
                case 3 -> {
                    System.out.print("Enter Account Number: ");
                    Account wdAccount = bank.findAccount(sc.nextLine());
                    if (wdAccount != null) {
                        System.out.print("Enter amount to withdraw: ");
                        wdAccount.withdraw(sc.nextDouble());
                        sc.nextLine();
                        bank.saveAccounts();
                    } else System.out.println("Account not found.");
                }
                case 4 -> {
                    System.out.print("Enter Account Number: ");
                    Account intAccount = bank.findAccount(sc.nextLine());
                    if (intAccount != null) {
                        System.out.print("Enter interest rate (%): ");
                        intAccount.applyInterest(sc.nextDouble());
                        sc.nextLine();
                        bank.saveAccounts();
                    } else System.out.println("Account not found.");
                }
                case 5 -> {
                    System.out.print("Enter Account Number: ");
                    Account loanAcc = bank.findAccount(sc.nextLine());
                    if (loanAcc != null) {
                        System.out.print("Enter loan amount: ");
                        loanAcc.applyLoan(sc.nextDouble());
                        sc.nextLine();
                        bank.saveAccounts();
                    } else System.out.println("Account not found.");
                }
                case 6 -> {
                    System.out.print("Enter Account Number: ");
                    Account repayAcc = bank.findAccount(sc.nextLine());
                    if (repayAcc != null) {
                        System.out.print("Enter repayment amount: ");
                        repayAcc.repayLoan(sc.nextDouble());
                        sc.nextLine();
                        bank.saveAccounts();
                    } else System.out.println("Account not found.");
                }
                case 7 -> {
                    System.out.print("Enter Account Number: ");
                    Account balAcc = bank.findAccount(sc.nextLine());
                    if (balAcc != null) {
                        System.out.println("Current Balance: ₹" + balAcc.getBalance());
                        System.out.println("Loan Balance: ₹" + balAcc.getLoanBalance());
                    } else System.out.println("Account not found.");
                }
                case 8 -> {
                    System.out.print("Enter Account Number: ");
                    Account detAcc = bank.findAccount(sc.nextLine());
                    if (detAcc != null) detAcc.showDetails();
                    else System.out.println("Account not found.");
                }
                case 9 -> {
                    System.out.print("Enter Account Number: ");
                    Account hisAcc = bank.findAccount(sc.nextLine());
                    if (hisAcc != null) hisAcc.showTransactionHistory();
                    else System.out.println("Account not found.");
                }
                case 10 -> bank.showAllAccounts();
                case 11 -> {
                    bank.saveAccounts();
                    System.out.println("Exiting... All data saved. Thank you!");
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 11);

        sc.close();
    }
}
