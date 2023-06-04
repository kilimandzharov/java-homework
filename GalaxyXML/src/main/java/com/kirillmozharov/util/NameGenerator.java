package com.kirillmozharov.util;
import java.util.Random;

public class NameGenerator {
    public static String generatePlanetName() {
        int randomSeed = (int) (Math.random() * 1e9);
        return "P" + randomSeed;
    }

    public static String generateGalaxyName() {
        int randomSeed = (int) (Math.random() * 1e9);
        return "G" + randomSeed;
    }
}