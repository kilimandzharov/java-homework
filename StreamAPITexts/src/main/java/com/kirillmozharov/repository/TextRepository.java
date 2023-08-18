package com.kirillmozharov.repository;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextRepository {
    private List<String> strings = new ArrayList<>();

    /**
     * 3.1) Прочитать файл построчно, записав в поле класса список всех строк, которые есть в файле
     *
     * @param path
     * @throws IOException
     */
    public TextRepository(String path) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                strings.add(line);
            }
        }
    }

    /**
     * Оставить в списке только непустые строки
     */
    public TextRepository remainOnlyFull() {
        this.strings = this.strings.stream().filter(x -> x.length() > 0).toList();
        return this;
    }

    /**
     * В списке оставить только латинские буквы и пробелы. Прочие символы удалить
     */
    public TextRepository onlyLatinAndSpaces() {
        this.strings = Arrays.stream(this.strings.stream().map(x -> x.replaceAll("[^A-Za-z ]", ""))
                .collect(Collectors.joining(" ")).split(" ")).filter(s -> s.length() > 0).toList();
        return this;
    }

    /**
     * 3.5) Подсчитать количество вхождений различных слов в тескте. Подсчет вести в словаре
     *
     * @return
     */
    public Map<String, Long> countWords() {
        return this.strings.stream().map(x -> x.split(" ")).flatMap(Stream::of)
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
    }

    /**
     * 3.6) Вычислить 10 наиболее популярных и наименее
     * популярных слов (пример вывода: “ 1) -- hello -- 15”), вернув List<List<Map.Entry<String, Long>>>
     *
     * @return
     */
    public List<List<Map.Entry<String, Long>>> top10AndLess10() {
        Set<Map.Entry<String, Long>> entries = countWords().entrySet();
        List<Map.Entry<String, Long>> top10 = entries.stream().sorted(Map.Entry.comparingByValue()).limit(10).toList();
        List<Map.Entry<String, Long>> less10 = entries.stream().sorted((x, y) -> -x.getValue().compareTo(y.getValue())).limit(10).toList();
        return List.of(top10, less10);
    }

    /**
     * Заменить наименее популярные слова на “PYTHON”
     */
    //TODO
    public TextRepository removeUnpopularWords() {
        List<String> less = this.top10AndLess10().get(1).stream().map(Map.Entry::getKey).toList();
        this.strings = Arrays.stream(Arrays.stream(String.join("\n",this.strings).split(" ")).map(s -> {
            if(less.contains(s)){
                return "PYTHON";
            }
            return s;
        }).collect(Collectors.joining(" ")).split("\n")).toList();
        return this;
    }

    /**
     * 3.8) Записать текст в новый файл, разбивая на строки, при этом на каждой строке записывать не более 100 символов и не делить слова
     *
     * @param path
     * @throws IOException
     */
    //TODO дописать
    public void save(String path) throws IOException {
        List<String> newStrings = new ArrayList<>();
        String acc = String.join(" ", this.strings);
        while (!acc.equals("")) {
            if (acc.length() > 100) {
                if (acc.charAt(99) == ' ') {
                    newStrings.add(acc.substring(0, 99));
                    acc = acc.substring(100);
                } else if (acc.charAt(100) == ' ') {
                    newStrings.add(acc.substring(0, 100));
                    acc = acc.substring(101);
                } else {
                    String substr = acc.substring(0, 100);
                    int lastSpace = substr.lastIndexOf(" ");
                    newStrings.add(substr.substring(0, lastSpace));
                    acc = acc.substring(lastSpace + 1);
                }
            } else if (acc.length() > 0) {
                newStrings.add(acc);
                acc = "";
            }
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            for (String newString : newStrings) {
                bufferedWriter.write(newString);
                bufferedWriter.write("\n");
            }
        }
    }

    @Override
    public String toString() {
        return String.join(" ", this.strings);
    }
}
