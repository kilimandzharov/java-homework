package com.kirillmozharov.model;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String secondName;
    private double rating;
    private int departmentCode;

    public Employee() {
    }

    public Employee( String secondName, String firstName, int departmentCode, double rating) {
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
