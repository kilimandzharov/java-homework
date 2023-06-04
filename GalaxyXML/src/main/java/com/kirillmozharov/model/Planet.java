package com.kirillmozharov.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Objects;

public class Planet {
    @JacksonXmlProperty(localName = "Name")
    private String name;
    @JacksonXmlProperty(localName = "Radius")
    private double radius;
    @JacksonXmlProperty(localName = "Period")
    private double period;

    public Planet() {
    }

    public Planet(String name, double radius, double period) {
        this.name = name;
        this.radius = radius;
        this.period = period;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getPeriod() {
        return this.period;
    }

    public void setPeriod(double period) {
        this.period = period;
    }


    @JacksonXmlProperty(localName = "Behaviour")
    public String getBehaviour() {
        return this.name + " " + this.calculateRotationalSpeed();
    }

    private double calculateRotationalSpeed() {
        return (2 * Math.PI * this.radius) / this.period;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return Double.compare(planet.radius, radius) == 0 && Double.compare(planet.period, period) == 0 && Objects.equals(name, planet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, radius, period);
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", radius=" + radius +
                ", period=" + period +
                '}';
    }
}