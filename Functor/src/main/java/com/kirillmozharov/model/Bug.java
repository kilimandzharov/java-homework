package com.kirillmozharov.model;

import java.util.Objects;

public class Bug implements Detector {
    private int legs;

    public Bug() {
    }

    public Bug(int legs) {
        this.legs = legs;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    @Override
    public boolean detect() {
        return this.legs == 6;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bug bug = (Bug) o;
        return legs == bug.legs;
    }

    @Override
    public int hashCode() {
        return Objects.hash(legs);
    }

    @Override
    public String toString() {
        return "Bug{" +
                "legs=" + legs +
                '}';
    }
}
