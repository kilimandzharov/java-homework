package com.kirillmozharov.program;

import java.util.*;

public class Program {
    /**
     * Исходные данные
     * В первой строке записано число N — количество сабмитов в последние 10 минут.
     * Следующие N строк содержат названия команд, сабмитивших решения.
     * Названия состоят только из строчных латинских букв и цифр.
     * Результат
     * Выведите все аккаунты, под которыми, по мнению жюри, играет спамер. Порядок вывода не важен.
     * @param args
     */
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
        System.out.println(spammersSet);
    }
}
