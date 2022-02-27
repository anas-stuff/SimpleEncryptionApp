package com.anas.simpleencryptionapp.gui;

import java.util.*;

public class Mind {
    private final Random random;
    private final ArrayList<Character> alphabet;
    private ArrayList<Character> shuffleList;
    private String line;
    private final StringBuilder key, encryptedMessage;
    private char[] secretLetters;
    private static Mind instance;

    public static Mind getInstance() {
        if (instance == null) {
            instance = new Mind();
        }
        return instance;
    }

    private Mind() {
        random = new Random();
        shuffleList = new ArrayList<>();
        alphabet = new ArrayList<>();
        key = new StringBuilder();
        encryptedMessage = new StringBuilder();
    }

    public void generateNewKey() {
        if (key.length() > 0)
            key.delete(0, getKey().length());
        shuffleList.clear(); // clear shuffle list
        if (alphabet.size() == 0) {
            getAlphabet();
        }
        shuffleList = new ArrayList<>(alphabet);
        Collections.shuffle(shuffleList);
        shuffleList.forEach(key::append);
    }

    private void getAlphabet() {
        char c = ' ';
        // Get all characters of ascii from 32(Space) to 126(~)
        for (int i = 0; i < 95; i++) {
           alphabet.add(c++);
        }
    }

    public String getKey() {
        return key.toString();
    }

    public void encrypt(String secretMessage) {
        char[] letters = secretMessage.toCharArray();

        if (encryptedMessage.length() > 0)
             encryptedMessage.delete(0, encryptedMessage.length());

        for (char letter : letters) {
            for (int j = 0; j < alphabet.size(); j++) {
                char ch = alphabet.get(j);
                if (letter == ch) {
                    encryptedMessage.append(shuffleList.get(j));
                    break;
                }
            }
        }
        System.out.println("After: " + secretMessage);
        System.out.println("Before: " + encryptedMessage);
    }

    public String getEncryptedSecretMessage() {
        return encryptedMessage.toString();
    }

    public String decrypt(String lablablaaMessage, String key) {
        StringBuilder decryptedMessage = new StringBuilder();
        shuffleList.clear();
        for (char ch : key.toCharArray()) {
            shuffleList.add(ch);
        }
        if (alphabet.size() == 0)
            getAlphabet();

        char[] letters = lablablaaMessage.toCharArray();
        for (char letter : letters) {
            for (int j = 0; j < shuffleList.size(); j++) {
                Character ch = shuffleList.get(j);
                if (letter == ch) {
                    decryptedMessage.append(alphabet.get(j));
                    break;
                }
            }
        }
        return  decryptedMessage.toString();
    }

}
