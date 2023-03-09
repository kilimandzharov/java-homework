package com.kirillmozharov.program;

import com.kirillmozharov.repository.IntegersRepository;

import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        try {
            IntegersRepository repository = new IntegersRepository("input.txt");
            repository.addNumber(1111);
            repository.deleteSameDigitsNumbers();
            repository.save("output.txt");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
