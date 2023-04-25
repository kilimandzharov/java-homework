
package com.kirillmozharov.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Date",
    "Codeshare",
    "Arrival",
    "Flight",
    "Departure"
})
public class RegisteredFlight {

    @JsonProperty("Date")
    private LocalDate date;
    @JsonProperty("Codeshare")
    private boolean codeshare;
    @JsonProperty("Arrival")
    private Arrival arrival;
    @JsonProperty("Flight")
    private String flight;
    @JsonProperty("Departure")
    private Departure departure;

    /**
     * No args constructor for use in serialization
     * 
     */
    public RegisteredFlight() {
    }

    /**
     * 
     * @param date
     * @param flight
     * @param codeshare
     * @param arrival
     * @param departure
     */
    public RegisteredFlight(LocalDate date, boolean codeshare, Arrival arrival, String flight, Departure departure) {
        super();
        this.date = date;
        this.codeshare = codeshare;
        this.arrival = arrival;
        this.flight = flight;
        this.departure = departure;
    }

    @JsonProperty("Date")
    public LocalDate getDate() {
        return date;
    }

    @JsonProperty("Date")
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @JsonProperty("Codeshare")
    public boolean isCodeshare() {
        return codeshare;
    }

    @JsonProperty("Codeshare")
    public void setCodeshare(boolean codeshare) {
        this.codeshare = codeshare;
    }

    @JsonProperty("Arrival")
    public Arrival getArrival() {
        return arrival;
    }

    @JsonProperty("Arrival")
    public void setArrival(Arrival arrival) {
        this.arrival = arrival;
    }

    @JsonProperty("Flight")
    public String getFlight() {
        return flight;
    }

    @JsonProperty("Flight")
    public void setFlight(String flight) {
        this.flight = flight;
    }

    @JsonProperty("Departure")
    public Departure getDeparture() {
        return departure;
    }

    @JsonProperty("Departure")
    public void setDeparture(Departure departure) {
        this.departure = departure;
    }

}
