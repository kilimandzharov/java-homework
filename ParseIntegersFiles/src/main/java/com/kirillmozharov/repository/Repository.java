package com.kirillmozharov.repository;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Repository {


    private ArrayList<String> strings = new ArrayList<String>();

    public Repository() {
    }

    public Repository(String filename) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] arr = line.split(";");
                for (String s : arr) {
                    this.strings.add(s);
                }
            }
        }
    }

    public void add(String value) {
        this.strings.add(value);
    }

    public void save(String filename) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename))) {
            for (String line : this.strings) {

            }
            for (int i = 0; i < this.strings.size(); i++) {
                bufferedWriter.write(this.strings.get(i));
                if (i != this.strings.size() - 1) {
                    bufferedWriter.write(";");
                }
            }
        }
    }

    public int findMax() {
        int max = Integer.parseInt(this.strings.get(0));
        for (int i = 0; i < this.strings.size(); i++) {
            int current = Integer.parseInt(this.strings.get(i));
            if (current > max) {
                max = current;
            }
        }
        return max;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "strings=" + strings +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repository that = (Repository) o;
        return Objects.equals(strings, that.strings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(strings);
    }
}

