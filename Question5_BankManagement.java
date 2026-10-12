
import java.util.Scanner;

public class Question5_BankManagement {

    static class BankAccount {
        private String name;
        private String accountNumber;
        private double balance;

        BankAccount(String name, String accountNumber, double balance) {
            this.name = name;
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        void deposit(double amount) {
            if (amount <= 0 || !Double.isFinite(amount)) {
                throw new IllegalArgumentException(
                    "Amount must be positive and valid.");
            }

            balance += amount;
            System.out.println("Deposit successful.");
        }

        void withdraw(double amount) {
            if (amount <= 0 || !Double.isFinite(amount)) {
                throw new IllegalArgumentException(
                    "Amount must be positive and valid.");
            }

            if (amount > balance) {
                throw new ArithmeticException("Insufficient balance.");
            }

            balance -= amount;
            System.out.println("Withdrawal successful.");
        }

        void showBalance() {
            System.out.printf("Current balance: %.2f%n", balance);
        }

        void showDetails() {
            System.out.println("\n--- Account Details ---");
            System.out.println("Account Holder: " + name);
            System.out.println("Account Number: " + accountNumber);
            showBalance();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = null;
        int choice = 0;

        do {
            System.out.println("\n--- BANK MANAGEMENT SYSTEM ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Balance Enquiry");
            System.out.println("5. Display Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine().trim());

                switch (choice) {
                    case 1:
                        if (account != null) {
                            System.out.println("Account already exists.");
                            break;
                        }

                        System.out.print("Enter account holder name: ");
                        String name = sc.nextLine().trim();

                        if (name.isEmpty()) {
                            System.out.println("Name cannot be empty.");
                            break;
                        }

                        System.out.print("Enter account number: ");
                        String accNo = sc.nextLine().trim();

                        if (accNo.isEmpty()) {
                            System.out.println(
                                "Account number cannot be empty.");
                            break;
                        }

                        System.out.print("Enter opening balance: ");
                        double openingBalance =
                            Double.parseDouble(sc.nextLine().trim());

                        if (openingBalance < 0
                                || !Double.isFinite(openingBalance)) {
                            throw new IllegalArgumentException(
                                "Invalid opening balance.");
                        }

                        account = new BankAccount(
                            name, accNo, openingBalance);

                        System.out.println("Account created successfully!");
                        break;

                    case 2:
                    case 3:
                        if (account == null) {
                            System.out.println(
                                "Please create an account first.");
                            break;
                        }

                        System.out.print("Enter amount: ");
                        double amount =
                            Double.parseDouble(sc.nextLine().trim());

                        if (choice == 2) {
                            account.deposit(amount);
                        } else {
                            account.withdraw(amount);
                        }
                        break;

                    case 4:
                        if (account == null) {
                            System.out.println(
                                "Please create an account first.");
                        } else {
                            account.showBalance();
                        }
                        break;

                    case 5:
                        if (account == null) {
                            System.out.println(
                                "Please create an account first.");
                        } else {
                            account.showDetails();
                        }
                        break;

                    case 6:
                        System.out.println("Thank you for using our bank!");
                        break;

                    default:
                        System.out.println("Invalid menu choice.");
                }

            } catch (NumberFormatException e) {
                System.out.println(
                    "Invalid input. Please enter a valid number.");
            } catch (IllegalArgumentException | ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 6);

        sc.close();
    }
}
