//package com.mlc.MLCAppService.models;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class UserTest {
//
//    Ingredient bacon;
//    Ingredient apple;
//    Ingredient cashews;
//    Recipe bacSalad;
//    User user;
//
//
//    @BeforeEach
//    public void before(){
//        bacon = new Ingredient("Bacon",37, 0,41,0,false,false);
//        apple = new Ingredient("Apple", 0, 13, 0 , 2, true, true );
//        cashews = new Ingredient("Cashews", 18, 27, 44, 3, true, true);
//        bacSalad = new Recipe("BAC Salad");
//        bacSalad.addIngredient(bacon, 20);
//        bacSalad.addIngredient(apple, 50);
//        bacSalad.addIngredient(cashews, 10);
//        user = new User();
//    }
//
//    @Test
//    public void canAddRecipeToFavourites(){
//        user.addToFavourites(bacSalad);
//        assertEquals(1, user.getFavouriteRecipes().size());
//
//    }
//
//    @Test
//    public void canRemoveRecipeFromFavourites(){
//        user.addToFavourites(bacSalad);
//        assertEquals(1, user.getFavouriteRecipes().size());
//        user.removeFromFavourites(bacSalad);
//        assertEquals(0, user.getFavouriteRecipes().size());
//    }
//
//    @Test
//    public void canAddRecipeToMealPlan(){
//        user.addToMealPlan(bacSalad);
//        assertEquals(1, user.getMealPlan().size());
//        user.addToMealPlan(bacSalad);
//        user.addToMealPlan(bacSalad);
//        user.addToMealPlan(bacSalad);
//        assertEquals(3, user.getMealPlan().size());
//    }
//
//    @Test
//    public void canRemoveRecipeFromMealPlan(){
//        user.addToMealPlan(bacSalad);
//        user.addToMealPlan(bacSalad);
//        user.addToMealPlan(bacSalad);
//        assertEquals(3, user.getMealPlan().size());
//        user.removeFromMealPlan(bacSalad);
//        assertEquals(2, user.getMealPlan().size());
//    }
//
//    @Test
//    public void canClearMealPlan(){
//        user.addToMealPlan(bacSalad);
//        user.addToMealPlan(bacSalad);
//        user.addToMealPlan(bacSalad);
//        assertEquals(3, user.getMealPlan().size());
//        user.clearMealPlan();
//        assertEquals(0, user.getMealPlan().size());
//    }
//
//}