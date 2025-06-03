import java.util.*;
public class Main {

    // Create objects for scanner and random and accounts hashmap
    static HashMap<Integer, Account> accounts = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    // Main method to run program
    public static void main(String[] args) {
        // Opening messages
        while (true) {
            System.out.println("Welcome to Zee Banking");
            System.out.println("1. Login\n2. Create a new account");

            int response = Integer.parseInt(scanner.nextLine());

            if (response == 1) {
                Account account = loginAccount();
                boolean loggedIn = true;
                while (loggedIn) {
                    if (account != null) {
                        System.out.println("\n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Logout");
                        int choice = Integer.parseInt(scanner.nextLine());
                        switch (choice) {
                            case 1:
                                checkBalance(account);
                                break;
                            case 2:
                                deposit(account);
                                break;
                            case 3:
                                withdraw(account);
                                break;
                            case 4:
                                System.out.println("You have been logged out");
                                loggedIn = false;
                                break;
                        }
                    } else {
                        System.out.println("Please enter a valid account or make an account");
                        break;
                    }
                }

            } else if (response == 2) {
                createAccount();
            }
        }
    }

    // Method to create an account
    public static void createAccount() {
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Set your password: ");
        String password = scanner.nextLine();

        int accNum = 100000 + random.nextInt(900000000); // Random 9-digit account number

        Account newAccount = new Account(name, accNum, password, 0); // Use Account object to make a new account
        accounts.put(accNum, newAccount); // Put the account in the accounts hashmap

        System.out.println("✅ Account created successfully!");
        System.out.println("Your Account Number: " + accNum);
    }

    // Method to check if an account is registered
    public static Account loginAccount() {
        System.out.println("Account number: ");
        int accNum = Integer.parseInt(scanner.nextLine());
        System.out.println("Password: ");
        String accPass = scanner.nextLine();

        Account account = accounts.get(accNum); // Retrieve the account from hashmap
        if (account != null && account.checkPassword(accPass)) { // If the return value from the hashmap isn't null and the password matches
            System.out.println("✅ Login successful. Welcome, " + account.getAccountHolder());
            return account; // Returns the account object back to main method
        } else {
            System.out.println("❌ Login failed. Account not found or wrong password.");
            return null;
        }
    }

    public static void checkBalance(Account account) {
        System.out.println("Your balance is: $" + account.getAccountBalance());
    }

    public static void deposit(Account account) {
        System.out.println("Enter amount to deposit: ");
        double amount = Double.parseDouble(scanner.nextLine());
        account.deposit(amount);
        System.out.println("✅ Deposit successful.");
    }

    public static void withdraw(Account account) {
        System.out.println("Enter amount to withdraw: ");
        double amount = Double.parseDouble(scanner.nextLine());
        account.withdraw(amount);
        System.out.println("✅ Withdrawal successful.");
    }


}