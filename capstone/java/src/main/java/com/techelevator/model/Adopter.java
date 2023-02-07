package com.techelevator.model;

public class Adopter {

    private int adopterId;
    private String adopterName;
    private String email;
    private String phoneNumber;
    private String city;
    private String state;
    private int zipcode;
    private boolean hasCurrentPets;
    private int numberOfCurrentPets;

    public int getAdopterId() {
        return adopterId;
    }

    public void setAdopterId(int adopterId) {
        this.adopterId = adopterId;
    }

    public String getAdopterName() {
        return adopterName;
    }

    public void setAdopterName(String adopterName) {
        this.adopterName = adopterName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public boolean isHasCurrentPets() {
        return hasCurrentPets;
    }

    public void setHasCurrentPets(boolean hasCurrentPets) {
        this.hasCurrentPets = hasCurrentPets;
    }

    public int getNumberOfCurrentPets() {
        return numberOfCurrentPets;
    }

    public void setNumberOfCurrentPets(int numberOfCurrentPets) {
        this.numberOfCurrentPets = numberOfCurrentPets;
    }
}

