package com.kirillmozharov.repository;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

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
     * @param find
     * @return
     */
    public ArrayList<Integer> findOccurrences(String find) {
        ArrayList<Integer> occurrences = new ArrayList<>();
        String source = this.str;
        while (source.contains(find)) {
            int from = occurrences.size() == 0 ? 0 : occurrences.get(occurrences.size() - 1);
            int index = this.str.indexOf(find, from + 1);
            occurrences.add(index);
            source = source.substring(source.indexOf(find) + find.length());
        }
        return occurrences;
    }


    @Override
    public String toString() {
        return "UserRepository{" +
                "str='" + str + '\'' +
                '}';
    }
}