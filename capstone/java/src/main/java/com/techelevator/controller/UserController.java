package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.dao.VolunteerDao;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

public class UserController {

    @RequestMapping(path = "/")
    @RestController
    @CrossOrigin
    public class VolunteerController {

        @Autowired
        private VolunteerDao volunteerDao;

        @Autowired
        private UserDao userDao;


//
//        @RequestMapping(path = "/volunteer/directory", method= RequestMethod.GET)
//        public User getUserByApplicationId(@PathVariable int applicationId){
//        User user = userDao.getUserByApplicationId(applicationId);
//            if (user == null) {
//                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found", null);
//            } else
//                return userDao.getUserByApplicationId(applicationId);
//        }
//    }

    }
}
