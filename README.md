# Bank-Account-simulation


##  Overview
This project simulates basic **banking operations** using **Java Object-Oriented Programming (OOP)** concepts.  
It demonstrates **classes, inheritance, polymorphism, encapsulation, method overriding, and file handling**.  

Users can create accounts, deposit/withdraw money, apply for loans, repay loans, and check transaction history.  
Data is **saved in a file** so that account details persist across program runs.  

##  Features
- Create **Savings** and **Current** accounts
- Deposit & Withdraw money
- Apply **interest** (only for Savings accounts)
- Apply for **loans** and make repayments
- Check **balance** and loan status
- View **transaction history**
- Show all accounts in the bank
- **Persistent storage** (accounts saved to `accounts.txt`)
- Implements **OOP concepts**:
  - Inheritance
  - Method Overriding
  - Constructor Overloading
  - Encapsulation
  - Polymorphism


##  Project Structure
BankSystem/
│── Account.java # Abstract base class
│── SavingsAccount.java # Inherits Account, adds interest feature
│── CurrentAccount.java # Inherits Account, no interest
│── Bank.java # Manages multiple accounts, file handling
│── Main.java # Menu-driven program
│── accounts.txt # Auto-created for persistent storage


# Technologies Used

Java
VS Code (or any Java IDE)
Terminal / Command Prompt


##  How It Works
1. Run the program from terminal or VS Code.
2. Choose options from the **menu-driven system**:
   - Create account (Savings/Current)
   - Deposit / Withdraw
   - Apply Interest
   - Apply Loan / Repay Loan
   - Check Balance & Loan
   - View Account Details
   - View Transaction History
   - Show all accounts
   - Exit (auto-saves all data)

3. Data is stored in `accounts.txt` so your accounts are available next time.


##  Getting Started

### Prerequisites
- Java JDK 8 or above
- VS Code / IntelliJ IDEA / Eclipse (any IDE)
- Git (for cloning repo)


##  Sample Output
--- Banking System Menu ---
1. Create Account
2. Deposit
3. Withdraw
4. Apply Interest
5. Apply Loan
6. Repay Loan
7. Check Balance
8. Account Details
9. Transaction History
10. Show All Accounts
11. Exit
Enter choice: 1
Enter Account Holder Name: Vishal
Enter Account Number: 101
Enter Initial Balance: 5000
Enter Account Type (1 = Savings, 2 = Current): 1
Account added successfully for 101
