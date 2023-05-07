
package com.kirillmozharov.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Registered Flights",
    "NickName",
    "Travel Documents",
    "Sex",
    "Loyality Programm",
    "Real Name"
})
public class ForumProfile {

    @JsonProperty("Registered Flights")
    private List<RegisteredFlight> registeredFlights = new ArrayList<RegisteredFlight>();
    @JsonProperty("NickName")
    private String nickName;
    @JsonProperty("Travel Documents")
    private List<TravelDocument> travelDocuments = new ArrayList<TravelDocument>();
    @JsonProperty("Sex")
    private String sex;
    @JsonProperty("Loyality Programm")
    private List<LoyalityProgramm> loyalityProgramm = new ArrayList<LoyalityProgramm>();
    @JsonProperty("Real Name")
    private RealName realName;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ForumProfile() {
    }

    /**
     * 
     * @param realName
     * @param loyalityProgramm
     * @param travelDocuments
     * @param registeredFlights
     * @param nickName
     * @param sex
     */
    public ForumProfile(List<RegisteredFlight> registeredFlights, String nickName, List<TravelDocument> travelDocuments, String sex, List<LoyalityProgramm> loyalityProgramm, RealName realName) {
        super();
        this.registeredFlights = registeredFlights;
        this.nickName = nickName;
        this.travelDocuments = travelDocuments;
        this.sex = sex;
        this.loyalityProgramm = loyalityProgramm;
        this.realName = realName;
    }

    @JsonProperty("Registered Flights")
    public List<RegisteredFlight> getRegisteredFlights() {
        return registeredFlights;
    }

    @JsonProperty("Registered Flights")
    public void setRegisteredFlights(List<RegisteredFlight> registeredFlights) {
        this.registeredFlights = registeredFlights;
    }

    @JsonProperty("NickName")
    public String getNickName() {
        return nickName;
    }

    @JsonProperty("NickName")
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @JsonProperty("Travel Documents")
    public List<TravelDocument> getTravelDocuments() {
        return travelDocuments;
    }

    @JsonProperty("Travel Documents")
    public void setTravelDocuments(List<TravelDocument> travelDocuments) {
        this.travelDocuments = travelDocuments;
    }

    @JsonProperty("Sex")
    public String getSex() {
        return sex;
    }

    @JsonProperty("Sex")
    public void setSex(String sex) {
        this.sex = sex;
    }

    @JsonProperty("Loyality Programm")
    public List<LoyalityProgramm> getLoyalityProgramm() {
        return loyalityProgramm;
    }

    @JsonProperty("Loyality Programm")
    public void setLoyalityProgramm(List<LoyalityProgramm> loyalityProgramm) {
        this.loyalityProgramm = loyalityProgramm;
    }

    @JsonProperty("Real Name")
    public RealName getRealName() {
        return realName;
    }

    @JsonProperty("Real Name")
    public void setRealName(RealName realName) {
        this.realName = realName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForumProfile that = (ForumProfile) o;
        return Objects.equals(registeredFlights, that.registeredFlights) && Objects.equals(nickName, that.nickName) && Objects.equals(travelDocuments, that.travelDocuments) && Objects.equals(sex, that.sex) && Objects.equals(loyalityProgramm, that.loyalityProgramm) && Objects.equals(realName, that.realName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registeredFlights, nickName, travelDocuments, sex, loyalityProgramm, realName);
    }

    @Override
    public String toString() {
        return "ForumProfile{" +
                "registeredFlights=" + registeredFlights +
                ", nickName='" + nickName + '\'' +
                ", travelDocuments=" + travelDocuments +
                ", sex='" + sex + '\'' +
                ", loyalityProgramm=" + loyalityProgramm +
                ", realName=" + realName +
                '}';
    }
}
