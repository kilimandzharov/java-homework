
package com.kirillmozharov.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Status",
    "programm",
    "Number"
})
public class LoyalityProgramm {

    @JsonProperty("Status")
    private String status;
    @JsonProperty("programm")
    private String programm;
    @JsonProperty("Number")
    private String number;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LoyalityProgramm() {
    }

    /**
     * 
     * @param number
     * @param programm
     * @param status
     */
    public LoyalityProgramm(String status, String programm, String number) {
        super();
        this.status = status;
        this.programm = programm;
        this.number = number;
    }

    @JsonProperty("Status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("Status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("programm")
    public String getProgramm() {
        return programm;
    }

    @JsonProperty("programm")
    public void setProgramm(String programm) {
        this.programm = programm;
    }

    @JsonProperty("Number")
    public String getNumber() {
        return number;
    }

    @JsonProperty("Number")
    public void setNumber(String number) {
        this.number = number;
    }

}
