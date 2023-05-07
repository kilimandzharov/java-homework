
package com.kirillmozharov.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "City",
    "Airport",
    "Country"
})
public class Departure {

    @JsonProperty("City")
    private String city;
    @JsonProperty("Airport")
    private String airport;
    @JsonProperty("Country")
    private String country;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Departure() {
    }

    /**
     * 
     * @param country
     * @param city
     * @param airport
     */
    public Departure(String city, String airport, String country) {
        super();
        this.city = city;
        this.airport = airport;
        this.country = country;
    }

    @JsonProperty("City")
    public String getCity() {
        return city;
    }

    @JsonProperty("City")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("Airport")
    public String getAirport() {
        return airport;
    }

    @JsonProperty("Airport")
    public void setAirport(String airport) {
        this.airport = airport;
    }

    @JsonProperty("Country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("Country")
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departure departure = (Departure) o;
        return Objects.equals(city, departure.city) && Objects.equals(airport, departure.airport) && Objects.equals(country, departure.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, airport, country);
    }

    @Override
    public String toString() {
        return "Departure{" +
                "city='" + city + '\'' +
                ", airport='" + airport + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
