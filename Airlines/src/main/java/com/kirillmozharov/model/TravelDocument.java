
package com.kirillmozharov.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Passports"
})
public class TravelDocument {

    @JsonProperty("Passports")
    private String passports;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TravelDocument() {
    }

    /**
     * 
     * @param passports
     */
    public TravelDocument(String passports) {
        super();
        this.passports = passports;
    }

    @JsonProperty("Passports")
    public String getPassports() {
        return passports;
    }

    @JsonProperty("Passports")
    public void setPassports(String passports) {
        this.passports = passports;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TravelDocument that = (TravelDocument) o;
        return Objects.equals(passports, that.passports);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passports);
    }

    @Override
    public String toString() {
        return "TravelDocument{" +
                "passports='" + passports + '\'' +
                '}';
    }
}
