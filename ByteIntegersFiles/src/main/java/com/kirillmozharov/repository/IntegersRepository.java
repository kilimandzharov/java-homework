package com.kirillmozharov.repository;

import com.kirillmozharov.util.Util;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringJoiner;

public class IntegersRepository {

    private ArrayList<Integer> numbers = new ArrayList<>();

    /**
     * 2.	Создать репозиторий IntegersRepository с конструктором по умолчанию и с конструктором, который
     * принимает на вход путь к файлу, инициализирует список-поле класса значениями целых чисел из указанного файла,
     * считав его побайтово целиком, числа в файле следуют каждый с новой строки, либо же через пробел.
     * Считать изначально файл целиком, а далее произвести его сплитование
     */
    public IntegersRepository() {
    }

    public IntegersRepository(String fileName) throws IOException {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName))) {
            byte[] bytes = bufferedInputStream.readAllBytes();
            String str = new String(bytes);
            String[] rows = str.split("\n");
            for (String row : rows) {
                String nums[] = row.split(" ");
                for (String num : nums) {
                    int result = Integer.parseInt(num);
                    this.numbers.add(result);
                }
            }
        }
    }

    public void addNumber(int num) {
        this.numbers.add(num);
    }

    /**
     * 6. Найти максимальное количество подряд идущих чисел в списке чисел
     * @param list
     * @return
     */
    private int maxInARow(ArrayList<Integer> list) {
        int maxInARow = 1;
        int localMax = 1;
        for (int i = 0; i < list.size() - 1; i++) {
            if (Objects.equals(list.get(i), list.get(i + 1))) {
                localMax += 1;
            } else {
                if (localMax > maxInARow) {
                    maxInARow = localMax;
                }
                localMax = 1;
            }
        }
        if(localMax>maxInARow){
            maxInARow = localMax;
        }
        return maxInARow;
    }

    public int countMaxInARow() {
        return maxInARow(this.numbers);
    }


    /**
     * 7. Удалить из исходного списка все числа с одинаковыми цифрами
     */
    public void deleteSameDigitsNumbers() {
        ArrayList<Integer> toDelete = new ArrayList<>();
        for (Integer num : this.numbers) {
            ArrayList<Integer> digitList = Util.numberToDigitList(num);
            if (maxInARow(digitList) == digitList.size()) {
                toDelete.add(num);
            }
        }
        for (Integer integer : toDelete) {
            this.numbers.remove(integer);
        }
    }

    /**
     * 4. Написать метод сохранения репозитория в указанный файл, открыв его байтовым потоком,
     * путь к которому необходимо передать как параметр метода
     * @param fileName
     * @throws IOException
     */
    public void save(String fileName) throws IOException {
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileName))) {
            StringJoiner stringJoiner = new StringJoiner(" ");
            for (Integer number : this.numbers) {
                stringJoiner.add(Integer.toString(number));
            }
            bufferedOutputStream.write(stringJoiner.toString().getBytes());
        }
    }

    @Override
    public String toString() {
        return "IntegersRepository{" +
                "numbers='" + this.numbers + '\'' +
                '}';
    }
}