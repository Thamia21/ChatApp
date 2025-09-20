import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Login class functionality
 * Tests all validation methods and registration/login processes
 */
public class LoginTest {
    private Login login;
    
    @BeforeEach
    public void setUp() {
        login = new Login();
    }
    
    // Username validation tests
    @Test
    public void testUsernameCorrectlyFormatted() {
        // Test data: "kyl_1"
        assertTrue(login.checkUserName("kyl_1"), 
            "Username with underscore and ≤5 characters should be valid");
    }
    
    @Test
    public void testUsernameIncorrectlyFormatted() {
        // Test data: "kyle!!!!!"
        assertFalse(login.checkUserName("kyle!!!!!"), 
            "Username without underscore and >5 characters should be invalid");
    }
    
    @Test
    public void testUsernameNoUnderscore() {
        assertFalse(login.checkUserName("kyle"), 
            "Username without underscore should be invalid");
    }
    
    @Test
    public void testUsernameTooLong() {
        assertFalse(login.checkUserName("kyl_123"), 
            "Username longer than 5 characters should be invalid");
    }
    
    // Password complexity tests
    @Test
    public void testPasswordMeetsComplexity() {
        // Test data: "Ch&&sec@ke99"
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99"), 
            "Password meeting all requirements should be valid");
    }
    
    @Test
    public void testPasswordDoesNotMeetComplexity() {
        // Test data: "password"
        assertFalse(login.checkPasswordComplexity("password"), 
            "Simple password should be invalid");
    }
    
    @Test
    public void testPasswordTooShort() {
        assertFalse(login.checkPasswordComplexity("Ch&1"), 
            "Password shorter than 8 characters should be invalid");
    }
    
    @Test
    public void testPasswordNoCapital() {
        assertFalse(login.checkPasswordComplexity("password123!"), 
            "Password without capital letter should be invalid");
    }
    
    @Test
    public void testPasswordNoNumber() {
        assertFalse(login.checkPasswordComplexity("Password!"), 
            "Password without number should be invalid");
    }
    
    @Test
    public void testPasswordNoSpecialChar() {
        assertFalse(login.checkPasswordComplexity("Password123"), 
            "Password without special character should be invalid");
    }
    
    // Cell phone validation tests
    @Test
    public void testCellPhoneCorrectlyFormatted() {
        // Test data: +27831968976
        assertTrue(login.checkCellPhoneNumber("+278319689"), 
            "Cell phone with international code and ≤10 chars should be valid");
    }
    
    @Test
    public void testCellPhoneIncorrectlyFormatted() {
        // Test data: 083966553
        assertFalse(login.checkCellPhoneNumber("083966553"), 
            "Cell phone without international code should be invalid");
    }
    
    @Test
    public void testCellPhoneTooLong() {
        assertFalse(login.checkCellPhoneNumber("+27831968976123"), 
            "Cell phone longer than 10 characters should be invalid");
    }
    
    // Registration tests
    @Test
    public void testSuccessfulRegistration() {
        String result = login.registerUser("kyl_1", "Ch&&sec@ke99", "+278319689");
        assertEquals("Username successfully captured.", result, 
            "Valid registration should succeed");
    }
    
    @Test
    public void testRegistrationInvalidUsername() {
        String result = login.registerUser("kyle!!!!!", "Ch&&sec@ke99", "+278319689");
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.", result);
    }
    
    @Test
    public void testRegistrationInvalidPassword() {
        String result = login.registerUser("kyl_1", "password", "+278319689");
        assertEquals("Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.", result);
    }
    
    @Test
    public void testRegistrationInvalidCellPhone() {
        String result = login.registerUser("kyl_1", "Ch&&sec@ke99", "083966553");
        assertEquals("Cell phone number incorrectly formatted or does not contain international code, please correct the number and try again.", result);
    }
    
    // Login tests
    @Test
    public void testLoginSuccessful() {
        // First register a user
        login.registerUser("kyl_1", "Ch&&sec@ke99", "+278319689");
        
        // Then test login
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99"), 
            "Valid credentials should allow login");
        assertEquals("Welcome kyl_1, it is great to see you again.", login.returnLoginStatus());
    }
    
    @Test
    public void testLoginFailed() {
        // First register a user
        login.registerUser("kyl_1", "Ch&&sec@ke99", "+278319689");
        
        // Then test login with wrong password
        assertFalse(login.loginUser("kyl_1", "wrongpassword"), 
            "Invalid credentials should fail login");
        assertEquals("Username or password incorrect, please try again.", login.returnLoginStatus());
    }
    
    @Test
    public void testLoginNonExistentUser() {
        assertFalse(login.loginUser("nonexistent", "password"), 
            "Non-existent user should fail login");
        assertEquals("Username or password incorrect, please try again.", login.returnLoginStatus());
    }
    
    // Boolean return tests as specified in requirements
    @Test
    public void testUsernameCorrectlyFormattedReturnsTrue() {
        assertTrue(login.checkUserName("kyl_1"));
    }
    
    @Test
    public void testLoginSuccessfulReturnsTrue() {
        login.registerUser("test_", "Password1!", "+123456789");
        assertTrue(login.loginUser("test_", "Password1!"));
    }
    
    @Test
    public void testLoginFailedReturnsFalse() {
        assertFalse(login.loginUser("fake", "wrong"));
    }
}
