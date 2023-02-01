package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.dao.VolunteerDao;
import com.techelevator.model.User;
import com.techelevator.model.Volunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@RequestMapping(path = "/volunteer")
@RestController
@CrossOrigin
public class VolunteerController {

    @Autowired
    private VolunteerDao volunteerDao;

    @Autowired
    private UserDao userDao;

    @GetMapping(path = "/directory")
    public List<Volunteer> getAllVolunteers(){
        return volunteerDao.getAllVolunteers();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    //Admin has permission to approve applications
    @GetMapping(path = "/applications")
    public List<Volunteer> getAllPendingVolunteers(){
        return volunteerDao.getAllPendingVolunteers();
    }

    // Where to get hasRole name
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(path = "/{id}")
    public void approveDenyApplication(@PathVariable int id, @RequestParam String approvalStatus){

            if (approvalStatus.equals("Approved")) {
                volunteerDao.updateStatus(id, "Approved");
                Volunteer volunteer = volunteerDao.getVolunteerById(id);
                userDao.create(volunteer.getVolunteerFirstName() + "." + volunteer.getVolunteerLastName(), "" + (int) (Math.random() * 100), "ROLE_USER");
            } else {
                volunteerDao.updateStatus(id, "Denied");
            }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/apply")
    public Volunteer applyToVolunteer(@Valid @RequestBody Volunteer volunteer){
        Volunteer newApplication = volunteerDao.applyToVolunteer(volunteer);
//        newApplication.setStatus("Pending");
        return newApplication;
    }




}
