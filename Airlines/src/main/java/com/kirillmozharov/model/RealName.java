
package com.kirillmozharov.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RealName realName = (RealName) o;
        return Objects.equals(lastName, realName.lastName) && Objects.equals(firstName, realName.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName);
    }

    @Override
    public String toString() {
        return "RealName{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
