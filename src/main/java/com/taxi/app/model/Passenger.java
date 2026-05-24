package com.taxi.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "passengers")
public class Passenger extends Person {

    private String passengerType;
    private String cardNumber;
    private String cardExpiry;

    public Passenger() {}

    public Passenger(String id, String name, String email, String phone, String password,
                     String passengerType, String cardNumber, String cardExpiry) {
        super(id, name, email, phone, password);
        this.passengerType = passengerType;
        this.cardNumber = cardNumber;
        this.cardExpiry = cardExpiry;
    }

    @Override
    public String getRole() { return "PASSENGER"; }

    public String getPassengerType() { return passengerType; }
    public void setPassengerType(String passengerType) { this.passengerType = passengerType; }
    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }
    public String getCardExpiry() { return cardExpiry; }
    public void setCardExpiry(String cardExpiry) { this.cardExpiry = cardExpiry; }
}
