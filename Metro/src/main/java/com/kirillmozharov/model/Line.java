package com.kirillmozharov.model;

import java.util.Objects;

public class Line {
    private String color;
    private String name;

    public Line() {
    }

    public Line(String color, String name) {
        this.color = color;
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(color, line.color) && Objects.equals(name, line.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, name);
    }

    @Override
    public String toString() {
        return "Line{" +
                "color='" + color + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String toCSV() {
        //TODO доделать
        return null;
    }
}
