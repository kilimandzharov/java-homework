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
        int a = 0;
        int b = 1;
        int n = 100;
        final Function[] functions = new Function[]{Math::cos, Math::sin, x -> Math.pow(x,3), x -> Math.pow(x,3) , Math::log10, Math::exp};
        final List<Integer> indices = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        final List<Character> ops = new ArrayList<>();
        while (true) {
            System.out.println("Выберите операцию между интегралами:");
            System.out.println("+");
            System.out.println("-");
            char op = scanner.nextLine().toCharArray()[0];
            ops.add(op);
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
                break;
            }
        }


        Function f = x -> {
            double result = 0;
            for (int i = 0; i < indices.size(); i++) {
                char sign = ops.get(i);
                double value = functions[indices.get(i)].f(x);
                if (sign == '+') {
                    result += value;
                }
                if (sign == '-') {
                    result -= value;
                }
            }
            return result;
        };
        System.out.println(Integral.integralRectangle(f, 0, 1, 100));
    }
}
