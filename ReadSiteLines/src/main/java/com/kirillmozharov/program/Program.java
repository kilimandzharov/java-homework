package com.kirillmozharov.program;

import com.kirillmozharov.repository.UserRepository;

import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        try {
            UserRepository repository = new UserRepository("https://jsonplaceholder.typicode.com/users");
            System.out.println(repository.count().toString());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
