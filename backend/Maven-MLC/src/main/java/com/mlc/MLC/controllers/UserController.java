package com.mlc.MLC.controllers;

import com.mlc.MLC.models.User;
import com.mlc.MLC.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/users")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/users/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity getUser(@PathVariable Long id){
        return new ResponseEntity<>(userRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/users")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<User> postUser(@RequestBody User user){
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/users/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<User> deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    @PatchMapping(value = "/users/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
