package com.mlc.MLC.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "protein")
    private double protein;
    @Column(name = "carbs")
    private double carbs;
    @Column(name = "fat")
    private double fat;
    @Column(name = "fibre")
    private double fibre;
    @Column(name = "calories")
    private double calories;
//    @JsonBackReference
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Recipe> favouriteRecipes;
//    @JsonBackReference
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Recipe> mealPlan;

    public User(double protein, double carbs, double fat, double fibre, double calories) {
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
        this.fibre = fibre;
        this.calories = calories;
        this.favouriteRecipes = new ArrayList<>();
        this.mealPlan = new ArrayList<>();
    }

    public User(){}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getFibre() {
        return fibre;
    }

    public void setFibre(double fibre) {
        this.fibre = fibre;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public List<Recipe> getFavouriteRecipes() {
        return favouriteRecipes;
    }

    public void setFavouriteRecipes(List<Recipe> favouriteRecipes) {
        this.favouriteRecipes = favouriteRecipes;
    }

    public List<Recipe> getMealPlan() {
        return mealPlan;
    }

    public void setMealPlan(List<Recipe> mealPlan) {
        this.mealPlan = mealPlan;
    }

    public void addToFavourites(Recipe recipe) {
        this.favouriteRecipes.add(recipe);
    }

    public void removeFromFavourites(Recipe recipe) {
        this.favouriteRecipes.remove(recipe);
    }

    public void addToMealPlan(Recipe recipe) {
        if(mealPlan.size() < 3){
            this.mealPlan.add(recipe);
        }
    }

    public void removeFromMealPlan(Recipe recipe) {
        this.mealPlan.remove(recipe);
    }

    public void clearMealPlan() {
        this.mealPlan.clear();
    }
}
