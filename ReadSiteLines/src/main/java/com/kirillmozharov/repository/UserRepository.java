package com.kirillmozharov.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class UserRepository {
    private String str;

    public UserRepository(String urlSite) throws IOException {
        URL url = new URL(urlSite);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(httpURLConnection.getInputStream()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        }
        this.str = stringBuilder.toString();
    }

    /**
     * 5. Через метод класса найти все вхождения заданной подстроки в поле класса, вернув их в виде
     * списка списков: в списках должны быть позиции(или пустой список) искомой подстроки в строках,
     * находящихся в поле класса. Вхождением называется позиция, где встречается строка в строке
     * @param find
     * @return
     */
    public ArrayList<ArrayList<Integer>> getOccurrences(String find) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (String s : this.str.split("\n")) {
            ArrayList<Integer> occurrences = new ArrayList<>();
            int ind = s.indexOf(find);
            while (ind != -1) {
                occurrences.add(ind);
                ind = s.indexOf(find, ind + 1);
            }
            result.add(occurrences);
        }
        return result;
    }


    /**
     * 6. Найти для каждого символа }, {, ], [ сколько раз он встречается в поле класса,
     * вернув результат в виде HashMap<Character, Integer>
     * @return
     */
    public HashMap<Character, Integer> count() {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        char[] charsToCheck = {'{', '}', '[', ']'};
        for (String s : this.str.split("\n")) {
            for (char c : s.toCharArray()) {
                for (char c1 : charsToCheck) {
                    if (c1 == c) {
                        Integer count = hashMap.get(c) == null ? 0 : hashMap.get(c);
                        hashMap.put(c, count + 1);
                    }
                }
            }
        }
        return hashMap;
    }



    @Override
    public String toString() {
        return "UserRepository{" +
                "str='" + str + '\'' +
                '}';
    }
}
