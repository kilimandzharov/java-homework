package com.kirillmozharov.program;

import com.kirillmozharov.repository.FlightRepository;

import java.io.IOException;
import java.time.LocalDate;

public class Program {
    public static void main(String[] args) {
     /*   try {
            //Generate Schema from JSON file
            Json2PojoGenerator generator = new Json2PojoGenerator("flies.json",
                    "src/main/java/");
            generator.generate("FrequentFlyer", "com.kirillmozharov.example");
        } catch (IOException ignored) {
        }*/
        try {
            FlightRepository flightRepository = new FlightRepository("flies.json");
            LocalDate localDate = LocalDate.of(2009,2,17);
            System.out.println(flightRepository.getPassengersDepartedLaterThan(localDate));
        } catch (IOException ignored) {
            System.out.println(ignored);
        }

    }
}
