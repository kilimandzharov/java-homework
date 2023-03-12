package com.kirillmozharov.repository;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class UserRepository {
    private ArrayList<String> arrayOfStrs;

    public UserRepository(String urlSite) throws IOException {
        URL url = new URL(urlSite);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                this.arrayOfStrs.add(line);
            }
        }
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
        for (String s : this.arrayOfStrs) {
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
        for (String s : this.arrayOfStrs) {
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
