package com.techelevator.dao;

import com.techelevator.model.Pet;
import com.techelevator.model.Volunteer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcVolunteerDao implements VolunteerDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcVolunteerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Volunteer> getAllVolunteers() {
        List<Volunteer> volunteersList = new ArrayList<>();
        String sql = "SELECT application_id, name, email, over_18, status FROM volunteers";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            volunteersList.add(mapRowToVolunteer(results));
        }
        return volunteersList;
    }

    @Override
    public Volunteer getVolunteerById(int id) {
        Volunteer volunteer = null;
        String sql = "SELECT application_id, name, email, over_18, status FROM volunteers WHERE application_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if(results.next()) {
            volunteer = mapRowToVolunteer(results);
        }
        return volunteer;
    }

    @Override
    public List<Volunteer> getAllPendingVolunteers() {
        List<Volunteer> volunteersList = new ArrayList<>();
        String sql = "SELECT application_id, name, email, over_18, status FROM volunteers WHERE status = 'Pending'";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while(results.next()){
            volunteersList.add(mapRowToVolunteer(results));
        }
        return volunteersList;
    }

    @Override
    public void updateStatus(int id, String approvalStatus) {
        String sql = "UPDATE volunteers SET status = ? WHERE application_id = ?";
        jdbcTemplate.update(sql, approvalStatus, id);
    }

    @Override
    public Volunteer applyToVolunteer(Volunteer volunteer) {
        String sql = "INSERT INTO volunteers (name, email, over_18, status) VALUES(?,?,?,?) RETURNING application_id";

        Integer applicationId;

        applicationId = jdbcTemplate.queryForObject(sql, Integer.class, volunteer.getVolunteerName(), volunteer.getEmail(), volunteer.isOver18(), volunteer.getStatus());

        return getVolunteerById(applicationId);
    }

    private Volunteer mapRowToVolunteer(SqlRowSet rowSet){
        Volunteer volunteer = new Volunteer();
        volunteer.setApplicationId(rowSet.getInt("application_id"));
        volunteer.setVolunteerName(rowSet.getString("name"));
        volunteer.setEmail(rowSet.getString("email"));
        volunteer.setOver18(rowSet.getBoolean("over_18"));
        volunteer.setStatus(rowSet.getString("status"));
        return volunteer;
    }
}
