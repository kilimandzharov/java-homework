package com.kirillmozharov.model;

import java.util.Objects;

public class Flower implements Detector {
    private String color;

    public Flower() {
    }

    public Flower(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean detect() {
        return color.equals("blue");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flower flower = (Flower) o;
        return Objects.equals(color, flower.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }

    @Override
    public String toString() {
        return "Flower{" +
                "color='" + color + '\'' +
                '}';
    }
}
