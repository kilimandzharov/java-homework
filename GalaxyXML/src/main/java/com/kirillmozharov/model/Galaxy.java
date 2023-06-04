package com.kirillmozharov.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

public class Galaxy {

    @JacksonXmlProperty(localName = "Name")
    private String name;
    @JacksonXmlElementWrapper(localName = "Planets")
    @JacksonXmlProperty(localName = "Planet")
    private ArrayList<Planet> planets = new ArrayList<>();

    public Galaxy() {
    }

    public Galaxy(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<Planet> add(Planet planet) {
        if (this.planets.contains(planet)) {
            return Optional.empty();
        }
        this.planets.add(planet);
        return Optional.of(planet);
    }

    public String behavior() {
        String commonBehavior = "";
        this.planets.forEach(planet -> commonBehavior.concat(planet.getBehaviour() + " "));
        return commonBehavior;
    }

    public int search(Planet planet) {
        return this.planets.indexOf(planet);
    }

    public Optional<Planet> search(String name) {
        Optional<Planet> found = this.planets.stream().filter(planet -> planet.getName().equals(name)).findFirst();
        return found;
    }

    public boolean remove(Planet planet) {
        return this.planets.remove(planet);
    }

    public Optional<Planet> remove(String name) {
        Optional<Planet> found = this.planets.stream().filter(planet -> planet.getName().equals(name)).findFirst();
        return found;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Galaxy galaxy = (Galaxy) o;
        return Objects.equals(name, galaxy.name) && Objects.equals(planets, galaxy.planets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, planets);
    }

    @Override
    public String toString() {
        return "Galaxy{" +
                "name='" + name + '\'' +
                ", planets=" + planets +
                '}';
    }
}