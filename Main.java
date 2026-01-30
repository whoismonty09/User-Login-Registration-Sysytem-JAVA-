import java.util.ArrayList;
import java.util.Scanner;

class User {
    String username;
    String password;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    void displayUser() {
        System.out.println("Username: " + username);
    }
}

public class Main {

    static ArrayList<User> users = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\nUser Login & Registration System developed by Monty");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. View Users");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    viewUsers();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);
    }

    static void registerUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        users.add(new User(username, password));
        System.out.println("✅ Registration successful!");
    }

    static void loginUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (User u : users) {
            if (u.username.equals(username) && u.password.equals(password)) {
                System.out.println("✅ Login successful! Welcome " + username);
                return;
            }
        }

        System.out.println("❌ Invalid username or password.");
    }

    static void viewUsers() {
        if (users.isEmpty()) {
            System.out.println("No users registered.");
        } else {
            for (User u : users) {
                u.displayUser();
            }
        }
    }
}
