package com.kirillmozharov.repository;

import com.kirillmozharov.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author mozharovkv
 */
public class StudentsRepository {
    private ArrayList<Student> arrayList = new ArrayList<>();

    public StudentsRepository() {
    }

    public StudentsRepository(String fileName) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            bufferedReader.readLine();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                try {
                    String[] split = line.split(";");
                    String[] array = split[3].split(",");
                    int[] numArray = new int[array.length];
                    for (int i = 0; i < numArray.length; i++) {
                        numArray[i] = Integer.parseInt(array[i]);
                    }
                    Student student = new Student(split[0], split[1], Integer.parseInt(split[2]), numArray);
                    this.arrayList.add(student);
                } catch (RuntimeException ignored) {
                }
            }
        }
    }

    /**
     * 4. Найти всех студентов отличников, то есть студентов, у которых все оценки отличные
     * @return список отличников
     */
    public ArrayList<Student> getExcellentStudents() {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        for (Student student : this.arrayList) {
            if (student.isExcellentStudent()) {
                studentArrayList.add(student);
            }
        }
        return studentArrayList;
    }

    /**
     * 7.Найти всех студентов с наибольшим средним баллом,
     * который может быть не обязательно 5, не используя сортировку
     * @return список самых успешных студентов
     */
    public ArrayList<Student> getMostRatedStudents() {
        double maxRating = this.arrayList.get(0).averageRating();
        for (Student student : this.arrayList) {
            if (student.averageRating() > maxRating) {
                maxRating = student.averageRating();
            }
        }
        ArrayList<Student> studentArrayList = new ArrayList<>();
        for (Student student : this.arrayList) {
            if (student.averageRating() == maxRating) {
                studentArrayList.add(student);
            }
        }
        return studentArrayList;
    }

    /**
     * 5. Найти средний рейтинг каждого студента
     * @return массив средних оценок
     */
    public double[] getAllAverageMarks() {
        double[] averageMarks = new double[this.arrayList.size()];
        for (int i = 0; i < this.arrayList.size(); i++) {
            Student student = this.arrayList.get(i);
            averageMarks[i] = student.averageRating();
        }
        return averageMarks;
    }

    /**
     * 6. Отсортировать студентов по среднему рейтингу
     */
    public void sortByAverageRating() {
        this.arrayList.sort(null);
    }

    public void add(Student student) {
        this.arrayList.add(student);
    }


    public void save(String fileName) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            String header = "Имя;Фамилия;Курс;Оценки";
            bufferedWriter.write(header);
            bufferedWriter.newLine();
            for (Student student : this.arrayList) {
                bufferedWriter.write(student.toCSV());
                bufferedWriter.newLine();
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentsRepository that = (StudentsRepository) o;
        return Objects.equals(arrayList, that.arrayList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(arrayList);
    }

    @Override
    public String toString() {
        return "StudentRepository{" +
                "arrayList=" + arrayList +
                '}';
    }
}
