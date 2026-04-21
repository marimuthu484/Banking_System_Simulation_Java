# FinSafe - Banking System Simulation

Overview

**FinSafe** is a robust console-based banking system simulation developed using Core Java. This application demonstrates fundamental banking operations while emphasizing secure transaction handling and data persistence through file-based storage.

### Key Objectives
- Understanding transaction management systems
- Implementing secure authentication mechanisms
- Learning data persistence without databases
- Practicing modular programming and clean code principles

## Features

### Core Banking Operations
- Account Management
  - Create new accounts with unique account numbers
  - Secure login with username/password authentication
  - PIN-based transaction authorization

- Financial Transactions
  - Deposit funds with instant balance updates
  - Withdraw money with balance validation
  - Inter-account money transfers
  - Real-time balance inquiry

- Transaction History
  - Generate mini statements
  - View complete transaction history

##  Tech Stack

| Technology | Purpose |
|------------|---------|
| **Java 8+** | Core programming language |
| **File I/O** | Data persistence layer |
| **OOP Principles** | Application architecture |
| **Exception Handling** | Error management |
| **Java Time API** | Transaction timestamping |
| **Collections Framework** | Data manipulation |

## Project Structure

```
FinSafe/
│
├── src/
│   └── main/
│       └── java/
│           ├── app/
│           │   ├── BankApp.java          # Main application entry point
│           │   └── BankApp.class
│           │
│           ├── service/
│           │   ├── AuthService.java      # Authentication logic
│           │   ├── AuthService.class
│           │   ├── BankService.java      # Banking operations
│           │   └── BankService.class
│           │
│           ├── util/
│           │   ├── FileUtil.java         # File handling utilities
│           │   └── FileUtil.class
│           │
│           ├── data.txt                  # Transaction records
│           └── users.txt                 # User account data
│
├── README.md
└── .gitignore
```

### Module Descriptions

#### **app/BankApp.java**
- Main class containing the application entry point
- Manages the primary user interface menu
- Coordinates between different services

#### **service/AuthService.java**
- Handles user authentication and authorization
- Manages user registration and login
- Validates credentials against stored data

#### **service/BankService.java**
- Implements core banking operations
- Manages transactions (deposit, withdraw, transfer)
- Maintains transaction history
- Handles balance updates

#### **util/FileUtil.java**
- Provides file I/O operations
- Manages data persistence
- Handles file reading/writing exceptions

## Installation

1. **Clone the repository**
```bash
git clone https://github.com/yourusername/FinSafe.git
cd FinSafe
```

2. **Compile the application**
```bash
javac -d . src/main/java/app/*.java src/main/java/service/*.java src/main/java/util/*.java
```

3. **Run the application**
```bash
java app.BankApp
```

### Getting Started

1. **Launch the Application**
   - Run the main class `BankApp.java`
   - The system will display the main menu

2. **Create an Account**
   ```
   1. Sign Up
   2. Login
   3. Exit
   Choose option: 1
   
   Enter Username: marimuthu
   Enter Password: 2004
   Enter PIN (4 digits): 2004
   Enter Account Number: 2212071
   Account created successfully!
   ```

3. **Login to Your Account**
   ```
   Enter Username: marimuthu
   Enter Password: 2004
   Login Successful!
   ```

4. **Perform Banking Operations**
   ```
   1. Deposit
   2. Withdraw
   3. Transfer
   4. Check Balance
   5. Mini Statement
   6. Logout
   Choose option: 
   ```

## System Architecture

### How It Works
1. **User Registration**: New users sign up by providing username, password, PIN, and account number
2. **Authentication**: Users log in using their username and password credentials
3. **Banking Menu**: After successful login, users can access various banking operations
4. **PIN Verification**: Every transaction requires PIN verification for security
5. **Data Storage**: User credentials are stored in `users.txt` file
6. **Transaction Recording**: All transactions are logged in `data.txt` with timestamps
7. **Balance Updates**: Account balance is automatically updated after each transaction

##  File Structure

## Sample Data

### Test Accounts
| Username | Password | PIN | Account Number | Initial Balance |
|----------|----------|-----|----------------|-----------------|
| marimuthu | 2004 | 2004 | 2212071 | 1000.0 |
| vasanth | 2005 | 2005 | 2212106 | 500.0 |

### Sample Transactions
| Account | Type | Amount | New Balance | Timestamp |
|---------|------|--------|-------------|-----------|
| 2212071 | Credit | 1000.0 | 1000.0 | 2026-04-09T23:18 |
| 2212106 | Debit | 500.0 | 500.0 | 2026-04-09T23:20 |

## Security Features

## Authentication System
- User Registration & Login: All user credentials (username, password, PIN, account number) are securely stored in 'users.txt' file
- Password Protection: Each account is protected with a unique password for login authentication
- File-Based Storage: User authentication data is persisted in text files for simplicity and learning purposes

## Transaction Security
- PIN Verification: All banking operations (deposit, withdraw, transfer) require PIN authentication
- Dual-Layer Security: System implements two levels of security:
  - Level 1: Username/Password for account access
  - Level 2: PIN verification for financial transactions
- Secure Operations: Every sensitive operation is protected by PIN verification to prevent unauthorized transactions
