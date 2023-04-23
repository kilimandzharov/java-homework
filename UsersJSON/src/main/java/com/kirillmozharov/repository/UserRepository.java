package com.kirillmozharov.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kirillmozharov.model.User;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserRepository {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private List<User> users;

    public UserRepository(String urlSite) throws IOException {
        URL url = new URL(urlSite);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream())) {
            this.users = objectMapper.readValue(bufferedInputStream, new TypeReference<>() {
            });
        }
    }

    /**
     * 5.	В репозитории пользователей написать метод,
     * который принимает на вход id и возвращает объекта пользователя, соответствующий переданному id
     * @param id
     * @return
     */
    public Optional<User> findUserById(int id) {
        for (User user : this.users) {
            if (user.getId() == id) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public List<User> getUsers() {
        return users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRepository that = (UserRepository) o;
        return Objects.equals(objectMapper, that.objectMapper) && Objects.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objectMapper, users);
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "objectMapper=" + objectMapper +
                ", users=" + users +
                '}';
    }
}
