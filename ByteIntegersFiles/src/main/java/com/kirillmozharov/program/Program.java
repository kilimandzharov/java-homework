package com.kirillmozharov.program;

import com.kirillmozharov.repository.IntegersRepository;

import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        try {
            IntegersRepository repository = new IntegersRepository("123.txt");
            System.out.println(repository);
            repository.addNumber(1111);
            repository.deleteSameDigitsNumbers();
            repository.save("output.txt");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
