package com.techelevator.controller;

import com.techelevator.dao.VolunteerDao;
import com.techelevator.model.Volunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@RequestMapping(path = "/volunteer")
@RestController
public class VolunteerController {

    @Autowired
    private VolunteerDao volunteerDao;

    @GetMapping(path = "/directory")
    public List<Volunteer> getAllVolunteers(){
        return volunteerDao.getAllVolunteers();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    //Admin has permission to approve applications
    @GetMapping(path = "/applications")
    public List<Volunteer> approveDenyApplication(){
        return volunteerDao.getAllPendingVolunteers();
    }

    // Where to get hasRole name
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(path = "/{id}")
    public void approveDenyApplication(@PathVariable int id, @RequestParam String approvalStatus){
        if(approvalStatus.equals("Approved")){
            volunteerDao.updateStatus(id, "Approved");
        }else{
            volunteerDao.updateStatus(id, "Denied");
        }
    }

    @PostMapping(path = "/apply")
    public Volunteer applyToVolunteer(@Valid @RequestBody Volunteer volunteer){
        Volunteer newApplication = volunteerDao.applyToVolunteer(volunteer);
//        newApplication.setStatus("Pending");
        return newApplication;
    }




}
