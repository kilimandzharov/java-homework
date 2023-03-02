package com.kirillmozharov.util;

import java.util.ArrayList;

public class ArrayListUtil {

    /**
     * Дан массив целых чисел. Выведите все элементы массива с четными индексами.
     * В программе запрещено использовать условную инструкцию для проверки четности индексов.
     * используя ArrayList для накопления элементов, удовлетворяющих условию задачи
     *
     * @param arr
     * @return
     */
    public static ArrayList<Integer> evenIndexes(int[] arr) {
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < arr.length; i += 2) {
            indexes.add(arr[i]);
        }
        return indexes;
    }

    /**
     * 5. evenData
     * Дан массив целых чисел. Выведите все четные элементы массива.
     * Указание:
     * Для проверки четности элемента массива реализовать отдельный метод isEven,
     * который будет проверять, является ли переданный ей элемент четным.
     * - используя ArrayList для накопления элементов, удовлетворяющих условию задачи
     *
     * @param arr
     * @return
     */
    public static ArrayList<Integer> evenData(int[] arr) {
        ArrayList<Integer> evenData = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (NumberUtil.isEven(arr[i])) {
                evenData.add(arr[i]);
            }
        }
        return evenData;
    }

    /**
     * 7. greatPrev
     * Дан массив целых чисел. Выведите все элементы массива, которые больше предыдущего элемента.
     * Используя ArrayList для накопления элементов, удовлетворяющих условию задачи
     *
     * @param arr
     * @return
     */
    public static ArrayList<Integer> greatPrev(int[] arr) {
        ArrayList<Integer> greatPrevArray = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i + 1]) {
                greatPrevArray.add(arr[i]);
            }
        }
        return greatPrevArray;
    }


    /**
     * 11. maxValues
     * Дан массив целых чисел. Выведите все индексы наибольшего значения данного массива
     * - Вернуть результат в виде массива используя ArrayList
     *
     * @param arr
     * @return
     */
    public static ArrayList<Integer> maxValues(int[] arr) {
        ArrayList<Integer> indexes = new ArrayList<>();
        int maxVal = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == maxVal) {
                indexes.add(i);
            }
        }

        return indexes;
    }

    /**
     * 14. nearest
     * Дан массив целых чисел и число x. Найдите в данном массиве элемент,
     * ближайший к x(элемент с минимальной абсолютной разницей с х).
     * Если таких чисел несколько, выведие см. способы реализации.
     * Вернуть все элементы, удовлетворяющие условиям задачи, используя ArrayList
     *
     * @param arr
     * @param x
     * @return
     */
    public static ArrayList<Integer> nearest(int[] arr, int x) {
        ArrayList<Integer> minDiffList = new ArrayList<>();
        int minDiff = Math.abs(x - arr[0]);

        for (int j : arr) {
            if (Math.abs(x - j) < minDiff) {
                minDiff = Math.abs(x - j);
            }
        }

        for (int i : arr) {
            if (Math.abs(x - i) == minDiff) {
                minDiffList.add(i);
            }
        }
        return minDiffList;
    }

    /**
     * 19. delete
     * Дан массив целых чисел и номер элемента в массиве k.
     * Удалите из массива элемент с индексом k.
     * - использовать ArrayList для выполнения операции удаления
     *
     * @param arr
     * @param k
     * @return
     */
    public static ArrayList<Integer> delete(Integer[] arr, int k) {
        ArrayList<Integer> middleList = new ArrayList<>();
        for (int item : arr) {
            middleList.add(item);
        }
        middleList.remove(k);
        return middleList;
    }

    /**
     * 20. insert
     * Дан массив целых чисел, число k и значение C. Необходимо вставить в массив на позицию с индексом k элемент, равный C
     * Решение оформить 2 способами:
     * - использовать вспомогательный массив для хранения элементов
     * - использовать ArrayList для выполнения операции вставки
     *
     * @param arr
     * @param k
     * @param C
     * @return
     */
    public static ArrayList<Integer> insert(int[] arr, int k, int C) {
        ArrayList<Integer> middleList = new ArrayList<>();
        for (int item : arr) {
            middleList.add(item);
        }

        int length = middleList.size();
        middleList.add(middleList.get(length - 1));
        int memoedValue = arr[k];
        middleList.set(k, C);
        for (int i = k + 1; i < middleList.size(); i++) {
            int currentValue = middleList.get(i);
            middleList.set(i, memoedValue);
            memoedValue = currentValue;
        }

        return middleList;
    }

    /**
     * 26. unique
     * Дан массив целых чисел. Выведите те его элементы, которые встречаются в массиве только один раз.
     * Элементы нужно выводить в том порядке, в котором они встречаются в массиве.
     * - использовать ArrayList для накопления элементов, удовлетворяющих условию задачи
     *
     * @param arr
     * @return
     */
    public static ArrayList<Integer> unique(int[] arr) {
        ArrayList<Integer> uniqueVals = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    break;
                }
                uniqueVals.add(arr[i]);
            }
        }

        return uniqueVals;
    }

    /**
     * 27. frequent
     * Дан массив целых чисел. Не изменяя массива определить, какое число в этом массиве встречается чаще всего.
     * Если таких чисел несколько, выведите см. способы реализации.
     * - Вернуть все элементы, удовлетворяющие условиям задачи, используя ArrayList
     *
     * @return
     */
    public static ArrayList<Integer> frequent(int[] array) {
        int maxFreq = 0;

        for (int i = 0; i < array.length; i++) {
            int localFreq = 1;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] == array[i]) {
                    localFreq++;
                }
            }
            if (localFreq > maxFreq) {
                maxFreq = localFreq;
            }
        }

        ArrayList<Integer> maxFreqFreqNums = new ArrayList<>();
        for (int i = 0, k = 0; i < array.length; i++) {
            int localFreq = 1;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] == array[i]) {
                    localFreq++;
                }
            }
            if (localFreq == maxFreq) {
                maxFreqFreqNums.add(array[i]);
            }
        }

        return maxFreqFreqNums;

    }

    /**
     * 28. kBonachi
     * Назовем последовательность чисел последовательностью k-боначчи,
     * если каждый элемент этой последовательности является суммой k предыдущих членов последовательности.
     * В частности, последовательность 2-боначчи
     * является последовательностью Фибоначчи.
     * Более формально, i−й элемент последовательности ki равен 1, если 0≤i≤k−1 и равен сумме k
     * предыдущих членов последовательности ki−1+ki−2+...+ki−k при i≥k.
     * Даны два числа k и n (k≥2,n≥0). Вычислите n-й член последовательности k-боначчи kn.
     * -использовать ArrayList для накопления элементов
     */
    public static int kBonachi(int k, int n) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i < k) {
                numbers.add(1);
            } else {
                int result = 0;
                for (int j = 0; j < k; j++) {
                    result += numbers.get(i - j - 1);
                }
                numbers.add(result);
            }
        }
        return numbers.get(n - 1);
    }

    /**
     * 29. search
     * Дан массив целых чисел и число key. Методом линейного поиска при помощи цикла for найти индекс
     * вхождения числа key в массиве
     * 29.1 search
     * Модернизировать программу таким образом,  чтобы она вернула индексы всех вхождений числа key в массиве.
     * - использовать ArrayList для накопления элементов
     */
    public static ArrayList<Integer> search(int[] arr, int key) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * 39. equalItems
     * Дан массив. Найдите элементы, равные друг другу.
     * - использовать ArrayList для накопления элементов
     */
    public static ArrayList<Integer> equalItems(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int j : arr) {
            int countEqual = 0;
            for (int k : arr) {
                if (j == k) {
                    countEqual++;
                }
            }
            if (countEqual > 1) {
                result.add(j);
            }
        }
        return result;
    }

    /**
     * 40. group
     * Дан массив строковых данных. Сформировать на основании данного массива новый массив,
     * элементами которого будут новые строки, скрепленные между собой по принципу их равности.
     * То есть необходимо реализовать алгоритм группировки строк по их равенству.
     * Пример:
     * Входные данные: [“aa”, “b”, “a”, “bb”, “aa”, “bb”]
     * Выходные данные: [“aa aa”, “b”, “a”, “bb bb”]
     * Указание:
     * Для сравнения строк использовать механизм str1.equals(str2). Оператор == для строк использовать нельзя
     * - использовать ArrayList для накопления элементов
     */
    public static ArrayList<String> group(String[] arr) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> added = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            StringBuilder stringBuilder = new StringBuilder(arr[i]);
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].equals(arr[j]) && !added.contains(arr[j])) {
                    stringBuilder.append(" ").append(arr[j]);
                }
            }
            if (!added.contains(stringBuilder.toString())) {
                result.add(stringBuilder.toString());
            }
            added.add(arr[i]);
        }
        return result;
    }

}
