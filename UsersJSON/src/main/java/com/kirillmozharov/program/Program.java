package com.kirillmozharov.program;

import com.kirillmozharov.repository.PostRepository;
import com.kirillmozharov.repository.UserRepository;

import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        try {
            UserRepository repository = new UserRepository("https://jsonplaceholder.typicode.com/users");
            PostRepository postRepository = new PostRepository("https://jsonplaceholder.typicode.com/posts");
            System.out.println(postRepository.getPosts());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
