public class Account {
    private String accountHolder;
    private int accountNumber;
    private String accountPassword;
    private double accountBalance;

    public Account(String accountHolder, int accountNumber, String accountPassword, double accountBalance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.accountPassword = accountPassword;
        this.accountBalance = accountBalance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    // Checks if inputted password equals set password, returns a boolean
    public boolean checkPassword(String inputPassword) {
        return this.accountPassword.equals(inputPassword);
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            accountBalance += amount;
        } else {
            System.out.println("Deposit amount must be greater than zero");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than zero.");
        } else if (accountBalance >= amount) {
            accountBalance -= amount;
        } else {
            System.out.println("Insufficient balance.");
        }
    }

}
