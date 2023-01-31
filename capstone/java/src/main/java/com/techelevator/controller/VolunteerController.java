package com.techelevator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RequestMapping(path = "/volunteers")
public class VolunteerController {

    @Autowired
    private VolunteerDAO volunteerDAO;

    @GetMapping(path = "/directory")
    public List<Volunteers> getAllVolunteers(){
        return volunteerDAO.getAllVolunteers();
    }

    @PreAuthorize("hasRole('Admin')")
    //Admin has permission to approve applications
    @GetMapping(path = "/applications")
    public List<Volunteer> approveDenyApplication(){
        return volunteerDAO.getAllPendingVolunteers();
    }

    // Where to get hasRole name
    @PreAuthorize("hasRole('Admin')")
    @PutMapping(path = "/{id}")
    public void approveDenyApplication(@PathVariable int id, @RequestParam boolean approvalStatus){
        if(approvalStatus){
            volunteerDAO.updateStatus(id, "Approved");
        }else{
            volunteerDAO.updateStatus(id, "Denied");
        }
    }




}
