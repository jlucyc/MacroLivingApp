package com.mlc.MLC.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @JsonIgnoreProperties({"recipes"})
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "ingredients_recipes",
            joinColumns = {
                    @JoinColumn(name = "recipe_id", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ingredient_id", nullable = false, updatable = false)
            }
    )
    private List<Ingredient> ingredients;
//    @JsonBackReference
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "steps_id", referencedColumnName = "id")
    private Steps steps;
    @Column(name = "favourite")
    private boolean favourite;
    @Column(name = "mealPlan")
    private  boolean mealPlan;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="img_url")
    private String imgUrl;



    public Recipe(String name, Steps steps, String imgUrl) {
        this.name = name;
        this.ingredients = new ArrayList<>();
        this.steps = steps;
        this.favourite = false;
        this.mealPlan = false;
        this.imgUrl = imgUrl;
    }

    public Recipe(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }
//    public double calculateProtein() {
//        double runningTotal = 0;
//        for(int i = 0; i < ingredients.size(); i++){
//            double weight = this.weights.get(i);
//            runningTotal += (ingredients.get(i).getProtein() /100 * weight);
//        }
//        return runningTotal;
//    }
//
//    public double calculateCarbs() {
//        double runningTotal = 0;
//        for(int i = 0; i < ingredients.size(); i++){
//            double weight = this.weights.get(i);
//            runningTotal += (ingredients.get(i).getCarbs() /100 * weight);
//        }
//        return runningTotal;
//    }
//
//    public double calculateFat() {
//        double runningTotal = 0;
//        for(int i = 0; i < ingredients.size(); i++){
//            double weight = this.weights.get(i);
//            runningTotal += (ingredients.get(i).getFat() /100 * weight);
//        }
//        return runningTotal;
//    }
//
//    public double calculateFibre() {
//        double runningTotal = 0;
//        for(int i = 0; i < ingredients.size(); i++){
//            double weight = this.weights.get(i);
//            runningTotal += (ingredients.get(i).getFibre() /100 * weight);
//        }
//        return runningTotal;
//    }
//
//    public double calculateTotalCalories() {
//        double runningTotal = 0;
//        for(int i = 0; i < ingredients.size(); i++){
//            double weight = this.weights.get(i);
//            runningTotal += (ingredients.get(i).calculateTotalCalories() /100 * weight);
//        }
//        return runningTotal;
//
//    }
//
//    public HashMap getMacros() {
//        HashMap<String, Double> macros = new HashMap<>();
//        macros.put("protein", calculateProtein());
//        macros.put("carbs", calculateCarbs());
//        macros.put("fat", calculateFat());
//        macros.put("fibre", calculateFibre());
//        macros.put("calories", calculateTotalCalories());
//        return macros;
//    }

    public void updateIsFavourite() {
        if(favourite){
            this.favourite = false;
        } else {
            this.favourite = true;
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Steps getSteps() {
        return steps;
    }

    public void setSteps(Steps steps) {
        this.steps = steps;
    }

    public boolean isMealPlan() {
        return mealPlan;
    }

    public void setMealPlan(boolean mealPlan) {
        this.mealPlan = mealPlan;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
