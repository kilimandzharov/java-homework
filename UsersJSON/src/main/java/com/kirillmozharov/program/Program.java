package com.kirillmozharov.program;

import com.kirillmozharov.model.Post;
import com.kirillmozharov.model.User;
import com.kirillmozharov.repository.PostRepository;
import com.kirillmozharov.repository.UserRepository;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Program {
    public static void main(String[] args) {
        try {
            UserRepository repository = new UserRepository("https://jsonplaceholder.typicode.com/users");
            PostRepository postRepository = new PostRepository("https://jsonplaceholder.typicode.com/posts");
            for (Map.Entry<User, List<Post>> userListEntry : postRepository.getUserAndHisPosts(repository).entrySet()) {
                StringBuilder resultBuilder = new StringBuilder();
                resultBuilder.append(userListEntry.getKey().getId()).append(": ");
                for (Post post : userListEntry.getValue()) {
                    resultBuilder.append(post.getId()).append(" ");
                }
                System.out.println(resultBuilder);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
