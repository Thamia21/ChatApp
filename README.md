# ChatApp - Registration and Login System

A Java-based chat application with secure user registration and authentication functionality.

## Features

- **User Registration**: Create accounts with username, password, and phone number validation
- **User Authentication**: Secure login system with credential verification
- **Input Validation**: Comprehensive validation for all user inputs
- **Unit Testing**: Complete test coverage using JUnit 5

## Requirements

- Java 11 or higher
- Maven 3.6 or higher
- Git (for version control)

## Project Structure

```
ChatApp/
├── src/
│   ├── main/java/
│   │   ├── Login.java          # Core login and registration logic
│   │   └── ChatApp.java        # Main application with user interface
│   └── test/java/
│       └── LoginTest.java      # Comprehensive unit tests
├── pom.xml                     # Maven configuration
└── README.md                   # This file
```

## Validation Rules

### Username
- Must contain an underscore (_)
- Maximum 5 characters long
- Example: `kyl_1` ✓, `kyle!!!!!` ✗

### Password
- Minimum 8 characters
- Must contain at least one capital letter
- Must contain at least one number
- Must contain at least one special character
- Example: `Ch&&sec@ke99` ✓, `password` ✗

### Cell Phone
- Must start with international code (+)
- Maximum 10 characters total
- Example: `+278319689` ✓, `083966553` ✗

## Getting Started

### 1. Clone the Repository
```bash
git clone <your-repository-url>
cd ChatApp
```

### 2. Build the Project
```bash
mvn clean compile
```

### 3. Run Tests
```bash
mvn test
```

### 4. Run the Application
```bash
mvn exec:java -Dexec.mainClass="ChatApp"
```

## Usage

1. **Registration**: Choose option 1 to create a new account
   - Enter username (with underscore, ≤5 chars)
   - Enter password (≥8 chars with capital, number, special char)
   - Enter phone number (with +, ≤10 chars)

2. **Login**: Choose option 2 to access existing account
   - Enter your registered username and password
   - Successful login shows welcome message

## Testing

The application includes comprehensive unit tests covering:

- Username validation (correct/incorrect formatting)
- Password complexity validation
- Cell phone number validation
- Registration process (success/failure scenarios)
- Login authentication (success/failure scenarios)

Run tests with: `mvn test`

## AI Tool Attribution

This code was developed with assistance from Cascade AI, following ethical AI usage guidelines.
Reference: https://apastyle.apa.org/blog/how-to-cite-chatgpt

## Future Enhancements

- Chat messaging functionality
- Message status tracking (sent/received/read)
- User interface improvements
- Database integration
- Security enhancements

## GitHub Setup Instructions

1. Create a GitHub account at https://github.com
2. Apply for GitHub Student Developer Pack at https://education.github.com/pack
3. Create a new repository for this project
4. Initialize Git in your project directory:
   ```bash
   git init
   git add .
   git commit -m "Initial commit: Chat app with registration and login"
   git branch -M main
   git remote add origin <your-repository-url>
   git push -u origin main
   ```

## License

This project is created for educational purposes as part of a programming portfolio.
