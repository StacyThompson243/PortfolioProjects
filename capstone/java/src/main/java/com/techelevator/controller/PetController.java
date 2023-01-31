package com.techelevator.controller;

import com.techelevator.dao.PetDao;
import com.techelevator.model.Pet;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RequestMapping(path = "/pets")
@RestController
public class PetController {

    private PetDao petDAO;

    @GetMapping()
    public List<Pet> getAllPets(){
        return petDAO.getAllPets();
    }

    // add/edit pet here not in volunteer controller
    @PreAuthorize("hasRole('ROLE_ADMIN', 'ROLE_USER')")
    @PostMapping(path = "/add")
    public Pet addNewPet(@Valid @RequestBody Pet pet){
        Pet newPet = petDAO.addPet(pet);
        return newPet;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN', 'ROLE_USER')")
    @PutMapping(path = "/{id}/edit")
    public void updatePetDetails(@PathVariable int id, @RequestBody Pet pet){
        petDAO.editPet(id, pet);
    }
}
