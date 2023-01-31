package com.techelevator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public class VisitorController {

    @Autowired
    private VisiterDAO visiterDAO;

    @GetMapping(path = "/pets")
    public Pet getAllPets(){
        return getAllPets();
    }

    @PostMapping(path = "/apply")
    public Volunteer applyToVolunteer(@Valid @RequestBody Volunteer volunteer){
        Volunteer newApplication = VolunteerDAO.applyVolunteer(volunteer);
        newApplication.setStatus("Pending");
        return newApplication;
    }
}
