import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATM(BankAccount account) {
        bankAccount = account;
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void run() {
        while (true) {
            displayMenu();
            System.out.print("Please select an option (1/2/3/4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (bankAccount.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal of $" + withdrawAmount + " successful.");
                    } else {
                        System.out.println("Insufficient balance or invalid amount for withdrawal.");
                    }
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    if (bankAccount.deposit(depositAmount)) {
                        System.out.println("Deposit of $" + depositAmount + " successful.");
                    } else {
                        System.out.println("Invalid deposit amount.");
                    }
                    break;
                case 3:
                    double balance = bankAccount.checkBalance();
                    System.out.println("Your account balance is $" + balance + ".");
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}

public class Atminterface {
    public static void main(String[] args) {
        double initialBalance = 1000.0; // Set the initial balance for the bank account
        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atmMachine = new ATM(userAccount);
        atmMachine.run();
    }
}
