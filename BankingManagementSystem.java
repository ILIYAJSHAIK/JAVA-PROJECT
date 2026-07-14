import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankingManagementSystem {

    static Scanner sc = new Scanner(System.in);
    static Map<Integer, BankAccount> accounts = new HashMap<>();

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== BANKING MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer Funds");
            System.out.println("5. Balance Inquiry");
            System.out.println("6. Display All Accounts");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;

                case 2:
                    deposit();
                    break;

                case 3:
                    withdraw();
                    break;

                case 4:
                    transferFunds();
                    break;

                case 5:
                    balanceInquiry();
                    break;

                case 6:
                    displayAccounts();
                    break;

                case 7:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }

    static void createAccount() {

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        if (accounts.containsKey(accNo)) {
            System.out.println("Account already exists.");
            return;
        }

        sc.nextLine();

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Deposit: ");
        double amount = sc.nextDouble();

        BankAccount account = new BankAccount(accNo, name, amount);

        accounts.put(accNo, account);

        System.out.println("Account Created Successfully.");
    }

    static void deposit() {

        try {

            System.out.print("Enter Account Number: ");
            int acc = sc.nextInt();

            BankAccount account = accounts.get(acc);

            if (account == null) {
                System.out.println("Account Not Found.");
                return;
            }

            System.out.print("Enter Amount: ");
            double amount = sc.nextDouble();

            account.deposit(amount);

            System.out.println("Deposit Successful.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    static void withdraw() {

        try {

            System.out.print("Enter Account Number: ");
            int acc = sc.nextInt();

            BankAccount account = accounts.get(acc);

            if (account == null) {
                System.out.println("Account Not Found.");
                return;
            }

            System.out.print("Enter Amount: ");
            double amount = sc.nextDouble();

            account.withdraw(amount);

            System.out.println("Withdrawal Successful.");

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

    static void transferFunds() {

        try {

            System.out.print("From Account: ");
            int from = sc.nextInt();

            System.out.print("To Account: ");
            int to = sc.nextInt();

            BankAccount sender = accounts.get(from);
            BankAccount receiver = accounts.get(to);

            if (sender == null || receiver == null) {
                System.out.println("Invalid Account Number.");
                return;
            }

            System.out.print("Enter Amount: ");
            double amount = sc.nextDouble();

            sender.withdraw(amount);
            receiver.deposit(amount);

            System.out.println("Transfer Successful.");

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

    static void balanceInquiry() {

        System.out.print("Enter Account Number: ");
        int acc = sc.nextInt();

        BankAccount account = accounts.get(acc);

        if (account == null) {
            System.out.println("Account Not Found.");
            return;
        }

        System.out.println("\nAccount Number : " + account.getAccountNumber());
        System.out.println("Customer Name : " + account.getCustomerName());
        System.out.println("Balance : ₹" + account.getBalance());

    }

    static void displayAccounts() {

        if (accounts.isEmpty()) {
            System.out.println("No Accounts Found.");
            return;
        }

        System.out.println("\n------ All Accounts ------");

        for (BankAccount account : accounts.values()) {

            System.out.println("--------------------------");
            System.out.println("Account Number : " + account.getAccountNumber());
            System.out.println("Customer Name : " + account.getCustomerName());
            System.out.println("Balance : ₹" + account.getBalance());

        }

    }

}
