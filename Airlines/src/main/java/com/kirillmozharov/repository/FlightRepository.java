package com.kirillmozharov.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.kirillmozharov.example.ForumProfile;
import com.kirillmozharov.example.FrequentFlyer;
import com.kirillmozharov.example.RegisteredFlight;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class FlightRepository {
    private ObjectMapper objectMapper = new ObjectMapper();
    private FrequentFlyer frequentFlyers;

    {
        //TODO для работы с LocalDateTime
        this.objectMapper.registerModule(new JavaTimeModule());
    }
    public FlightRepository(String path) throws IOException {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path))) {
            this.frequentFlyers = objectMapper.readValue(bufferedInputStream, FrequentFlyer.class);
        }
    }

    public FrequentFlyer getFrequentFlyers() {
        return frequentFlyers;
    }

    public void setFrequentFlyers(FrequentFlyer frequentFlyers) {
        this.frequentFlyers = frequentFlyers;
    }

    public Set<ForumProfile> getPassengersByCityDeparture(String cityName) {
        Set<ForumProfile> result = new HashSet<>();
        for (ForumProfile forumProfile : this.frequentFlyers.getForumProfiles()) {
            for (RegisteredFlight registeredFlight : forumProfile.getRegisteredFlights()) {
                if (registeredFlight.getDeparture().getCity().equals(cityName)) {
                    result.add(forumProfile);
                }
            }
        }
        return result;
    }

    public Set<ForumProfile> getPassengersDepartedLaterThan(LocalDate localDate) {
        Set<ForumProfile> result = new HashSet<>();
        for (ForumProfile forumProfile : this.frequentFlyers.getForumProfiles()) {
            for (RegisteredFlight registeredFlight : forumProfile.getRegisteredFlights()) {
                if (registeredFlight.getDate().isAfter(localDate)) {
                    result.add(forumProfile);
                }
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightRepository that = (FlightRepository) o;
        return Objects.equals(objectMapper, that.objectMapper) && Objects.equals(frequentFlyers, that.frequentFlyers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objectMapper, frequentFlyers);
    }

    @Override
    public String toString() {
        return "FlightRepository{" +
                "objectMapper=" + objectMapper +
                ", frequentFlyers=" + frequentFlyers +
                '}';
    }
}
