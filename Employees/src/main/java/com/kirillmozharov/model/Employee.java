package com.kirillmozharov.model;

import java.util.Objects;
import java.util.StringJoiner;

public class Employee implements Comparable<Employee> {
    private String firstName;
    private String secondName;
    private double rating;
    private int departmentCode;

    public Employee() {
    }

    public Employee(String secondName, String firstName, int departmentCode, double rating) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.rating = rating;
        this.departmentCode = departmentCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(int departmentCode) {
        this.departmentCode = departmentCode;
    }

    public int compareTo(Employee e1){
        if (!this.getSecondName().equals(e1.secondName)){
            return this.secondName.compareTo(e1.secondName);
        }
        return this.firstName.compareTo(e1.firstName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.rating, rating) == 0 && departmentCode == employee.departmentCode && Objects.equals(firstName, employee.firstName) && Objects.equals(secondName, employee.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, rating, departmentCode);
    }

    public String toCSV(){
        StringJoiner stringJoiner = new StringJoiner(";");
        stringJoiner.add(this.secondName).add(this.firstName)
                .add(Integer.toString(this.departmentCode)).add(Double.toString(this.rating));
        return stringJoiner.toString();
    }
    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", rating=" + rating +
                ", departmentCode=" + departmentCode +
                '}';
    }
}
