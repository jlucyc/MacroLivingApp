import React from 'react'
import { useState } from 'react';
import IngredientForCard from './IngredientForCard';

const CardContents = ({recipe, handleRecipeFavourite, handleAddToMealPlan}) => {

    const [visibleDetails, setVisibleDetails] = useState(false);
    
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

  function byID(id) {
      return document.getElementById(id);
    }

  const ingredientsList = recipe.ingredients.map((ingredient) => {
    return <IngredientForCard ingredient={ingredient} key={ingredient.id}/>   
})

const isVegan = () => {
    let counter = 0
    for(let i=0; i< recipe.ingredients.length; i++){
      if(recipe.ingredients[i].vegan){
        counter +=1
      }
    }
    if(counter == recipe.ingredients.length){
      return "Vegan"
    } else {
      return ""
    }
  }

  const isVegetarian = () => {
    let counter = 0
    for(let i=0; i< recipe.ingredients.length; i++){
      if(recipe.ingredients[i].vegetarian){
        counter +=1
      }
    }
    if(counter == recipe.ingredients.length){
      return "Vegetarian"
    } else {
      return ""
    }
  }

  return (
    <article>
    <ul className="ingredients">
        {ingredientsList}
    </ul>
    <div className="vegan-veggie">{isVegan()} {isVegetarian()}</div>
    <ul>
         <li>
            Protein: {totalProtein()}
        </li>
        <li>
            Carbs: {totalCarbs()}
        </li>
        <li>
            Fat: {totalFat()}
        </li>
        <li>
            Fibre: {totalFibre()}
        </li>
        <li>
            Total Calories: {totalCalories()}
        </li>
    </ul>
        <hr></hr>
        <button className='add-to-meal-btn' type='submit' onClick={handleMealPlanClick}>{mealPlanSelectedText}</button>
        <br></br>

        <hr></hr>
        <div className="preperation"> 
         <h4>Steps:</h4>
         <ul>
            <li className="steps">{recipe.steps.step1}</li>
            <li className="steps">{recipe.steps.step2}</li>
            <li className="steps">{recipe.steps.step3}</li>
            <li className="steps">{recipe.steps.step4}</li>
            <li className="steps">{recipe.steps.step5}</li>
        </ul>

    </div>
  </article>
  )
}

export default CardContents