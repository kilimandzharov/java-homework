package com.kirillmozharov.repository;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class UserRepository {
    private String str;

    public UserRepository(String urlSite) throws IOException {
        URL url = new URL(urlSite);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream())) {
            byte[] bytes = bufferedInputStream.readAllBytes();
            this.str = new String(bytes);
        }
    }


    /**
     * 5. Через метод класса найти все вхождения заданной строки в строке-поля класса, вернув их в виде списка.
     * Вхождением называется позиция, где встречается строка в строке
     *
     * @param find
     * @return
     */
    public ArrayList<Integer> findOccurrences(String find) {
        ArrayList<Integer> occurrences = new ArrayList<>();
        int ind = this.str.indexOf(find);
        while (ind != -1) {
            occurrences.add(ind);
            ind = this.str.indexOf(find, ind + 1);
        }
        return occurrences;
    }


    public HashMap<Character, Integer> count() {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('{', this.findOccurrences("{").size());
        hashMap.put('}', this.findOccurrences("}").size());
        hashMap.put('[', this.findOccurrences("[").size());
        hashMap.put(']', this.findOccurrences("]").size());
        return hashMap;
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "str='" + str + '\'' +
                '}';
    }
}