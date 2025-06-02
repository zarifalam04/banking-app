import java.util.*;
public class Main {

    // Create objects for scanner and random and accounts hashmap
    static HashMap<Integer, Account> accounts = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    // Main method to run program
    public static void main(String[] args) {
        // Opening messages
        while (true) while (true) {
            System.out.println("Welcome to Zee Banking");
            System.out.println("1. Login\n2. Create a new account");

            int response = Integer.parseInt(scanner.nextLine());

            if (response == 1) {
                Account account = checkAccount();

                break;

            } else if (response == 2) {
                createAccount();
                break;
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
    public static Account checkAccount() {
        System.out.println("Account number: ");
        int accNum = Integer.parseInt(scanner.nextLine());
        System.out.println("Password: ");
        String accPass = scanner.nextLine();

        Account account = accounts.get(accNum);
        if (account != null && account.checkPassword(accPass)) {
            System.out.println("✅ Login successful. Welcome, " + account.getAccountHolder());
            System.out.println("1. Chequing Account\n2. Savings Account ");
            return account;
        } else {
            System.out.println("❌ Login failed. Account not found or wrong password.");
            return null;
        }
    }

}