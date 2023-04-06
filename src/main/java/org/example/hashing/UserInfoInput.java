package org.example.hashing;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class UserInfoInput {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        // Create a Scanner to read input from the console
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();

        System.out.print("Enter monthly salary: ");
        double monthlySalary = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter SSN: ");
        String ssn = scanner.nextLine();

        // Hash the SSN using SHA-256 algorithm
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(ssn.getBytes());

        // Convert the byte array to hexadecimal string
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        String hashedSsn = hexString.toString();

        // Save the information to a text file on the D drive
        String fileName = "D:\\info\\info.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true));
        writer.write("Name: " + name);
        writer.newLine();
        writer.write("Age: " + age);
        writer.newLine();
        writer.write("Email: " + email);
        writer.newLine();
        writer.write("Phone: " + phone);
        writer.newLine();
        writer.write("Monthly Salary: " + monthlySalary);
        writer.newLine();
        writer.write("Hashed SSN: " + hashedSsn);
        writer.newLine();
        writer.newLine();
        writer.close();


        System.out.println("User information has been saved to " + fileName);
    }
}
