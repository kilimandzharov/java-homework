package com.kirillmozharov.program;

import com.kirillmozharov.repository.TextRepository;

public class Program {
    public static void main(String[] args) {
        try {
            TextRepository textRepository = new TextRepository("wiki.txt");
            textRepository.remainOnlyFull().onlyLatinAndSpaces().removeUnpopularWords().save("some.txt");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
