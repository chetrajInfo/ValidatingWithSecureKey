package org.example.hashing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CheckingHashing {

    public static String hashingCode(String ssn) throws NoSuchAlgorithmException {
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
        return hashedSsn;

    }
}
