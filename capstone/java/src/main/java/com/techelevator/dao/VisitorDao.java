package com.techelevator.dao;

import com.techelevator.model.Pet;
import com.techelevator.model.Volunteer;

import java.util.List;

public interface VisitorDao {

        List<Pet> getAllPets();

        Pet getPetById(int petId);

        Volunteer applyToVolunteer(Volunteer volunteer);

}
