package com.kirillmozharov.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class Passenger {
    private String firstName;
    private String secondName;
    private String lastName;
    private String sex;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate birthDate = LocalDate.now();
    private String document;
    private String bookingCode;
    private String ticketNumber;
    private String baggage;
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate flightDate = LocalDate.now();
    @JsonFormat(pattern = "HH:mm", shape = JsonFormat.Shape.STRING)
    private LocalTime flightTime = LocalTime.now();
    private String flightNumber;
    private String codeShare;
    private String destination;

    public Passenger() {
    }

    public Passenger(String firstName, String secondName, String lastName, String sex, LocalDate birthDate,
                     String document, String bookingCode, String ticketNumber, String baggage, LocalDate flightDate,
                     LocalTime flightTime, String flightNumber, String codeShare, String destination) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.sex = sex;
        this.birthDate = birthDate;
        this.document = document;
        this.bookingCode = bookingCode;
        this.ticketNumber = ticketNumber;
        this.baggage = baggage;
        this.flightDate = flightDate;
        this.flightTime = flightTime;
        this.flightNumber = flightNumber;
        this.codeShare = codeShare;
        this.destination = destination;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getBaggage() {
        return baggage;
    }

    public void setBaggage(String baggage) {
        this.baggage = baggage;
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
    }

    public LocalTime getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(LocalTime flightTime) {
        this.flightTime = flightTime;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getCodeShare() {
        return codeShare;
    }

    public void setCodeShare(String codeShare) {
        this.codeShare = codeShare;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(firstName, passenger.firstName) && Objects.equals(secondName, passenger.secondName) && Objects.equals(lastName, passenger.lastName) && Objects.equals(sex, passenger.sex) && Objects.equals(birthDate, passenger.birthDate) && Objects.equals(document, passenger.document) && Objects.equals(bookingCode, passenger.bookingCode) && Objects.equals(ticketNumber, passenger.ticketNumber) && Objects.equals(baggage, passenger.baggage) && Objects.equals(flightDate, passenger.flightDate) && Objects.equals(flightTime, passenger.flightTime) && Objects.equals(flightNumber, passenger.flightNumber) && Objects.equals(codeShare, passenger.codeShare) && Objects.equals(destination, passenger.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, lastName, sex, birthDate, document, bookingCode, ticketNumber, baggage, flightDate, flightTime, flightNumber, codeShare, destination);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex='" + sex + '\'' +
                ", birthDate=" + birthDate +
                ", document='" + document + '\'' +
                ", bookingCode='" + bookingCode + '\'' +
                ", ticketNumber='" + ticketNumber + '\'' +
                ", baggage='" + baggage + '\'' +
                ", flightDate=" + flightDate +
                ", flightTime=" + flightTime +
                ", flightNumber='" + flightNumber + '\'' +
                ", codeShare='" + codeShare + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}
