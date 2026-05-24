package com.taxi.app.dto;

/**
 * View projection of a user stored in HTTP session.
 * Excludes sensitive fields like password.
 */
public class UserView {
    private String id;
    private String name;
    private String email;
    private String phone;
    /** Role discriminator: PASSENGER, DRIVER, ADMIN, or COMPANY. */
    private String role;
    /** Passenger-specific category (REGULAR/VIP), null for other roles. */
    private String passengerType;
    /** Masked or stored card number for payment. */
    private String cardNumber;
    private String cardExpiry;

    /** Required by Jackson. */
    public UserView() {}

    public UserView(String id, String name, String email, String phone, String role,
                    String passengerType, String cardNumber, String cardExpiry) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.passengerType = passengerType;
        this.cardNumber = cardNumber;
        this.cardExpiry = cardExpiry;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getPassengerType() { return passengerType; }
    public void setPassengerType(String passengerType) { this.passengerType = passengerType; }
    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }
    public String getCardExpiry() { return cardExpiry; }
    public void setCardExpiry(String cardExpiry) { this.cardExpiry = cardExpiry; }
}
