package com.kirillmozharov.program;

import com.kirillmozharov.tasks.Tasks;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String[] teams = new String[n];

        for (int i = 0; i < n; i++) {
            teams[i] = scanner.next();
        }

        List<String> spammers = Tasks.findAllSpammerAccounts(teams);
        System.out.println(spammers);
    }
}