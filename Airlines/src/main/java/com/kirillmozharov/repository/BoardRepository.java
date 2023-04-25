package com.kirillmozharov.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.kirillmozharov.example.Arrival;
import com.kirillmozharov.model.Passenger;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class BoardRepository {
    private ArrayList<Passenger> passengers = new ArrayList<>();
    private final ObjectMapper objectMapper = new ObjectMapper();

    {
        this.objectMapper.registerModule(new JavaTimeModule());
    }

    public BoardRepository(String path) throws IOException {
        DateTimeFormatter birthDateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter flightDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                try {
                    String[] csv = line.split(";");
                    this.passengers.add(new Passenger(csv[0], csv[1], csv[2], csv[3], LocalDate.parse(csv[4], birthDateFormatter),
                            csv[5], csv[6], csv[7], csv[8], LocalDate.parse(csv[9], flightDateFormatter),
                            LocalTime.parse(csv[10], timeFormatter), csv[10], csv[11], csv[12]));
                    System.out.println(line);
                } catch (DateTimeParseException ignored) {
                    System.out.println(ignored.getMessage());
                }
            }
            System.out.println(this.passengers);
        } catch (IOException ignored) {
        }
    }

    public void save(String fileName) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            objectMapper.writeValue(bufferedWriter, this.passengers);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardRepository that = (BoardRepository) o;
        return Objects.equals(passengers, that.passengers) && Objects.equals(objectMapper, that.objectMapper);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passengers, objectMapper);
    }

    @Override
    public String toString() {
        return "BoardRepository{" +
                "passengers=" + passengers +
                ", objectMapper=" + objectMapper +
                '}';
    }
}
