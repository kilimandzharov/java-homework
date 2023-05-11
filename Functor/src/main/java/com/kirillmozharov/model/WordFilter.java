package com.kirillmozharov.model;

public class WordFilter {
    public boolean isWord(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isUpperCase(Character.toUpperCase(c))) {
                return false;
            }
        }
        return true;
    }
}
