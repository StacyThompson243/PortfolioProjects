package com.techelevator.dao;

import com.techelevator.model.Volunteer;

import java.util.List;

public interface VolunteerDao {

    List<Volunteer> getAllVolunteers();

    List<Volunteer> getAllPendingVolunteers();

    void updateStatus(int id, boolean approvalStatus);
}
