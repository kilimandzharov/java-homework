package com.kirillmozharov.program;

import com.kirillmozharov.model.*;
import com.kirillmozharov.util.Util;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        try {
            /**
             * 	Всех объектов, которые заполнены по умолчанию
             */
            Object[] notDefaultObjects = new Object[]{new HashMap<>(10, 2),
                    new ArrayList<>(), new ArrayList<>(10), new Bug(1)};

            Filter<Object> objectFilter = o -> {
                Class objectClass = o.getClass();
                Object o1 = objectClass.newInstance();
                return !o1.equals(o);
            };

            System.out.println("Не дефолтные объекты" + Arrays.toString(Util.filter(notDefaultObjects, objectFilter)));
            Scanner scanner = new Scanner(System.in);
            Integer[] testArr = new Integer[]{1, 2, -44, 12, 33, -44, 11};
            int fromKeyboard = scanner.nextInt();
            /**
             * Положительных чисел, используя реализацию интерфейса через класс
             */
            Filter<Integer> filterPositive = new FilterPositive();
            /**
             * 	Чисел, равных заданному числу с клавиатуры, используя анонимный внутренний класс
             */
            Filter<Integer> filterOdd = a -> a % 2 != 0;

            /**
             * 	Четных чисел, используя лямбда выражение
             */
            Filter<Integer> filterEqualFromKeyboard = new Filter<Integer>() {
                @Override
                public boolean apply(Integer item) {
                    return item != fromKeyboard;
                }
            };
            System.out.println(Arrays.toString(Util.filter(testArr, filterPositive)));
            System.out.println(Arrays.toString(Util.filter(testArr, filterOdd)));
            System.out.println(Arrays.toString(Util.filter(testArr, filterEqualFromKeyboard)));
            int lengthFromKB = scanner.nextInt();

            /**
             * 	Длина которых больше заданной с клавиатуры. Использовать анонимный внутренний класс
             */
            Filter<String> filterLengthMoreThan = new Filter<String>() {
                @Override
                public boolean apply(String item) {
                    return item.length() > lengthFromKB;
                }
            };
            String[] strings = new String[]{"ehllo", "abc", "some", "wealthy", "123jkj"};


            /**
             * 	Символы, которых отсортированы лексикографически. Использовать сложные лямбда выражения
             */
            Filter<String> filterByLexChars = s -> {
                char[] charsArray = s.toCharArray();
                for (int i = 0; i < charsArray.length - 1; i++) {
                    if (charsArray[i] - charsArray[i + 1] > 0) {
                        return false;
                    }
                }
                return true;
            };

            /**
             * 	Которые являются словами, используя ссылку на нестатический метод
             */
            WordFilter wordFilter = new WordFilter();
            Filter<String> stringFilterIsWord = wordFilter::isWord;


            System.out.println(Arrays.toString(Util.filter(strings, filterByLexChars)));
            System.out.println(Arrays.toString(Util.filter(strings, stringFilterIsWord)));

            /**
             * 	Всех ссылок равных null. Использовать метод Objects.nonNull
             */
            Object[] objects = new Object[]{null, null, new HashMap<>(), new ArrayList<>()};
            System.out.println(Arrays.toString(Util.filter(objects, Objects::nonNull)));

            /**
             * 5.	На массиве разных объектов, реализующих интерфейс Detector с методом detect, возвращает Boolean,
             * оставить только те объекты, для которых detect возвращает true
             */
            Filter<Detector> detectorFilter = x -> x.detect();
            Detector[] detectors = new Detector[]{new Flower("green"), new Flower("blue"),
                    new Flower("yellow"), new Bug(6), new Bug(8)};
            System.out.println(Arrays.toString(Util.filter(detectors, detectorFilter)));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
