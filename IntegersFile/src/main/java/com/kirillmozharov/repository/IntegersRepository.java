package com.kirillmozharov.repository;

import com.kirillmozharov.util.Util;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class IntegersRepository {


    private ArrayList<Integer> nums = new ArrayList<Integer>();

    public IntegersRepository() {
    }

    /**
     * 8.	Модифицировать конструктор IntegersRepository таким образом,
     * чтобы он загружал все числа, которые есть в файле,
     * при этом теперь числа могут следовать как через пробел, так и с новой строки
     *
     * @param filename
     * @throws IOException
     */
    public IntegersRepository(String filename) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                String[] splitted = line.split(" ");
                for (String s : splitted) {
                    this.nums.add(Integer.parseInt(s));
                }
            }
        }
    }

    public void add(Integer value) {
        this.nums.add(value);
    }

    public void save(String filename) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < this.nums.size(); i++) {
                bufferedWriter.write(this.nums.get(i).toString());
                bufferedWriter.newLine();
            }
        }
    }


    /**
     * @return
     */
    public int countMaxInARow() {
        return maxInARow(this.nums);
    }

    /**
     * 6. Найти максимальное количество подряд идущих чисел в списке чисел
     *
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
        return maxInARow;
    }

    /**
     * 7. Удалить из исходного списка все числа с одинаковыми цифрами (например, такие как 111, 11, 22, 33)
     */
    public void deleteSameDigitsNumbers() {
        ArrayList<Integer> toDelete = new ArrayList<>();
        for (Integer num : this.nums) {
            ArrayList<Integer> digitList = Util.numberToDigitList(num);
            if (maxInARow(digitList) == digitList.size()) {
                toDelete.add(num);
            }
        }
        for (Integer integer : toDelete) {
            this.nums.remove(integer);
        }
    }

    @Override
    public String toString() {
        return "IntegersRepository{" +
                "nums=" + nums +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegersRepository that = (IntegersRepository) o;
        return Objects.equals(nums, that.nums);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nums);
    }
}

