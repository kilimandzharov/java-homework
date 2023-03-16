package com.kirillmozharov;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        int result = 0;
        Scanner scanner = new Scanner(System.in);
        int teacherLength = scanner.nextInt();
        HashSet<Integer> teacherSet = new HashSet<>();
        for (int i = 0; i < teacherLength; i++) {
            teacherSet.add(scanner.nextInt());
        }

        int studentLength = scanner.nextInt();
        HashSet<Integer> studentSet = new HashSet<>();
        for (int i = 0; i < studentLength; i++) {
            studentSet.add(scanner.nextInt());
        }

        for (Integer item : studentSet) {
            if(studentSet.contains(item)){
               result++;
            }
        }

        System.out.println(result);
    }
}
