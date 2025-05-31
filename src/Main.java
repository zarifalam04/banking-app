import java.util.*;
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to Zee Banking");
            System.out.println("1. Login\n2. Create a new account");
            int response = scanner.nextInt();
            scanner.nextLine();
            if (response == 1) {

            } else if(response == 2) {
                createAccount();
                break;
            }
        }
    }

    public static void createAccount() {
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Set your password: ");
        String password = scanner.nextLine();

        int accNum = 100000 + random.nextInt(900000000); // Random 9-digit account number

        Account newAccount = new Account(name, accNum, password, 0);

        System.out.println("✅ Account created successfully!");
        System.out.println("Your Account Number: " + accNum);
    }

}