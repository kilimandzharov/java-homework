
package com.kirillmozharov.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Passports"
})
public class TravelDocument {

    @JsonProperty("Passports")
    private Object passports;

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
    public TravelDocument(Object passports) {
        super();
        this.passports = passports;
    }

    @JsonProperty("Passports")
    public Object getPassports() {
        return passports;
    }

    @JsonProperty("Passports")
    public void setPassports(Object passports) {
        this.passports = passports;
    }

}
