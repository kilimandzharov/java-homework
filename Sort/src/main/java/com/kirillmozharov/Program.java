package com.kirillmozharov;

import com.kirillmozharov.model.Pair;
import com.kirillmozharov.model.Triple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /**
         * C: Сортировка пар
         * Программа получает на вход N пар целых чисел (сначала записано число N, затем в N строках по два числа).
         * Создайте список пар, считайте в него данные числа, упорядочите их по первому числу, если первые числа
         * равны, то по второму
         */
       /* ArrayList<Pair<Integer,Integer>> res = new ArrayList<>();
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            res.add(new Pair<>(scanner.nextInt(),scanner.nextInt()));
            scanner.nextLine();
        }
        res.sort(null);
        System.out.println(res);*/

        /**
         * D: Личные дела
         * Однажды, неловкая секретарша перепутала личные дела учащихся. Теперь их снова необходимо упорядочить сначала
         * по классам, а внутри класса по фамилиям. В первой строке входных данных записано число N (1≤N≤105) –
         * количество личных дел. Далее записано N строк, каждая из которых состоит из фамилии учащегося (строка без
         * пробелов) и номера класса (целое число от 1 до 11).
         * Нужно вывести список всех учащихся, сначала выводя номер класса, затем — фамилию учащегося.
         * Список должен быть отсортирован по классу, а затем по фамилии.
         */

       /* ArrayList<Pair<Integer, String>> result = new ArrayList<>();
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String[] nameAndCourse = scanner.nextLine().split(" ");
            result.add(new Pair<>(Integer.parseInt(nameAndCourse[1]),nameAndCourse[0]));
        }
        result.sort(null);
        System.out.println(result);*/

        /**
         * E: Результаты олимпиады
         * В олимпиаде участвовало N человек. Каждый получил определенное количество баллов,
         * при этом оказалось, что у всех участников — разное число баллов.
         * Упорядочите список участников олимпиады в порядке убывания набранных баллов.
         * Программа получает на вход число участников олимпиады N. Далее идет N строк, в каждой строке записана
         * фамилия участника, затем, через пробел, набранное им количество баллов.
         * Выведите список участников (только фамилии) в порядке убывания набранных баллов.
         */

        /*ArrayList<Pair<String, Integer>> result = new ArrayList<>();
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String[] nameAndCourse = scanner.nextLine().split(" ");
            result.add(new Pair<>(nameAndCourse[0], Integer.parseInt(nameAndCourse[1])));
        }

        Comparator<Pair<String,Integer>> comparator = new Comparator<Pair<String, Integer>>() {
            @Override
            public int compare(Pair<String, Integer> o1, Pair<String, Integer> o2) {
              if(o1.getValue().equals(o2.getValue())){
                  return o1.getKey().compareTo(o2.getKey());
              }
              return -o1.getValue().compareTo(o2.getValue());
            }
        };

        result.sort(comparator);
        System.out.println(result);*/

        /**
         F: Сортировка по последней цифре
         Даны N натуральных чисел. Упорядочите их в порядке возрастания последней цифры числа,
         а при равенстве последней цифры — по возрастанию самих чисел. Упорядоченные числа выведите через пробел.
         */
      /*  ArrayList<Integer> result = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            result.add(value);
        }
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Integer l1 = o1 % 10;
                Integer l2 = o2 % 10;
                if (l1.equals(l2)) {
                    return o1.compareTo(o2);
                }
                return l1.compareTo(l2);
            }
        };

        result.sort(comparator);
        System.out.println(result);*/

        /**
         * G: Сортировка по длине слов
         * Даны N строк. Упорядочите их в порядке возрастания длины строки, а при равной длине —
         * в лексикографическом порядке.
         */
       /* ArrayList<String> result = new ArrayList<>();
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String value = scanner.nextLine();
            result.add(value);
        }
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer size1 = o1.length();
                Integer size2 = o2.length();
                if (size1.equals(size2)) {
                    return o1.compareTo(o2);
                }
                return size1.compareTo(size2);
            }
        };
        result.sort(comparator);
        System.out.println(result);
*/
        /**
         * N: Тройки чисел
         * Даны тройки целых чисел. Упорядочите их в лексикографическом порядке.
         * Первая строка входных данных содержит количество N≤105. В следующих N строках записано по три целых числа.
         * Выведите N строк, упорядочив данные тройки чисел в лексикографическом порядке (сначала по первому числу, затем — по второму, при их равенстве — по третьему).
         */

       /* int n = scanner.nextInt();
        ArrayList<Triple<Integer>> result = new ArrayList<>(n);
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String[] value = scanner.nextLine().split(" ");
            result.add(new Triple<>(Integer.parseInt(value[0]), Integer.parseInt(value[1]), Integer.parseInt(value[2])));
        }
        result.sort(null);
        System.out.println(result);*/

    }
}
