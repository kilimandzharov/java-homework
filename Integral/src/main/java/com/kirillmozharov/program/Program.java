package com.kirillmozharov.program;

import com.kirillmozharov.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        /**
         *2. Реализовать возможность выбора пользователю функций(сохранить индексы функций в массив) и
         * знаков операций между ними (сложение или вычитание, сохранить в массив символов),
         * а так же метода подсчета интеграла(целое число).
         * Сохранить выбор пользователя в соответствующие массивы и переменные
         */
        Function[] functions = new Function[]{new Cos(), new Sin(), new ThirdPow(), new SecondPow(), new Ln(), new Function() {
            @Override
            public double f(double x) {
                return Math.exp(x);
            }
        }};
        boolean cycleCondition = true;
        List<Integer> indices = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        List<Character> ops = new ArrayList<>();
        while (cycleCondition) {
            System.out.println("Выберите номер функции для интеграла:");
            System.out.println("1.cos(x)");
            System.out.println("2.sin(x)");
            System.out.println("3.x^3");
            System.out.println("4.x^2");
            System.out.println("5.ln(x)");
            System.out.println("6.e^(x)");
            int funcIndex = scanner.nextInt() - 1;
            indices.add(funcIndex);
            scanner.nextLine();
            System.out.println("Хотите продолжить выбор функции? Дa/Нет");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("нет")) {
                cycleCondition = false;
            } else {
                System.out.println("Выберите операцию между интегралами:");
                System.out.println("+");
                System.out.println("-");
                char op = scanner.nextLine().toCharArray()[0];
                ops.add(op);
            }
        }

        double s = 0;
        for (int i = 0; i < indices.size(); i++) {
            double result = Integral.integralRectangle(functions[indices.get(i)], 0, 1, 100);
            if (i == 0) {
                s += result;
            } else {
                if (ops.get(i - 1) == '-') {
                    s -= result;
                } else if (ops.get(i - 1) == '+') {
                    s += result;
                }
            }
        }
        System.out.println("Сумма интегралов равна: " + s);

    }
}
