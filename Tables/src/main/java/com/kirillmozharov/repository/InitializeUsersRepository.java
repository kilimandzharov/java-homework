package com.kirillmozharov.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.kirillmozharov.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InitializeUsersRepository {
    private ArrayList<User> users;

    public SendUserIdRepository getSendUserIdRepository() {
        return sendUserIdRepository;
    }

    private SendUserIdRepository sendUserIdRepository;
    private ObjectMapper objectMapper = new ObjectMapper();

    {
        this.objectMapper.registerModule(new JavaTimeModule());
    }

    public InitializeUsersRepository(File file) throws IOException {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file))) {
            ArrayList<User> unprocessedUsers = objectMapper.readValue(bufferedInputStream, new TypeReference<>() {
            });
            this.users = unprocessedUsers;
            try {
                this.sendUserIdRepository = new SendUserIdRepository();
                List<User> usersWithIdPresented = unprocessedUsers.stream()
                        .filter(user -> sendUserIdRepository.isIdPresent(user.getId())).toList();
                usersWithIdPresented.forEach(user -> user.setSend(true));
            } catch (Exception ignored){

            }
        }
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
