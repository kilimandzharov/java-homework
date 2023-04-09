package com.kirillmozharov.util;

import java.util.Comparator;

public class GenericUtils {
    /**
     * 2. Разработать шаблонный метод, который принимает на вход массив любого типа
     * и возвращает количество уникальных элементов в нем
     * @param arr
     * @return
     * @param <T>
     */
    public static <T> int getSize(T[] arr) {
        return arr.length;
    }

    /**
     * 3. Разработать метод, который принимает на вход массив объектов,
     * содержащих метод сравнения compareTo, и производит сортировку данного массива методом пузырька
     * @param mass
     * @param <T>
     */
    public static <T extends Comparable<T>> void bubbleSort(T[] mass) {
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass.length - i - 1; j++) {
                if (mass[j + 1].compareTo(mass[j]) > 0) {
                    T swap = mass[j];
                    mass[j] = mass[j + 1];
                    mass[j + 1] = swap;
                }
            }
        }
    }

    /**
     * 4. Разработать метод, который принимает на вход массив объектов и объект компаратора,
     * возвращающий наибольшее значение массива
     * @param mass
     * @param comparator
     * @return
     * @param <T>
     */
    public static <T> T max(T[] mass, Comparator<T> comparator) {
        T max = mass[0];
        for (T t : mass) {
            if (comparator.compare(t, max) > 0) {
                max = t;
            }
        }
        return max;
    }

}
