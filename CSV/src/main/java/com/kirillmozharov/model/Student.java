package com.kirillmozharov.model;

import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * @author mozharovkv
 */
public class Student implements Comparable<Student> {
    String name;
    String surname;
    int course;
    int[] marks;

    public Student() {
    }

    public Student(String name, String surname, int course, int[] marks) {
        this.name = name;
        this.surname = surname;
        this.course = course;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    /**
     * Метод, который выясняет, является ли студент круглым отличником
     * @return boolean
     */
    public boolean isExcellentStudent() {
        boolean isExcellentStudent = true;
        for (int mark : this.marks) {
            if (mark != 5) {
                isExcellentStudent = false;
            }
        }
        return isExcellentStudent;
    }

    /**
     * Метод, который возвращает среднюю оценку студента
     * @return double
     */
    public double averageRating() {
        double summaryRating = 0;
        for (int mark : this.marks) {
            summaryRating += mark;
        }
        return summaryRating / this.marks.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course && Objects.equals(name, student.name) && Objects.equals(surname, student.surname) && Arrays.equals(marks, student.marks);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, surname, course);
        result = 31 * result + Arrays.hashCode(marks);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", course=" + course +
                ", marks=" + Arrays.toString(marks) +
                '}';
    }


    public String toCSV() {
        StringJoiner marksString = new StringJoiner(",");
        for (int mark : this.marks) {
            marksString.add(Integer.toString(mark));
        }
        return this.name + ";" + this.surname + ";"
                + this.course + ";" + marksString;
    }

    @Override
    public int compareTo(Student o) {
        if (this.averageRating() > o.averageRating()) {
            return 1;
        } else if (this.averageRating() < o.averageRating()) {
            return -1;
        }
        return 0;
    }
}
