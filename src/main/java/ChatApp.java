import java.util.Scanner;

/**
 * Main Chat Application class
 * Provides user interface for registration and login functionality
 * 
 * AI Tool Attribution: This code was developed with assistance from Cascade AI
 * Reference: https://apastyle.apa.org/blog/how-to-cite-chatgpt
 */
public class ChatApp {
    private static Login loginSystem = new Login();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== Welcome to ChatApp ===");
        System.out.println("Your secure messaging platform");
        System.out.println();
        
        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = getMenuChoice();
            
            switch (choice) {
                case 1:
                    handleRegistration();
                    break;
                case 2:
                    handleLogin();
                    break;
                case 3:
                    System.out.println("Thank you for using ChatApp. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
            }
            System.out.println();
        }
        
        scanner.close();
    }
    
    private static void displayMainMenu() {
        System.out.println("=== Main Menu ===");
        System.out.println("1. Register new account");
        System.out.println("2. Login to existing account");
        System.out.println("3. Exit");
        System.out.print("Please select an option (1-3): ");
    }
    
    private static int getMenuChoice() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private static void handleRegistration() {
        System.out.println("\n=== Account Registration ===");
        
        System.out.print("Enter username (must contain _ and be ≤5 characters): ");
        String username = scanner.nextLine().trim();
        
        System.out.print("Enter password (≥8 chars, capital, number, special char): ");
        String password = scanner.nextLine().trim();
        
        System.out.print("Enter cell phone (with international code, ≤10 chars): ");
        String cellPhone = scanner.nextLine().trim();
        
        String result = loginSystem.registerUser(username, password, cellPhone);
        System.out.println("\nRegistration Result:");
        System.out.println(result);
        
        if (result.equals("Username successfully captured.")) {
            System.out.println("✓ Account created successfully! You can now login.");
        }
    }
    
    private static void handleLogin() {
        System.out.println("\n=== Account Login ===");
        
        System.out.print("Enter username: ");
        String username = scanner.nextLine().trim();
        
        System.out.print("Enter password: ");
        String password = scanner.nextLine().trim();
        
        boolean loginSuccess = loginSystem.loginUser(username, password);
        String loginMessage = loginSystem.returnLoginStatus();
        
        System.out.println("\nLogin Result:");
        System.out.println(loginMessage);
        
        if (loginSuccess) {
            System.out.println("✓ Login successful!");
            showUserDashboard(username);
        } else {
            System.out.println("✗ Login failed. Please check your credentials.");
        }
    }
    
    private static void showUserDashboard(String username) {
        System.out.println("\n=== User Dashboard ===");
        System.out.println("Welcome to your ChatApp dashboard, " + username + "!");
        System.out.println("Chat functionality will be implemented in future versions.");
        System.out.println("For now, you have successfully completed the registration and login process.");
        
        System.out.print("\nPress Enter to return to main menu...");
        scanner.nextLine();
    }
}
