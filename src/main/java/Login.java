import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.Map;

/**
 * Login class for chat application registration and authentication
 * This class handles user registration and login functionality with validation
 * 
 * AI Tool Attribution: This code was developed with assistance from Cascade AI
 * Reference: https://apastyle.apa.org/blog/how-to-cite-chatgpt
 */
public class Login {
    private Map<String, UserAccount> users;
    private String lastLoginMessage;
    
    public Login() {
        this.users = new HashMap<>();
        this.lastLoginMessage = "";
    }
    
    /**
     * Checks if username contains an underscore and is no more than 5 characters long
     * @param username The username to validate
     * @return true if username is correctly formatted, false otherwise
     */
    public boolean checkUserName(String username) {
        if (username == null || username.isEmpty()) {
            return false;
        }
        return username.contains("_") && username.length() <= 5;
    }
    
    /**
     * Checks if password meets complexity requirements:
     * - At least 8 characters long
     * - Contains a capital letter
     * - Contains a number
     * - Contains a special character
     * @param password The password to validate
     * @return true if password meets all requirements, false otherwise
     */
    public boolean checkPasswordComplexity(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        
        boolean hasCapital = Pattern.compile("[A-Z]").matcher(password).find();
        boolean hasNumber = Pattern.compile("[0-9]").matcher(password).find();
        boolean hasSpecial = Pattern.compile("[^a-zA-Z0-9]").matcher(password).find();
        
        return hasCapital && hasNumber && hasSpecial;
    }
    
    /**
     * Checks if cell phone number contains international country code and has a valid length
     * @param cellPhone The cell phone number to validate
     * @return true if cell phone is correctly formatted, false otherwise
     */
    public boolean checkCellPhoneNumber(String cellPhone) {
        if (cellPhone == null || cellPhone.isEmpty()) {
            return false;
        }
        
        // Check if it starts with + (international code)
        if (!cellPhone.startsWith("+")) {
            return false;
        }
        
        // Remove all non-digit characters except the leading +
        String digits = cellPhone.substring(1).replaceAll("\\D", "");
        
        // Check if we have between 9-14 digits (after removing the +)
        // This allows for country codes (1-3 digits) + phone number (typically 9-11 digits)
        return digits.length() >= 9 && digits.length() <= 14;
    }
    
    /**
     * Registers a new user if all validation criteria are met
     * @param username The username
     * @param password The password
     * @param cellPhone The cell phone number
     * @return Registration status message
     */
    public String registerUser(String username, String password, String cellPhone) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        
        if (!checkCellPhoneNumber(cellPhone)) {
            return "Cell phone number incorrectly formatted or does not contain international code, please correct the number and try again.";
        }
        
        // Check if user already exists
        if (users.containsKey(username)) {
            return "Username already exists, please choose a different username.";
        }
        
        // Register the user
        users.put(username, new UserAccount(username, password, cellPhone));
        return "Username successfully captured.";
    }
    
    /**
     * Verifies login credentials against stored user data
     * @param username The username
     * @param password The password
     * @return true if login successful, false otherwise
     */
    public boolean loginUser(String username, String password) {
        UserAccount user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            lastLoginMessage = "Welcome " + user.getUsername() + ", it is great to see you again.";
            return true;
        } else {
            lastLoginMessage = "Username or password incorrect, please try again.";
            return false;
        }
    }
    
    /**
     * Returns the appropriate login status message
     * @return Login status message (success or failure)
     */
    public String returnLoginStatus() {
        return lastLoginMessage;
    }
    
    /**
     * Inner class to represent a user account
     */
    private static class UserAccount {
        private String username;
        private String password;
        private String cellPhone;
        
        public UserAccount(String username, String password, String cellPhone) {
            this.username = username;
            this.password = password;
            this.cellPhone = cellPhone;
        }
        
        public String getUsername() { return username; }
        public String getPassword() { return password; }
        public String getCellPhone() { return cellPhone; }
    }
}
