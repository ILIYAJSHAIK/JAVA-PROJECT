public class BankAccount {
    private int accountNumber;
    private String customerName;
    private double balance;

    public BankAccount(int accountNumber, String customerName, double balance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0)
            balance += amount;
        else
            throw new IllegalArgumentException("Deposit amount must be positive.");
    }

    public void withdraw(double amount) throws Exception {
        if (amount <= 0)
            throw new Exception("Withdrawal amount must be greater than zero.");

        if (amount > balance)
            throw new Exception("Insufficient Balance.");

        balance -= amount;
    }
}
