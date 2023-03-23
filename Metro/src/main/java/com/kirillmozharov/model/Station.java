package com.kirillmozharov.model;

import java.util.Objects;
import java.util.StringJoiner;

public class Station {
    private String name;
    private int peopleCount;
    private Line line;

    public Station() {
    }

    public Station(String name, int peopleCount, Line line) {
        this.name = name;
        this.peopleCount = peopleCount;
        this.line = line;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return peopleCount == station.peopleCount && Objects.equals(name, station.name) && Objects.equals(line, station.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, peopleCount, line);
    }

    @Override
    public String toString() {
        return "Station{" +
                "name='" + name + '\'' +
                ", peopleCount=" + peopleCount +
                ", line=" + line +
                '}';
    }

    public int compareTo(Station s1){
        return this.getName().compareTo(s1.name);
    }

    public String toCSV(){
        StringJoiner stringJoiner = new StringJoiner(",");
        stringJoiner.add(this.line.toCSV());
        stringJoiner.add(this.name);
        stringJoiner.add(Integer.toString(this.peopleCount));
        return stringJoiner.toString();
    }
}
