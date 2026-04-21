package service;

import java.io.*;

public class AuthService {

    public void signup(String user, String pass, int pin, int accNo) {
        try {
            FileWriter fw = new FileWriter("users.txt", true);
            fw.write(user + "," + pass + "," + pin + "," + accNo + ",0\n");
            fw.close();

            System.out.println("Account created successfully");

        } catch (Exception e) {
            System.out.println("Signup error");
        }
    }

    public int login(String user, String pass) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("users.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");

                if (d[0].equals(user) && d[1].equals(pass)) {
                    return Integer.parseInt(d[3]); // return accNo
                }
            }

        } catch (Exception e) {
            System.out.println("Login error");
        }

        return -1;
    }

    public boolean checkPin(String user, int pin) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("users.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");

                if (d[0].equals(user) && Integer.parseInt(d[2]) == pin) {
                    return true;
                }
            }

        } catch (Exception e) {}

        return false;
    }
}