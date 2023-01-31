package com.techelevator.controller;

import com.techelevator.dao.VolunteerDao;
import com.techelevator.model.Volunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RequestMapping(path = "/volunteer")
public class VolunteerController {

    @Autowired
    private VolunteerDao volunteerDAO;

    @GetMapping(path = "/directory")
    public List<Volunteer> getAllVolunteers(){
        return volunteerDAO.getAllVolunteers();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    //Admin has permission to approve applications
    @GetMapping(path = "/applications")
    public List<Volunteer> approveDenyApplication(){
        return volunteerDAO.getAllPendingVolunteers();
    }

    // Where to get hasRole name
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(path = "/{id}")
    public void approveDenyApplication(@PathVariable int id, @RequestParam boolean approvalStatus){
        if(approvalStatus){
            volunteerDAO.updateStatus(id, "Approved");
        }else{
            volunteerDAO.updateStatus(id, "Denied");
        }
    }




}
