package com.kirillmozharov.repository;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Repository {
    private ArrayList<Integer> integers = new ArrayList<>();

    public Repository() {
    }

    public Repository(String filename) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] arr = line.split(";");
                this.integers.addAll(Arrays.asList(arr));
            }
        }
    }

    public void add(String value) {
        this.integers.add(value);
    }

    public void save(String filename) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < this.integers.size(); i++) {
                bufferedWriter.write(this.integers.get(i));
                if (i != this.integers.size() - 1) {
                    bufferedWriter.write(";");
                }
            }
        }
    }

    public int findMax() {
        int max = Integer.parseInt(this.integers.get(0));
        for (int i = 0; i < this.integers.size(); i++) {
            int current = Integer.parseInt(this.integers.get(i));
            if (current > max) {
                max = current;
            }
        }
        return max;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "strings=" + integers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repository that = (Repository) o;
        return Objects.equals(integers, that.integers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(integers);
    }
}

