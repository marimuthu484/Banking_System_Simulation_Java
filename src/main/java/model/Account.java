package model;

public class Account {
    protected int accNo;
    protected double balance;

    public Account(int accNo, double balance) {
        this.accNo = accNo;
        this.balance = balance;
    }

    public int getAccNo() {
        return accNo;
    }

    public double getBalance() {
        return balance;
    }
}