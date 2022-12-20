//package com.mlc.MLCAppService.models;
//
//import org.aspectj.lang.annotation.Before;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class IngredientTest {
//
//    Ingredient bacon;
//    Ingredient apple;
//    Ingredient cashews;
//
//
//    @BeforeEach()
//    public void before(){
//        bacon = new Ingredient("Bacon",37, 0,41,0,false,false);
//        apple = new Ingredient("Apple", 0, 13, 0 , 2, true, true );
//        cashews = new Ingredient("Cashews", 18, 27, 44, 3, true, true);
//    }
//
//    @Test
//    public void canCalculateProteinCalories(){
//        assertEquals(148, bacon.calculateProteinCalories());
//
//    }
//
//    @Test
//    public void canCalculateCarbsCalories(){
//        assertEquals(52, apple.calculateCarbsCalories());
//    }
//    @Test
//    public void canCalculateFatCalories(){
//        assertEquals(369, bacon.calculateFatCalories());
//    }
//
//    @Test
//    public void canCalculateFibreCalories(){
//        assertEquals(4, apple.calculateFibreCalories());
//    }
//
//    @Test void canCalculateTotalCalories(){
//        assertEquals(582, cashews.calculateTotalCalories());
//    }
//
//    @Test void canUpdateIsSelected(){
//        assertEquals(false, bacon.isSelected());
//        bacon.updateIsSelected();
//        assertEquals(true, bacon.isSelected());
//    }
//
//}