package com.taxi.app.model;

import jakarta.persistence.*;

/**
 * Represents a passenger who books rides.
 * Extends Person with passenger-specific attributes like
 * passenger type (REGULAR/VIP) and stored payment card details.
 */
@Entity
@Table(name = "passengers")
public class Passenger extends Person {

    /** Passenger category: REGULAR or VIP. */
    private String passengerType;
    /** Stored card number for payments. */
    private String cardNumber;
    /** Card expiry date in MM/YY format. */
    private String cardExpiry;

    /** Required by JPA. */
    public Passenger() {}

    /**
     * Constructs a Passenger with full details.
     * @param passengerType REGULAR or VIP
     * @param cardNumber    payment card number
     * @param cardExpiry    card expiry (MM/YY)
     */
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
