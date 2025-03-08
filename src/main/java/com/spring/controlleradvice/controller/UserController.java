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
public class UserController
{
    ArrayList<User> userArrayList = new ArrayList<>();

    @PostMapping("/addUser")
    public ResponseEntity<List<User>> addUser(@RequestBody User user){
        userArrayList.add(user);
        List<User> userList = new ArrayList<>();
        for(User users:userArrayList){
            userList.add(users);
        }
        return new ResponseEntity<>(userList , HttpStatus.CREATED);
    }

    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable int userId){
        if(userId<=0){
            throw new IllegalArgumentException("Invalid userId: "+userId);
        }
        Optional<User> userFromDb = userArrayList.stream().
                                                filter(dbuser -> userId==dbuser.getUserId()).findFirst();
//        return userFromDb.map(user -> new ResponseEntity<>(user, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        if (userFromDb.isPresent()) {
            return new ResponseEntity<>(userFromDb.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
