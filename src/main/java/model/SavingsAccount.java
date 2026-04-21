package model;

public class SavingsAccount extends Account {

    public SavingsAccount(int accNo, double balance) {
        super(accNo, balance);
    }

    public void addInterest() {
        balance += balance * 0.04;
    }
}