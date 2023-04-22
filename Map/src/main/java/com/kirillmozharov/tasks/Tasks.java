package com.kirillmozharov.tasks;

import java.util.*;

public class Tasks {
    public Tasks() {
    }

    /**
     * @param teams String[]
     * @return List<Account>
     * @description
     * Map
     * Среди наших знакомых есть известный спамер.
     * В конце каждого контеста он сабмитит свои неправильные решения со скоростью пулемёта.
     * Кроме того, он ещё и ведёт нечестную игру, всегда используя по несколько отладочных аккаунтов.
     * Жюри наконец-то решило дисквалифицировать спамера.
     * Для этого они сначала хотят определить все его отладочные аккаунты.
     * Известно, какие команды сабмитили свои решения в последние 10 минут контеста.
     * Ваша задача — найти все отладочные аккаунты спамера.
     * Жюри считает аккаунтами спамера всех, кто сабмитил решения больше одного раза в последние 10 минут.
     */
    public static List<String> findAllSpammerAccounts(String[] teams) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (String team : teams) {
            hashMap.put(team, hashMap.getOrDefault(team, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            if(entry.getValue() > 1) {
                list.add(entry.getKey());
            }
        }

        return list;
    }

    /**
     * @param teacherList ArrayList<String> int
     * @param studentList ArrayList<String>
     * @return count int
     * @description
     * Map
     * Будем справедливы: сессия ставит задачи не только студентам, но и преподавателям.
     * Любой преподаватель обучает немалое количество студентов, а ведь каждого надо еще и проверить.
     * Поэтому один из преподавателей решил принимать экзамен по истории по такой упрощённой процедуре:
     * студент записывает все известные ему «исторические» даты
     * (достаточно, чтобы он написал только года, но, конечно, мог объяснить, чем замечательна та или иная дата).
     * Преподаватель же держит перед глазами список дат, которые студент должен знать.
     * Для оценки знаний студента преподаватель подсчитывает количество чисел в списке студента,
     * которые также есть в списке преподавателя. В зависимости от полученного числа и выставляется итоговая оценка.
     * Вы должны оказать посильную помощь в автоматизации этого процесса,
     * разработав программу для подсчёта количества совпадений в списках студента и преподавателя.
     */
    public static int helpTeacher(ArrayList<String> teacherList, ArrayList<String> studentList) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        int count = 0;

        for (String i : teacherList) {
            hashMap.put(i, 1);
        }

        for (String j : studentList) {
            hashMap.put(j, hashMap.getOrDefault(j, 0) + 1);

            if(hashMap.get(j) > 1) {
                count++;
            }
        }

        return count;
    }

    /**
     * @param strings List<String>
     * @description
     * Map
     * Дан список строк, показать сколько раз каждая строка встречается в списке.
     * @return HashMap<String, Integer>
     */
    public static HashMap<String, Integer> countRows(List<String> strings) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String string : strings) {
            hashMap.put(string, hashMap.getOrDefault(string, 0) + 1);
        }

        return hashMap;
    }

    /**
     * @description
     * Map
     * Дана строка, показать сколько раз каждый символ встречается в ней.
     * @param string String
     * @return HashMap<String, Integer>
     */
    public static HashMap<String, Integer> countSymbols(String string) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String i : string.split("")) {
            hashMap.put(string, hashMap.getOrDefault(i, 0) + 1);
        }

        return hashMap;
    }

    /**
     * @description
     * Map
     * Решить задачу под номером 40 в файле Arrays.docx, используя словарь.
     * Дан массив строковых данных.
     * Сформировать на основании данного массива новый массив,
     * элементами которого будут новые строки, скрепленные между собой по принципу их равности.
     * То есть необходимо реализовать алгоритм группировки строк по их равенству.
     * Пример:
     * Входные данные: [“aa”, “b”, “a”, “bb”, “aa”, “bb”]
     * Выходные данные: [“aa aa”, “b”, “a”, “bb bb”]
     * Указание:
     * Для сравнения строк использовать механизм str1.equals(str2).
     * Оператор == для строк использовать нельзя.
     */
    public static List<String> joinEqualStrings(String[] strings) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (String string : strings) {
            hashMap.put(string, hashMap.getOrDefault(string, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            StringJoiner stringJoiner = new StringJoiner(" ");
            for (int i = 0; i < entry.getValue(); i++) {
                stringJoiner.add(entry.getKey());
            }

            list.add(String.valueOf(stringJoiner));
        }

        return list;
    }
}