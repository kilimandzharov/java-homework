package com.kirillmozharov.program;

/**
 * 2.	Программа принимает на вход число n в виде аргумента командной строки из массива args. Если число n:
 *  -- Равно 1, то программа должна принять из аргументов командной строки число t и вывести на экран
 * таблицу размером t на t, заполненную числами по порядку от единицы и тд
 *  -- Равно 2, то программа должна принять из аргументов командной строки число t и число k и вывести
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
        int option = Integer.parseInt(args[0]);
        int[] matrixSize = {Integer.parseInt(args[1]), Integer.parseInt(args[2])};
        int iterator = option == 1 ? 1 : -1;
        int count = option == 1 ? 1: matrixSize[0] * matrixSize[1];
        int[][] result = new int[matrixSize[0]][matrixSize[1]];
        for (int[] ints : result) {
            for (int i = 0; i < ints.length; i++) {
                ints[i] = count;
                count += iterator;
            }
        }
        StringBuilder resultBuilder = new StringBuilder();
        for (int[] ints : result) {
            for (int anInt : ints) {
                resultBuilder.append(anInt + " ");
            }
            resultBuilder.append("\n");
        }
        System.out.println(resultBuilder);

    }
}
