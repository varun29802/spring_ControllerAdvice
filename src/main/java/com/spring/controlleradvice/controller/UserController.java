package com.spring.controlleradvice.controller;

import com.spring.controlleradvice.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    // This is a simple in-memory list of users to simulate a database
    ArrayList<User> userArrayList = new ArrayList<>();

    /**
     * Adds a new user to the userArrayList.
     * Returns a list of all users in the userArrayList after adding the new user.
     *
     * @param user - the user object to be added.
     * @return ResponseEntity with a list of all users and HTTP status CREATED (201).
     */
    @PostMapping("/addUser")
    public ResponseEntity<List<User>> addUser(@RequestBody User user) {
        userArrayList.add(user);
        List<User> userList = new ArrayList<>();
        // Populate the list with all users in the userArrayList.
        for (User users : userArrayList) {
            userList.add(users);
        }
        return new ResponseEntity<>(userList, HttpStatus.CREATED); // Returning all users with status 201
    }

    /**
     * Retrieves a user by their userId from the userArrayList.
     * If the userId is invalid (less than or equal to 0), an IllegalArgumentException will be thrown.
     *
     * @param userId - the id of the user to retrieve.
     * @return ResponseEntity with the user data and HTTP status OK (200) if found, otherwise NOT_FOUND (404).
     */
    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable int userId) {
        if (userId <= 0) {
            throw new IllegalArgumentException("Invalid userId: " + userId); // Validate userId
        }
        Optional<User> userFromDb = userArrayList.stream()
                .filter(dbuser -> userId == dbuser.getUserId())
                .findFirst(); // Look for the user with matching userId

        // If user is found, return it with status 200, otherwise return 404.
        if (userFromDb.isPresent()) {
            return new ResponseEntity<>(userFromDb.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Divides two numbers and returns the result.
     * A division by zero will cause an exception which will be handled globally.
     *
     * @param num1 - numerator of the division.
     * @param num2 - denominator of the division.
     * @return ResponseEntity with the result of the division.
     */
    @GetMapping("/divide/{num1}/{num2}")
    public ResponseEntity<String> divide(@PathVariable int num1, @PathVariable int num2) {
        int res = num1 / num2; // Perform division
        return new ResponseEntity<>(String.valueOf(res), HttpStatus.OK); // Return result with status 200
    }
}

