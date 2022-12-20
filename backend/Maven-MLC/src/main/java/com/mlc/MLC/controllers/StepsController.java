package com.mlc.MLC.controllers;


import com.mlc.MLC.models.Steps;
import com.mlc.MLC.repository.StepsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StepsController {
    @Autowired
    StepsRepository stepsRepository;

    @GetMapping(value="/steps")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Steps>> getAllSteps(){
        return new ResponseEntity<>(stepsRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/steps/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity getStep(@PathVariable Long id){
        return new ResponseEntity<>(stepsRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/steps")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Steps> postStep(@RequestBody Steps steps){
        stepsRepository.save(steps);
        return new ResponseEntity<>(steps, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/steps/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Steps> deleteStep(@PathVariable Long id){
        stepsRepository.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    @PatchMapping(value = "/steps/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Steps> updateStep(@RequestBody Steps steps){
        stepsRepository.save(steps);
        return new ResponseEntity<>(steps, HttpStatus.OK);
    }
}



