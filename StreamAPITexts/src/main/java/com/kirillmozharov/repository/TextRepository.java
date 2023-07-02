package com.kirillmozharov.repository;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextRepository {
    List<String> strings = new ArrayList<>();

    /**
     * 3.1) Прочитать файл построчно, записав в поле класса список всех строк, которые есть в файле
     * @param path
     * @throws IOException
     */
    public TextRepository(String path) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String string = bufferedReader.readLine();
            strings.add(string);
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
        this.strings = this.strings.stream().map(x -> x.replaceAll("[^A-Za-z ]", " ")).toList();
        return this;
    }

    /**
     * 3.5) Подсчитать количество вхождений различных слов в тескте. Подсчет вести в словаре
     * @return
     */
    public Map<String, Long> countWords() {
        String result = "";
        return this.strings.stream().map(x -> x.split(" ")).flatMap(Stream::of).collect(Collectors.groupingBy(x -> x, Collectors.counting()));
    }

    /**
     * 3.6) Вычислить 10 наиболее популярных и наименее
     * популярных слов (пример вывода: “ 1) -- hello -- 15”), вернув List<List<Map.Entry<String, Long>>>
     * @return
     */
    public List<List<Map.Entry<String, Long>>> top10AndLess10() {
        List<List<Map.Entry<String, Long>>> result = new ArrayList<>();
        Set<Map.Entry<String, Long>> entries = countWords().entrySet();
        List<Map.Entry<String, Long>> top10 = entries.stream().sorted(Map.Entry.comparingByValue()).limit(10).toList();
        List<Map.Entry<String, Long>> less10 = entries.stream().sorted((x, y) -> -x.getValue().compareTo(y.getValue())).limit(10).toList();
        for (int i = 0; i < top10.size(); i++) {
            result.add(List.of(top10.get(i), less10.get(i)));
        }
        return result;
    }

    /**
     * Заменить наименее популярные слова на “PYTHON”
     */
    public TextRepository removeUnpopularWords() {
        List<List<Map.Entry<String, Long>>> info = this.top10AndLess10();
        info.forEach(w -> {
            String less = w.get(1).getKey();
            this.strings = this.strings.stream().map(s -> s.replace(less, "PYTHON")).toList();
        });
        return this;
    }

    /**
     * 3.8) Записать текст в новый файл, разбивая на строки, при этом на каждой строке записывать не более 100 символов и не делить слова
     * @param path
     * @throws IOException
     */
    public void save(String path) throws IOException {
        List<String> newStrings = new ArrayList<>();
        int countChars = 0;
        String acc = "";
        for (String s : this.toString().split(" ")) {
            if (acc.concat(" ").concat(s).length() > 100) {
                newStrings.add(acc);
                acc = s;
            } else {
                acc = acc.concat(" ").concat(s);
            }
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            for (String newString : newStrings) {
                bufferedWriter.write(newString);
            }
        }
    }

    @Override
    public String toString() {
        String result = "";
        return this.strings.stream().collect(Collectors.joining(" "));
    }
}
