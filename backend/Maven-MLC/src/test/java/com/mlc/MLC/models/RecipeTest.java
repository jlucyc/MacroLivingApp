//package com.mlc.MLCAppService.models;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class RecipeTest {
//
//    Ingredient bacon;
//    Ingredient apple;
//    Ingredient cashews;
//    Recipe bacSalad;
//
//    @BeforeEach
//    public void before(){
//        bacon = new Ingredient("Bacon",37, 0,41,0,false,false);
//        apple = new Ingredient("Apple", 0, 13, 0 , 2, true, true );
//        cashews = new Ingredient("Cashews", 18, 27, 44, 3, true, true);
//        bacSalad = new Recipe("BAC Salad");
//    }
//
//    @Test
//    public void canAddIngredient(){
//        bacSalad.addIngredient(bacon);
//        assertEquals(1, bacSalad.getIngredients().size());
//    }
//
//    @Test
//    public void canAddMultipleIngredients(){
//        bacSalad.addIngredient(bacon);
//        bacSalad.addIngredient(apple);
//        bacSalad.addIngredient(cashews);
//        assertEquals(3, bacSalad.getIngredients().size());
//    }
//
//    @Test
//    public void canAddStep(){
//        bacSalad.addStep("Chop bacon");
//        assertEquals(1, bacSalad.getSteps().size());
//    }
////
//    @Test
//    public void canCalculateProtein(){
//        bacSalad.addIngredient(bacon);
//        bacSalad.addWeight(20);
//        bacSalad.addIngredient(apple);
//        bacSalad.addWeight(50);
//        bacSalad.addIngredient(cashews);
//        bacSalad.addWeight(10);
//        assertEquals(9.2, bacSalad.calculateProtein());
//    }
//
//    @Test
//    public void canCalculateCarbs(){
//        bacSalad.addIngredient(bacon);
//        bacSalad.addIngredient(apple);
//        bacSalad.addIngredient(cashews);
//        bacSalad.addWeight(20);
//        bacSalad.addWeight(50);
//        bacSalad.addWeight(10);
//        assertEquals(9.2, bacSalad.calculateCarbs());
//    }
//
//    @Test
//    public void canCalculateFat(){
//        bacSalad.addIngredient(bacon);
//        bacSalad.addIngredient(apple);
//        bacSalad.addIngredient(cashews);
//        bacSalad.addWeight(20);
//        bacSalad.addWeight(50);
//        bacSalad.addWeight(10);
//        assertEquals(12.6, bacSalad.calculateFat());
//    }
//    @Test
//    public void canCalculateFibre(){
//        bacSalad.addIngredient(bacon);
//        bacSalad.addIngredient(apple);
//        bacSalad.addIngredient(cashews);
//        bacSalad.addWeight(20);
//        bacSalad.addWeight(50);
//        bacSalad.addWeight(10);
//        assertEquals(1.3, bacSalad.calculateFibre());
//    }
//
//    @Test
//    public void canCalculateTotalCalories(){
//        bacSalad.addIngredient(bacon);
//        bacSalad.addIngredient(apple);
//        bacSalad.addIngredient(cashews);
//        bacSalad.addWeight(20);
//        bacSalad.addWeight(50);
//        bacSalad.addWeight(10);
//        assertEquals(189.6, bacSalad.calculateTotalCalories(), 0.01);
//    }
//
//    @Test
//    public void canOutputMacros(){
//        bacSalad.addIngredient(bacon);
//        bacSalad.addIngredient(apple);
//        bacSalad.addIngredient(cashews);
//        bacSalad.addWeight(20);
//        bacSalad.addWeight(50);
//        bacSalad.addWeight(10);
//        assertEquals(5, bacSalad.getMacros().size());
//        System.out.println(bacSalad.getMacros());
//
//    }
//
//    @Test
//    public void canCheckIsFavourite(){
//        assertEquals(false, bacSalad.isFavourite());
//        bacSalad.updateIsFavourite();
//        assertEquals(true, bacSalad.isFavourite());
//    }
//
//
//
//}