import React from 'react'
import MealPlanRecipe from './MealPlanRecipe'

const MealPlan = ({recipes, user,  handleRecipeFavourite, handleAddToMealPlan }) => {

    const mealPlanRecipes = recipes.filter((recipe) => {
      return recipe.mealPlan == true
    })
    
    const renderMealPlanRecipes = mealPlanRecipes.map((recipe) => {
      return <MealPlanRecipe recipe={recipe} key={recipe.if} handleRecipeFavourite={handleRecipeFavourite} handleAddToMealPlan={handleAddToMealPlan}/>
    })
    function openNav() {
        document.getElementById("meal-plan").style.width = "350px";

      }
    
      function closeNav() {
        document.getElementById("meal-plan").style.width = "0";
      }

      const calculateTotalProtein = () => {
        
        let totalProtein = 0
        for (let i = 0; i < mealPlanRecipes.length; i++){
          for(let k=0; k < mealPlanRecipes[i].ingredients.length; k++){
            totalProtein += mealPlanRecipes[i].ingredients[k].protein
         }
        } return Math.round(totalProtein)
      }

      const calculateTotalCarbs = () => {

        let totalCarbs = 0
        for (let i = 0; i < mealPlanRecipes.length; i++){
          for(let k=0; k < mealPlanRecipes[i].ingredients.length; k++){
            totalCarbs += mealPlanRecipes[i].ingredients[k].carbs
         }
        } return Math.round(totalCarbs)
      }
      
      const calculateTotalFat = () => {

        let totalFat = 0
        for (let i = 0; i < mealPlanRecipes.length; i++){
          for(let k=0; k < mealPlanRecipes[i].ingredients.length; k++){
            totalFat += mealPlanRecipes[i].ingredients[k].fat
         }
        } return Math.round(totalFat)
      }

      const calculateTotalFibre = () => {

        let totalFibre = 0
        for (let i = 0; i < mealPlanRecipes.length; i++){
          for(let k=0; k < mealPlanRecipes[i].ingredients.length; k++){
            totalFibre += mealPlanRecipes[i].ingredients[k].fibre
         }
        } return Math.round(totalFibre)
      }

      const calculateTotalCalories = () => {

        let totalCalories = 0
        for (let i = 0; i < mealPlanRecipes.length; i++){
          for(let k=0; k < mealPlanRecipes[i].ingredients.length; k++){
            totalCalories += mealPlanRecipes[i].ingredients[k].calories
         }
        } return Math.round(totalCalories)
      }
      
      const mealPlanLogo = require("../images/LogoBowl.png")


      
      const proteinWithinLimits = () => {
        if((user.protein - calculateTotalProtein()) <= 0){
          return false
        }
          return true 
      }
      const carbsWithinLimits = () => {
        if((user.carbs - calculateTotalCarbs()) <= 0){
          return false
        }
          return true 
      }
      const fatWithinLimits = () => {
        if((user.fat - calculateTotalFat()) <= 0){
          return false
        }
          return true 
      }
      const fibreWithinLimits = () => {
        if((user.fibre - calculateTotalFibre()) <= 0){
          return false
        }
          return true 
      }
      const caloriesWithinLimits = () => {
        if((user.calories - calculateTotalCalories()) <= 0){
          return false
        }
          return true 
      }
      

  return (
    <>
    <div id="meal-plan" className="rightsidenav">
    <a href="javascript:void(0)" className="closebtn" onClick={closeNav}>&times;</a>
    <h1>Meal Plan</h1>
    <h3>Add up to 3 meals for the day</h3>
    {renderMealPlanRecipes}
    <div>
     <p>Your Remaining Macros</p>
    <ul>
        <li className={proteinWithinLimits() ? "macro-green" : "macro-red"}>
        Protein: {user.protein - calculateTotalProtein()}
        </li>
        <li className={carbsWithinLimits() ? "macro-green" : "macro-red"}>
        Carbs: {user.carbs - calculateTotalCarbs()}
        </li>
        <li className={fatWithinLimits() ? "macro-green" : "macro-red"}>
        Fat: {user.fat - calculateTotalFat()}
        </li>
        <li className={fibreWithinLimits() ? "macro-green" : "macro-red"}>
        Fibre: {user.fibre - calculateTotalFibre()}
        </li>
        <li className={caloriesWithinLimits() ? "macro-green" : "macro-red"}>
        Calories: {user.calories - calculateTotalCalories()}
        </li>
    </ul>
    </div>
    </div>
    <button className='meal-plan-btn' onClick={openNav}><img src={mealPlanLogo} width='50px' alt="Meal Plan"/></button>
    
    </>
  )
}

export default MealPlan