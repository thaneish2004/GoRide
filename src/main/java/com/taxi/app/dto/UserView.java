package com.taxi.app.dto;

public class UserView {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String role;
    private String passengerType;
    private String cardNumber;
    private String cardExpiry;

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
