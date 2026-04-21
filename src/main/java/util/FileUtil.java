package util;

import java.io.*;
import java.time.LocalDateTime;

public class FileUtil {

    public static void writeTransaction(int accNo, TransactionType type, double amt, double bal) {
        try {
            FileWriter fw = new FileWriter("data.txt", true);
            fw.write(accNo + "," + type + "," + amt + "," + bal + "," + LocalDateTime.now() + "\n");
            fw.close();
        } catch (Exception e) {
            System.out.println("File error");
        }
    }
}