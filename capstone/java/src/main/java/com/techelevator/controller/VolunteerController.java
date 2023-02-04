package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.dao.VolunteerDao;
import com.techelevator.model.GMailer;
import com.techelevator.model.Volunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(path = "/volunteer")
@RestController
@CrossOrigin
public class VolunteerController {

    @Autowired
    private VolunteerDao volunteerDao;

    @Autowired
    private UserDao userDao;

//    @GetMapping(path = "/directory")
//    public List<Volunteer> getAllVolunteers(){
//        return volunteerDao.getAllVolunteers();
//    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    //Admin has permission to approve applications
    @GetMapping(path = "/directory")
    public List<Volunteer> getAllApprovedVolunteers(){
        return volunteerDao.getVolunteersByStatus("Approved");
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    //Admin has permission to approve applications
    @GetMapping(path = "/applications")
    public List<Volunteer> getAllPendingVolunteers(){
        return volunteerDao.getVolunteersByStatus("Pending");
    }

    // Where to get hasRole name
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(path = "/{id}")
    public void approveDenyApplication(@PathVariable int id, @RequestBody Volunteer application) throws Exception {
        Volunteer volunteer = volunteerDao.getVolunteerById(id);
        String password = "" + (int) (Math.random() * 100);
        String username = volunteer.getVolunteerFirstName() + "." + volunteer.getVolunteerLastName();
        String email = volunteer.getEmail();
        GMailer sendEmail = new GMailer();
            if (application.getStatus().equals("Approved")) {
                volunteerDao.updateStatus(id, "Approved");
                userDao.create(username, password, "ROLE_USER");
                sendEmail.sendMail(email, "Welcome to the team!",
                        "Dear " + volunteer.getVolunteerFirstName() + " you have been approved to start working on our team at the Critter Cottage!" +
                                "\n\n\n Here are you're login credentials:\nUsername: " + username + "\nPassword: " + password);
            } else {
                volunteerDao.updateStatus(id, "Denied");
                sendEmail.sendMail(email, "Critter Cottage information",
                        "Sorry " + volunteer.getVolunteerFirstName() + " Critter Cottage doesn't want you");
            }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/apply")
    public Volunteer applyToVolunteer(@Valid @RequestBody Volunteer volunteer){
        Volunteer newApplication = volunteerDao.applyToVolunteer(volunteer);
        return newApplication;
    }




}
