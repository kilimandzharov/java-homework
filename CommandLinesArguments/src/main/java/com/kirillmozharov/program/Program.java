package com.kirillmozharov.program;

import com.kirillmozharov.util.Util;

import java.util.Arrays;

/**
 * 2.	Программа принимает на вход число n в виде аргумента командной строки из массива args. Если число n:
 * -- Равно 1, то программа должна принять из аргументов командной строки число t и вывести на экран
 * таблицу размером t на t, заполненную числами по порядку от единицы и тд
 * -- Равно 2, то программа должна принять из аргументов командной строки число t и число k и вывести
 * на экран таблицу размером t на k, заполненную числами по порядку от единицы и тд c конца таблицы
 * Пример:
 * Ввод
 * 2 3 4
 * Ответ
 * 12 11 10 9
 * 8 7 6 5
 * 4 3 2 1
 */
public class Program {
    public static void main(String[] args) {
        if (args.length > 1) {
            int k;
            int rowLength = 0;
            int colLength = 0;
            int n = Integer.parseInt(args[0]);
            int t = Integer.parseInt(args[1]);
            if (n == 2) {
                if (args.length > 2) {
                    k = Integer.parseInt(args[2]);
                    rowLength = t;
                    colLength = k;
                }
            } else {
                rowLength = t;
                colLength = t;
            }
            //TODO вынести в отдельный класс
            int iterator = n == 2 ? -1 : 1;
            int counter = n == 2 ? rowLength * colLength : 1;
            int[][] result = Util.fillMatrix(iterator, counter, rowLength, colLength);
            System.out.println(Arrays.deepToString(result));
        }
    }
}
