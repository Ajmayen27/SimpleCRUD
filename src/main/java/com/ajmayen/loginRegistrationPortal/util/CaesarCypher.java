package com.ajmayen.loginRegistrationPortal.util;

public class CaesarCypher {

    private static final int SHIFT = 3; // Shift value for Caesar Cipher (can be any number)

    // Encrypt the text
    public static String encrypt(String text) {
        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                result.append((char) ((character - base + SHIFT) % 26 + base));
            } else {
                result.append(character); // Non-letter characters remain unchanged
            }
        }
        return result.toString();
    }

    // Decrypt the text
    public static String decrypt(String text) {
        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                result.append((char) ((character - base - SHIFT + 26) % 26 + base));
            } else {
                result.append(character); // Non-letter characters remain unchanged
            }
        }
        return result.toString();
    }
}