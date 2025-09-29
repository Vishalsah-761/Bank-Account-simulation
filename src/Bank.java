import accounts.Account;
import java.io.*;
import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;
    private static final String FILE_NAME = "accounts.txt";

    public Bank() {
        accounts = loadAccounts();
    }

    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Account added successfully for " + account.getAccountNumber());
        saveAccounts();
    }

    public Account findAccount(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) return acc;
        }
        return null;
    }

    public void showAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
        } else {
            System.out.println("\n--- All Accounts ---");
            for (Account acc : accounts) {
                acc.showDetails();
                System.out.println("-------------------");
            }
        }
    }

    public void saveAccounts() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(accounts);
        } catch (IOException e) {
            System.out.println("Error saving accounts: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Account> loadAccounts() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (ArrayList<Account>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading accounts: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
