package com.mlc.MLC.controllers;


import com.mlc.MLC.models.Recipe;
import com.mlc.MLC.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeController {

    @Autowired
    RecipeRepository recipeRepository;

    @GetMapping(value = "/recipes")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        return new ResponseEntity<>(recipeRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/recipes/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity getRecipe(@PathVariable Long id) {
        return new ResponseEntity<>(recipeRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/recipes")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Recipe> postRecipe(@RequestBody Recipe recipe) {
        recipeRepository.save(recipe);
        return new ResponseEntity<>(recipe, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/recipes/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Recipe> deleteRecipe(@PathVariable Long id) {
        recipeRepository.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PatchMapping(value = "/recipes/{id}")
    public ResponseEntity<Recipe> updateRecipe(@RequestBody Recipe recipe) {
        recipeRepository.save(recipe);
        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }
}

