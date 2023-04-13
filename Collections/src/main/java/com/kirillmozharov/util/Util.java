package com.kirillmozharov.util;

import java.util.*;

public class Util {
    /**
     * 1. Дан массив целых чисел, записанный с консоли.
     * Найти количество различных элементов в нем, используя множества.
     * Для работы в будущем с коллекциями массив должен быть типа данных Integer
     *
     * @param arr
     * @return
     */
    public static int getDifferentNumbers(Integer[] arr) {
        HashSet<Integer> hashSet = new HashSet<Integer>(Arrays.asList(arr));
        return hashSet.size();
    }

    /**
     * 1. Дан список строк, показать сколько раз каждая строка встречается в списке, далее отсортировать полученный
     * словарь по значению, вывести топ 3 часто встречающихся строк, далее собрать отсортированную коллекцию в новый
     * словарь с учетом сортировки
     *
     * @param arg
     * @return
     */
    public static Map<String, Integer> getStringOccurences(ArrayList<String> arg) {
        Map<String, Integer> result = new HashMap<>();
        for (String s : arg) {
            Integer num = result.getOrDefault(s, 0);
            result.put(s, ++num);
        }
        ArrayList<Map.Entry<String, Integer>> resultList = new ArrayList(result.entrySet());
        Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return Integer.compare(o1.getValue(), o2.getValue());
            }
        };
        resultList.sort(comparator);
        String[] top3Strings = new String[3];

        for (int i = 0; i < 3; i++) {
            top3Strings[i] = resultList.get(resultList.size() - i - 1).getKey();
        }

        LinkedHashMap<String, Integer> res = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : resultList) {
            res.put(stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
        }

        return res;
    }

    /**
     * 2. Дана строка, показать сколько раз каждый символ встречается в ней, далее собрать отсортированную коллекцию
     * в новый словарь с учетом сортировки
     *
     * @return
     */
    public static Map<Character, Integer> getCharOccurences(String arg) {
        Map<Character, Integer> result = new HashMap<>();
        for (Character s : arg.toCharArray()) {
            Integer num = result.getOrDefault(s, 0);
            result.put(s, ++num);
        }
        ArrayList<Map.Entry<Character, Integer>> resultList = new ArrayList(result.entrySet());
        Comparator<Map.Entry<Character, Integer>> comparator = new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return Integer.compare(o1.getValue(), o2.getValue());
            }
        };
        resultList.sort(comparator);
        LinkedHashMap<Character, Integer> res = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> stringIntegerEntry : resultList) {
            res.put(stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
        }
        return res;
    }


}