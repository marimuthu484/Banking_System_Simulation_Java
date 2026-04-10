package service;

import java.io.*;
import util.FileUtil;

public class BankService {

    public double getBalance(int accNo) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("users.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] d = line.trim().split(",");

                if (Integer.parseInt(d[3]) == accNo) {
                    return Double.parseDouble(d[4]);
                }
            }

        } catch (Exception e) {
            System.out.println("Error reading balance");
        }

        return -1; 
    }

    private void updateBalance(int accNo, double newBal) {
    try {
        BufferedReader br = new BufferedReader(new FileReader("users.txt"));
        StringBuilder content = new StringBuilder();

        String line;

        while ((line = br.readLine()) != null) {
            String[] d = line.trim().split(",");

            if (Integer.parseInt(d[3]) == accNo) {
                content.append(d[0]).append(",")
                       .append(d[1]).append(",")
                       .append(d[2]).append(",")
                       .append(d[3]).append(",")
                       .append(newBal).append("\n");
            } else {
                content.append(line).append("\n");
            }
        }

        br.close();

        FileWriter fw = new FileWriter("users.txt", false);
        fw.write(content.toString());
        fw.close();

    } catch (Exception e) {
        System.out.println("Update error");
    }
}
    public void deposit(int accNo, double amt) {

        double bal = getBalance(accNo);

        if (bal == -1) {
            System.out.println("Account not found");
            return;
        }

        bal += amt;

        updateBalance(accNo, bal);
        FileUtil.writeTransaction(accNo, "Credit", amt, bal);

        System.out.println("Amount deposited");
    }

    public void withdraw(int accNo, double amt) {

        double bal = getBalance(accNo);

        if (bal == -1) {
            System.out.println("Account not found");
            return;
        }

        if (amt > bal) {
            System.out.println("Insufficient balance");
            return;
        }

        bal -= amt;

        updateBalance(accNo, bal);
        FileUtil.writeTransaction(accNo, "Debit", amt, bal);

        System.out.println("Amount withdrawn");
    }

    public void transfer(int fromAcc, int toAcc, double amt) {

        if (fromAcc == toAcc) {
            System.out.println("Same account transfer not allowed");
            return;
        }

        double fromBal = getBalance(fromAcc);
        double toBal = getBalance(toAcc);

        if (fromBal == -1 || toBal == -1) {
            System.out.println("Account not found");
            return;
        }

        if (amt > fromBal) {
            System.out.println("Not enough balance");
            return;
        }

        fromBal -= amt;
        toBal += amt;

        updateBalance(fromAcc, fromBal);
        updateBalance(toAcc, toBal);

        FileUtil.writeTransaction(fromAcc, "Debit(Transfer)", amt, fromBal);
        FileUtil.writeTransaction(toAcc, "Credit(Transfer)", amt, toBal);

        System.out.println("Transfer done");
    }

    public void miniStatement(int accNo) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("data.txt"));
            String line;

            System.out.println("\nDate\tType\tAmount\tBalance");

            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");

                if (Integer.parseInt(d[0]) == accNo) {
                    System.out.println(d[4] + "  " + d[1] + "  " + d[2] + "  " + d[3]);
                }
            }

        } catch (Exception e) {
            System.out.println("Statement error");
        }
    }
}