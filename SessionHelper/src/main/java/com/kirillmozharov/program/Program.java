package com.kirillmozharov.program;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    /**
     * Исходные данные
     * В первой строке содержится число N — количество записей в списке преподавателя.
     * Затем идет N строк, содержащих список преподавателя, по одной дате в строке.
     * Записаны только года. Каждый год — целое число. Даты в этом списке отсортированы по неубыванию. В следующей после списка строке содержится число M — количество записей в списке студента. Затем также M строк с датами (записаны только года, каждый год — целое число). Этот список не отсортирован. В списке как студента, так и преподавателя даты могут повторяться.
     * Результат
     * Вы должны вывести одно число — количество чисел во втором списке, которые также содержатся в первом.
     * @param args
     */
    public static void main(String[] args) {
        int result = 0;
        Scanner scanner = new Scanner(System.in);
        int teacherLength = scanner.nextInt();
        ArrayList<Integer> teacherList = new ArrayList<>();
        for (int i = 0; i < teacherLength; i++) {
            teacherList.add(scanner.nextInt());
        }

        int studentLength = scanner.nextInt();
        ArrayList<Integer> studentList = new ArrayList<>();
        for (int i = 0; i < studentLength; i++) {
            studentList.add(scanner.nextInt());
        }

        //TODO сделать через retainAll и взять размер
        for (Integer item : studentList) {
            if(teacherList.contains(item)){
               result++;
            }
        }

        System.out.println(result);
    }
}
