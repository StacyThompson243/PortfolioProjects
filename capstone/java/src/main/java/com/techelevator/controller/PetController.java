package com.techelevator.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequestMapping(path = "/pets")
@RestController
public class PetController {

    private PetDAO petDAO;

    @GetMapping()
    public List<Pet> getAllPets(){
        return petDAO.getAllPets;
    }

    // add/edit pet here not in volunteer controller
    @PreAuthorize("isAuthenticated()")
    @PostMapping(path = "/add")
    public Pet addNewPet(@Valid @RequestBody Pet pet){
        Pet newPet = petDAO.addPet(pet);
        return newPet;
    }

    @PreAuthorize("hasRole('Admin', 'Volunteer')")
    @PutMapping(path = "/{id}/edit")
    public void updatePetDetails(@PathVariable int id, @RequestBody Pet pet){
        petDAO.editPet(id, pet);
    }
}
