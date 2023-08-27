package com.kirillmozharov.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kirillmozharov.util.Constants;

import java.io.*;
import java.util.ArrayList;

public class SendUserIdRepository {
    private ObjectMapper objectMapper = new ObjectMapper();
    private ArrayList<Integer> sendList = new ArrayList<>();
    public SendUserIdRepository() {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(Constants.SEND_JSON_FILE_NAME))) {
            this.sendList = objectMapper.readValue(bufferedInputStream, new TypeReference<>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Integer> getSendList() {
        return sendList;
    }

    public boolean isIdPresent(Integer id){
        return this.sendList.contains(id);
    }

    public void save() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Constants.SEND_JSON_FILE_NAME))) {
            objectMapper.writeValue(bufferedWriter, this.sendList);
        } catch (Exception e){

        }
    };
}
