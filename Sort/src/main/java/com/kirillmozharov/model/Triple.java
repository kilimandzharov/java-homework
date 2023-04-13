package com.kirillmozharov.model;

import java.util.Objects;

public class Triple<K extends Comparable<K>> implements Comparable<Triple<K>> {
    private K first;
    private K second;
    private K third;

    public Triple(K first, K second, K third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public K getFirst() {
        return first;
    }

    public void setFirst(K first) {
        this.first = first;
    }

    public K getSecond() {
        return second;
    }

    public void setSecond(K second) {
        this.second = second;
    }

    public K getThird() {
        return third;
    }

    public void setThird(K third) {
        this.third = third;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triple<?> triple = (Triple<?>) o;
        return Objects.equals(first, triple.first) && Objects.equals(second, triple.second) && Objects.equals(third, triple.third);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third);
    }

    @Override
    public String toString() {
        return "Triple{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }

    @Override
    public int compareTo(Triple<K> o) {

        if (!this.first.equals(o.first)) {
            return this.first.compareTo(o.first);
        }

        if (!this.second.equals(o.second)) {
            return this.second.compareTo(o.second);
        }

        return this.third.compareTo(o.third);

    }
}
