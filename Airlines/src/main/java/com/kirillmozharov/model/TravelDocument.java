
package com.kirillmozharov.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

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

}
