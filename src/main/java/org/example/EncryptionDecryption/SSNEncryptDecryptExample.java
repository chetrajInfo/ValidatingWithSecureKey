package org.example.EncryptionDecryption;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.*;


/**
 * Here's an example of how you can use Java's built-in encryption and decryption functionality
 * to encrypt and decrypt a sensitive value, such as a Social Security Number (SSN), using a symmetric
 * encryption algorithm (e.g., AES):
 * **/
public class SSNEncryptDecryptExample {

    // Method to encrypt SSN using AES
    public static String encryptSSN(String ssn, String secretKey) throws NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        byte[] key = secretKey.getBytes(StandardCharsets.UTF_8);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] encryptedBytes = cipher.doFinal(ssn.getBytes(StandardCharsets.UTF_8));
        return new String(encryptedBytes, StandardCharsets.ISO_8859_1);
    }

    // Method to decrypt SSN using AES
    public static String decryptSSN(String encryptedSSN, String secretKey) throws NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        byte[] key = secretKey.getBytes(StandardCharsets.UTF_8);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] decryptedBytes = cipher.doFinal(encryptedSSN.getBytes(StandardCharsets.ISO_8859_1));
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }

    public static void main(String[] args) {
        try {
            String ssn = "123-45-6789";
            String secretKey = "MySecretKey12345";

            // Encrypt SSN
            String encryptedSSN = encryptSSN(ssn, secretKey);
            System.out.println("Encrypted SSN: " + encryptedSSN);

            // Decrypt SSN
            String decryptedSSN = decryptSSN(encryptedSSN, "MySecretKey12345");
            System.out.println("Decrypted SSN: " + decryptedSSN);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
/**
 * In this example, we use the AES encryption algorithm, which is a symmetric encryption algorithm,
 * to encrypt and decrypt the SSN. The encryptSSN() method takes the SSN and a secret key as input,
 * and returns the encrypted SSN as a string. The decryptSSN() method takes the encrypted SSN and the
 * same secret key as input, and returns the decrypted SSN as a string.
 *
 * Note: It's important to use a strong and secure secret key for encryption and decryption, and to
 * properly manage the key to ensure the confidentiality and integrity of the encrypted data. Also,
 * remember to handle exceptions and error cases properly in your production code.
 *
 * **/