import javax.swing.*;

/**
 * Main Chat Application class
 * Provides user interface for registration and login functionality
 * 
 * AI Tool Attribution: This code was developed with assistance from Cascade AI
 * Reference: https://apastyle.apa.org/blog/how-to-cite-chatgpt
 */
public class ChatApp {
    private static Login loginSystem = new Login();

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,
                "=== Welcome to ChatApp ===\nYour secure messaging platform",
                "ChatApp", JOptionPane.INFORMATION_MESSAGE);

        boolean running = true;
        while (running) {
            int choice = displayMainMenu();

            switch (choice) {
                case 0: // Register
                    handleRegistration();
                    break;
                case 1: // Login
                    handleLogin();
                    break;
                case 2: // Exit
                default:
                    JOptionPane.showMessageDialog(null,
                            "Thank you for using ChatApp. Goodbye!",
                            "Exit", JOptionPane.INFORMATION_MESSAGE);
                    running = false;
                    break;
            }
        }
    }

    private static int displayMainMenu() {
        String[] options = {"Register new account", "Login to existing account", "Exit"};
        return JOptionPane.showOptionDialog(
                null,
                "=== Main Menu ===\nSelect an option:",
                "ChatApp Menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );
    }

    private static void handleRegistration() {
        String username = JOptionPane.showInputDialog(
                "Enter username (must contain _ and be ≤5 characters):");

        if (username == null) return; // Cancel clicked

        String password = JOptionPane.showInputDialog(
                "Enter password (≥8 chars, capital, number, special char):");

        if (password == null) return;

        String cellPhone = JOptionPane.showInputDialog(
                "Enter cell phone (with international code, ≤10 chars):");

        if (cellPhone == null) return;

        String result = loginSystem.registerUser(username, password, cellPhone);

        JOptionPane.showMessageDialog(null, "Registration Result:\n" + result);

        if (result.equals("Username successfully captured.")) {
            JOptionPane.showMessageDialog(null,
                    "✓ Account created successfully! You can now login.");
        }
    }

    private static void handleLogin() {
        String username = JOptionPane.showInputDialog("Enter username:");
        if (username == null) return;

        String password = JOptionPane.showInputDialog("Enter password:");
        if (password == null) return;

        boolean loginSuccess = loginSystem.loginUser(username, password);
        String loginMessage = loginSystem.returnLoginStatus();

        JOptionPane.showMessageDialog(null, "Login Result:\n" + loginMessage);

        if (loginSuccess) {
            JOptionPane.showMessageDialog(null, "✓ Login successful!");
            showUserDashboard(username);
        } else {
            JOptionPane.showMessageDialog(null,
                    "✗ Login failed. Please check your credentials.");
        }
    }

    private static void showUserDashboard(String username) {
        JOptionPane.showMessageDialog(null,
                "=== User Dashboard ===\n" +
                "Welcome to your ChatApp dashboard, " + username + "!\n\n" +
                "Chat functionality will be implemented in future versions.\n" +
                "For now, you have successfully completed the registration and login process.",
                "Dashboard",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
