package com.techelevator.dao;

import com.techelevator.model.Pet;
import com.techelevator.model.Volunteer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Component
public class JdbcVolunteerDao implements VolunteerDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcVolunteerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Volunteer> getAllVolunteers() {
        return null;
    }

    @Override
    public Volunteer getVolunteerById(int id) {
        Volunteer volunteer = null;
        String sql = "SELECT application_id, first_name, last_name, email, over_18, veterinary, cleaning, data_entry, photography, status FROM volunteers WHERE application_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if(results.next()) {
            volunteer = mapRowToVolunteer(results);
        }
        return volunteer;
    }

    @Override
    public List<Volunteer> getAllPendingVolunteers() {
        return null;
    }

    @Override
    public void updateStatus(int id, String approvalStatus) {

    }

    @Override
    public Volunteer applyToVolunteer(Volunteer volunteer) {
        String sql = "INSERT INTO volunteers (first_name, last_name, email, over_18, veterinary, cleaning, data_entry, photography, status) VALUES(?,?,?,?,?,?,?,?,?) RETURNING application_id";

        Integer applicationId;

        applicationId = jdbcTemplate.queryForObject(sql, Integer.class, volunteer.getVolunteerFirstName(), volunteer.getVolunteerLastName(), volunteer.getEmail(), volunteer.isOver18(), volunteer.isVeterinary(), volunteer.isCleaning(), volunteer.isDataEntry(), volunteer.isPhotography(), volunteer.getStatus());

        return getVolunteerById(applicationId);
    }

    private Volunteer mapRowToVolunteer(SqlRowSet rowSet){
        Volunteer volunteer = new Volunteer();
        volunteer.setApplicationId(rowSet.getInt("application_id"));
        volunteer.setVolunteerFirstName(rowSet.getString("first_name"));
        volunteer.setVolunteerLastName(rowSet.getString("last_name"));
        volunteer.setEmail(rowSet.getString("email"));
        volunteer.setOver18(rowSet.getBoolean("over_18"));
        volunteer.setVeterinary(rowSet.getBoolean("veterinary"));
        volunteer.setCleaning(rowSet.getBoolean("cleaning"));
        volunteer.setDataEntry(rowSet.getBoolean("data_entry"));
        volunteer.setPhotography(rowSet.getBoolean("photography"));
        volunteer.setStatus(rowSet.getString("status"));
        return volunteer;
    }
}