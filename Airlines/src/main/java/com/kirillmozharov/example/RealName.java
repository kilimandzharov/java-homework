
package com.kirillmozharov.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Last Name",
    "First Name"
})
public class RealName {

    @JsonProperty("Last Name")
    private String lastName;
    @JsonProperty("First Name")
    private String firstName;

    /**
     * No args constructor for use in serialization
     * 
     */
    public RealName() {
    }

    /**
     * 
     * @param lastName
     * @param firstName
     */
    public RealName(String lastName, String firstName) {
        super();
        this.lastName = lastName;
        this.firstName = firstName;
    }

    @JsonProperty("Last Name")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("Last Name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("First Name")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("First Name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
