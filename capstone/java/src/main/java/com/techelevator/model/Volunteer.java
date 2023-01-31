package com.techelevator.model;

public class Volunteer {

    private int applicationId;
    private String volunteerName;
    private String email;
    private boolean over18;
    private String volunteerRole = "ROLE_USER";
    private String status;

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public String getVolunteerName() {
        return volunteerName;
    }

    public void setVolunteerName(String volunteerName) {
        this.volunteerName = volunteerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isOver18() {
        return over18;
    }

    public void setOver18(boolean over18) {
        this.over18 = over18;
    }

    public String getVolunteerRole() {
        return volunteerRole;
    }

    public void setVolunteerRole(String volunteerRole) {
        this.volunteerRole = volunteerRole;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
