package com.kirillmozharov.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kirillmozharov.model.Post;
import com.kirillmozharov.model.User;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class PostRepository {
    private ObjectMapper objectMapper = new ObjectMapper();
    private List<Post> posts = new ArrayList<>();

    public PostRepository(String urlSite) throws IOException {
        URL url = new URL(urlSite);
        String json = "";
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream())) {
            byte[] bytes = bufferedInputStream.readAllBytes();
            json = new String(bytes);
        }
        this.posts = objectMapper.readValue(json, new TypeReference<List<Post>>() {
        });
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Map<User, List<Post>> getUserAndHisPosts(UserRepository userRepository) {
        Map<User, List<Post>> result = new HashMap<>();
        for (Post post : this.posts) {
            Optional<User> user = userRepository.findUserById(post.getUserId());
            if (user.isPresent()) {
                List<Post> listPost = result.getOrDefault(user.get(), new ArrayList<>());
                listPost.add(post);
                result.put(user.get(), listPost);
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostRepository that = (PostRepository) o;
        return Objects.equals(objectMapper, that.objectMapper) && Objects.equals(posts, that.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objectMapper, posts);
    }

    @Override
    public String toString() {
        return "PostRepository{" +
                "objectMapper=" + objectMapper +
                ", posts=" + posts +
                '}';
    }
}
