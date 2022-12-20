import React from 'react'
import { Link } from 'react-router-dom'


const MealPlanRecipe = ({recipe, handleRecipeFavourite,handleAddToMealPlan}) => {

    const handleClick = (() => {
        handleRecipeFavourite(recipe.id)
      })
      const handleMealPlanClick =(() => {
        handleAddToMealPlan(recipe.id)
      })

      const hearted = require("../images/Hearted.png")
      const unhearted= require("../images/Unhearted.png")

      const favouriteSelectedText = recipe.favourite ? <img width='20px' src={hearted}/>  : <img width='20px' src={unhearted}/>
      const mealPlanSelectedText = recipe.mealPlan ? "Remove from Meal Plan" : "Add To Meal Plan"

    const totalProtein = () => {
        let total = 0
        for (let i = 0; i < recipe.ingredients.length; i++){
             total += recipe.ingredients[i].protein
        } return Math.round(total)
    }
    
    const totalCarbs = () => {
        let total = 0
        for (let i = 0; i < recipe.ingredients.length; i++){
             total += recipe.ingredients[i].carbs
        } return Math.round(total)
    }

    const totalFat = () => {
        let total = 0
        for (let i = 0; i < recipe.ingredients.length; i++){
             total += recipe.ingredients[i].fat
        } return Math.round(total)
    }

    const totalFibre = () => {
        let total = 0
        for (let i = 0; i < recipe.ingredients.length; i++){
             total += recipe.ingredients[i].fibre
        } return Math.round(total)
    }

    const totalCalories = () => {
        let total = 0
        for (let i = 0; i < recipe.ingredients.length; i++){
             total += recipe.ingredients[i].calories
        } return Math.round(total)
    }

  return (
    <>
        <br></br>
    <div><h4><Link to={`/recipe/${recipe.id}`}>{recipe.name}</Link><button className="fav-btn"type="submit" onClick={handleClick}>{favouriteSelectedText}</button></h4></div>
    <ul>
        <li>
            Protein:{totalProtein()}
        </li>
        <li>
            Carbs:{totalCarbs()}
        </li>
        <li>
            Fat:{totalFat()}
        </li>
        <li>
            Fibre:{totalFibre()}
        </li>
        <li>
            Total Calories:{totalCalories()}
        </li>
    </ul>
    
    <button className="add-to-meal-btn"type='submit' onClick={handleMealPlanClick}>{mealPlanSelectedText}</button>

    <br></br>
    </>
  )
}

export default MealPlanRecipe