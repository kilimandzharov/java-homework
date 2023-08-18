package com.kirillmozharov.demo.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.kirillmozharov.demo.model.User;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;


public class Repository {
    private ArrayList<User> users = new ArrayList<>();
    private ObjectMapper objectMapper = new ObjectMapper();

    public Repository(String urlSite) throws IOException {
        URL url = new URL(urlSite);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream())) {
            this.users = objectMapper.readValue(bufferedInputStream, new TypeReference<>() {
            });
        }
    }

    public void add(User user) {
        this.users.add(user);
    }

    public void remove(User user){
        this.users.remove(user);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

}
