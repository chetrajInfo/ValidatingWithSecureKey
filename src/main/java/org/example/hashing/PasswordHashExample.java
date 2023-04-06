package org.example.hashing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * Here's an example of using a hash function for a common use case, which is password storage and verification.
 *
 * In this example, let's assume you have a user registration system for a web application, and you need to
 * store user passwords in a secure manner to protect against unauthorized access. You can use a hash function to
 * generate a fixed-size hash value from the user's password, and store that hash value in your database. When the
 * user tries to log in, you can hash the password they enter during login using the same hash function, and compare
 * the resulting hash value with the stored hash value in the database. If the hash values match, then the password
 * is correct and the user is granted access.
 *
 * Here's a simple example in Java using the MessageDigest class, which is commonly used for hash functions:
 * **/
public class PasswordHashExample {

    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        // Create a MessageDigest instance with the desired hash algorithm
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // Generate the hash value from the password
        byte[] hash = md.digest(password.getBytes());

        // Convert the byte array to hexadecimal string
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        String hashedPassword = hexString.toString();
        return hashedPassword;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "mypassword";

        // Hash the password
        String hashedPassword = hashPassword(password);
        System.out.println("Hashed password: " + hashedPassword);

        // Verify a password
        String passwordToVerify = "mypassword";
        String hashedPasswordToVerify = hashPassword(passwordToVerify);
        if (hashedPassword.equals(hashedPasswordToVerify)) {
            System.out.println("Password is correct.");
        } else {
            System.out.println("Password is incorrect.");
        }
    }
}
/**
 * Note that the hash function (SHA-256 in this case) is used to generate a hash value from the password, which is
 * then stored in the database. When verifying a password, the hash function is used again to generate a hash value
 * from the password entered during login, and this hash value is compared with the stored hash value. If they match,
 * then the password is correct, indicating a successful login attempt.
 * This way, the actual password is never stored in plain text, providing an additional layer of security for user passwords.
 *
 * **/