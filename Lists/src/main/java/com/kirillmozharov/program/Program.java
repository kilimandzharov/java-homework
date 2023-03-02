package com.kirillmozharov.program;

import com.kirillmozharov.util.ArrayListUtil;

import java.util.LinkedList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<>();
        System.out.println("Заполните список с клавиатуры");
        for (int i = 0; i < 4 ; i++) {
            list.add(scanner.nextLine());
        }
        list.remove("hello");
        list.remove(0);
        System.out.println(list.indexOf("welcome"));
        System.out.println(list.contains("greetings"));
        System.out.println(list);*/
        String[] s = {"aa", "b", "a", "bb", "aa", "bb"};
        System.out.println(ArrayListUtil.group(s));
    }
}
