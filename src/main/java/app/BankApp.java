package app;

import java.util.Scanner;
import service.AuthService;
import service.BankService;

public class BankApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AuthService auth = new AuthService();
        BankService bank = new BankService();

        System.out.println("1 Signup");
        System.out.println("2 Login");

        int ch = sc.nextInt();
        if(ch!=1 && ch!=2) {
            System.out.println("Invalid choice");
            sc.close();
            return;
        }

        if (ch == 1) {
            System.out.print("Username: ");
            String u = sc.next();

            System.out.print("Password: ");
            String p = sc.next();

            System.out.print("Set PIN: ");
            int pin = sc.nextInt();

            System.out.print("Enter Account No: ");
            int acc = sc.nextInt();

            auth.signup(u, p, pin, acc);
            return;
        }

        System.out.print("Username: ");
        String u = sc.next();

        System.out.print("Password: ");
        String p = sc.next();

        int accNo = auth.login(u, p);

        if (accNo == -1) {
            System.out.println("Invalid login");
            return;
        }

        while (true) {
            System.out.println("\n1 Deposit");
            System.out.println("2 Withdraw");
            System.out.println("3 Balance");
            System.out.println("4 Mini Statement");
            System.out.println("5 Transfer");
            System.out.println("6 Exit");

            int c = sc.nextInt();
            if(c==6)break;
            System.out.print("Enter PIN: ");
            int pin = sc.nextInt();
            if (!auth.checkPin(u, pin)) {
                System.out.println("Wrong PIN");
                continue;
            }

            if (c == 1) {
                System.out.print("Amount: ");
                bank.deposit(accNo, sc.nextDouble());
            }
            else if (c == 2) {
                System.out.print("Amount: ");
                bank.withdraw(accNo, sc.nextDouble());
            }
            else if (c == 3) {
                System.out.println("Balance: " + bank.getBalance(accNo));
            }
            else if (c == 4) {
                bank.miniStatement(accNo);
            }
            else if (c == 5) {
                System.out.print("Receiver Acc No: ");
                int toAcc = sc.nextInt();

                System.out.print("Amount: ");
                double amt = sc.nextDouble();

                bank.transfer(accNo, toAcc, amt);
            }
            else break;
        }

        sc.close();
    }
}