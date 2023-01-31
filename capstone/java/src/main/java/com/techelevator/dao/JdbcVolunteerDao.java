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
        String sql = "SELECT application_id, name, email, over_18, role, status FROM volunteers WHERE application_id = ?";
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
        String sql = "INSERT INTO volunteers (name, email, over_18, role, status) VALUES(?,?,?,?,?) RETURNING application_id";

        Integer applicationId;

        applicationId = jdbcTemplate.queryForObject(sql, Integer.class, volunteer.getVolunteerName(), volunteer.getEmail(), volunteer.isOver18(), volunteer.getVolunteerRole(), volunteer.getStatus());

        return getVolunteerById(applicationId);
    }

    private Volunteer mapRowToVolunteer(SqlRowSet rowSet){
        Volunteer volunteer = new Volunteer();
        volunteer.setApplicationId(rowSet.getInt("application_id"));
        volunteer.setVolunteerName(rowSet.getString("name"));
        volunteer.setEmail(rowSet.getString("email"));
        volunteer.setOver18(rowSet.getBoolean("over_18"));
        volunteer.setVolunteerRole(rowSet.getString("role"));
        volunteer.setStatus(rowSet.getString("status"));
        return volunteer;
    }
}
