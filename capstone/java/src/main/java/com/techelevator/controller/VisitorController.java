package com.techelevator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public class VisitorController {

    @Autowired
    private VisiterDAO visiterDAO;

    @GetMapping(path = "/pets")
    public List<Pet> getAllPets(){
        return getAllPets();
    }

    @GetMapping(path = "/pets/{petId}")
    public Pet getPetById(@PathVariable int petId){
        return getPetById(petId);
    }

    @PostMapping(path = "/apply")
    public Volunteer applyToVolunteer(@Valid @RequestBody Volunteer volunteer){
        Volunteer newApplication = VolunteerDAO.applyVolunteer(volunteer);
        newApplication.setStatus("Pending");
        return newApplication;
    }
}
