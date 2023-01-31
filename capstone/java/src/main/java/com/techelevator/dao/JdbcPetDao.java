package com.techelevator.dao;

import com.techelevator.model.Pet;
import com.techelevator.model.Volunteer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPetDao implements PetDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcPetDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Pet> getAllPets() {
        List<Pet> petList = new ArrayList<>();
        String sql = "SELECT pet_id, pet_image, name, type, age, gender, weight, breed, description, adopted FROM pets WHERE adopted = 'false'";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            petList.add(mapRowToPet(results));
        }
        return petList;
    }

    @Override
    public Pet getPetById(int petId) {
        Pet pet = null;
        String sql = "SELECT pet_id, pet_image, name, type, age, gender, weight, breed, description, adopted FROM pets WHERE pet_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, petId);
        if(results.next()) {
            pet = mapRowToPet(results);
        }
        return pet;
    }

    @Override
    public Pet addNewPet(Pet pet) {
        return null;
    }

    @Override
    public void editPet(int id, Pet pet) {

    }

    private Pet mapRowToPet(SqlRowSet rowSet){
        Pet pet = new Pet();
        pet.setPetId(rowSet.getInt("pet_id"));
        pet.setPetImage(rowSet.getString("pet_image"));
        pet.setPetName(rowSet.getString("name"));
        pet.setType(rowSet.getString("type"));
        pet.setAge(rowSet.getInt("age"));
        pet.setGender(rowSet.getString("gender"));
        pet.setWeight(rowSet.getInt("weight"));
        pet.setBreed(rowSet.getString("breed"));
        pet.setDescription(rowSet.getString("description"));
        pet.setAdopted(rowSet.getBoolean("adopted"));
        return pet;
    }
}
