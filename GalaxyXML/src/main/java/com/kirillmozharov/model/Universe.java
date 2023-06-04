package com.kirillmozharov.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.kirillmozharov.util.NameGenerator;

import java.lang.reflect.Array;
import java.util.*;

public class Universe {


    @JacksonXmlProperty(localName = "Name")
    private String name;
    @JacksonXmlElementWrapper(localName = "Universes")
    @JacksonXmlProperty(localName = "Universe")
    private ArrayList<Galaxy> galaxies = new ArrayList<Galaxy>();

    public Universe() {
    }

    public Universe(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<Galaxy> add(Galaxy galaxy) {
        if (this.galaxies.contains(galaxy)) {
            return Optional.empty();
        }
        this.galaxies.add(galaxy);
        return Optional.of(galaxy);
    }

    public int[] search(Planet planet) {
        int[] infoArray = {-1, -1};
        this.galaxies.forEach(galaxy -> {
            int indexOfPlanet = galaxy.search(planet);
            if (indexOfPlanet == -1) {
                return;
            }
            infoArray[0] = indexOfPlanet;
            infoArray[1] = this.galaxies.indexOf(galaxy);
        });
        return infoArray;
    }

    public Optional<Planet> search(String name) {
        final Optional<Planet>[] planet = new Optional[]{Optional.empty()};
        this.galaxies.forEach(galaxy -> {
            Optional<Planet> planetFound = galaxy.search(name);
            if (planetFound.isPresent()) {
                planet[0] = planetFound;
            }
        });
        return planet[0];
    }

    public void behaviour() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timerTick();
            }
        }, 0, 300000);
    }

    private void timerTick() {
        int numOfGalaxies = (int) (Math.random() * 100 + 1);
        for (int i = 0; i < numOfGalaxies; i++) {
            String randomGalaxyName = NameGenerator.generateGalaxyName();
            Galaxy galaxy = new Galaxy(randomGalaxyName);
            int numOfPlanets = (int) (Math.random() * 100 + 1);
            for (int i1 = 0; i1 < numOfPlanets; i1++) {
                String planetName = NameGenerator.generatePlanetName();
                double planetRadius = Math.random() * 100000;
                double planetPeriod = Math.random() * 10000000;
                galaxy.add(new Planet(planetName, planetPeriod, planetRadius));
            }
            this.galaxies.add(galaxy);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Universe universe = (Universe) o;
        return Objects.equals(name, universe.name) && Objects.equals(galaxies, universe.galaxies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, galaxies);
    }

    @Override
    public String toString() {
        return "Universe{" +
                "name='" + name + '\'' +
                ", galaxies=" + galaxies +
                '}';
    }
}