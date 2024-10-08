package com.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1PasswordCheck {

    public static void main(String[] args) {
        // Simula l'input dell'utente
        String userInput = "testpassword";
        
        // Password criptata salvata (esempio fornito)
        String encryptedPassword = "f6ce584e7b4ff5253eed4a2ea2b44247";
        
        // Converte l'input dell'utente in SHA-1 e confronta
        try {
            if (encryptedPassword.equals(sha1Hex(userInput))) {
                System.out.println("Success");
            } else {
                System.out.println("Failure");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    // Funzione per convertire una stringa in un hash SHA-1 esadecimale
    public static String sha1Hex(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] result = md.digest(input.getBytes());
        return byteArrayToHexString(result);
    }

    // Funzione per convertire un array di byte in una stringa esadecimale
    public static String byteArrayToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
