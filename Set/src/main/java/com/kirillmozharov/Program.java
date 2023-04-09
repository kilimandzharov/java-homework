package com.kirillmozharov;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        HashSet<Integer> result = new HashSet<Integer>(Arrays.asList(arr));
        System.out.println(result.size());

    }
}
