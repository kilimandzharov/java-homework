package com.kirillmozharov.program;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String[] teams = new String[num];
        HashSet<String> spammersSet = new HashSet<>();
        for (int i = 0; i < num; i++) {
            teams[i] = scanner.next();
        }
        HashSet<String> teamSet = new HashSet<>();
        for (String team : teams) {
            if (teamSet.contains(team)) {
                spammersSet.add(team);
            }
            teamSet.add(team);
        }
        System.out.println(spammersSet.toString());
    }
}
