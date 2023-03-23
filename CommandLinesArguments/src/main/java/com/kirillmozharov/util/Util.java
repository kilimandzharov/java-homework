package com.kirillmozharov.util;

public class Util {
    public static int[][] fillMatrix(int iterator, int counter, int rowLength,
                              int colLength) {
        int[][] result = new int[rowLength][colLength];
        for (int i = 0; i < result.length; i++) {
            for (int i1 = 0; i1 < result[i].length; i1++) {
                result[i][i1] = counter;
                counter += iterator;
            }
        }
        return result;
    }

}
