package service;

public interface BankOperations {
    void deposit(int accNo, double amt);
    void withdraw(int accNo, double amt);
    void transfer(int fromAcc, int toAcc, double amt);
}