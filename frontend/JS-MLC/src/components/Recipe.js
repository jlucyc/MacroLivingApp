import React from 'react'
import { useParams, useNavigate } from 'react-router-dom'
import Ingredient from './Ingredient'
import './Recipe.css'


const Recipe = ({recipes, handleRecipeFavourite, handleAddToMealPlan}) => {

    const {id} = useParams()
    const recipe = recipes.find(recipe => recipe.id == id)
    const ingredientList = recipe.ingredients.map((ingredient) => {
        return <Ingredient ingredient = {ingredient} key={ingredient.id}/>
      })

    const navigate = useNavigate()

      const handleClick = (() => {
        handleRecipeFavourite(recipe.id)
      })
      const handleMealPlanClick =(() => {
        handleAddToMealPlan(recipe.id)
        navigate("/recipes-all")
      })


      const hearted = require("../images/Hearted.png")
      const unhearted= require("../images/Unhearted.png")

      const favouriteSelectedText = recipe.favourite ? <img width='20px' src={hearted}/>  : <img width='20px' src={unhearted}/>
      const mealPlanSelectedText = recipe.mealPlan ? "Remove From Meal Plan" : "Add To Meal Plan"

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
    
    <div className="recipe-wrap">
        <div className='heading'>      
          <h1>{recipe.name} <button className='fav-btn' type="submit" onClick={handleClick}>{favouriteSelectedText}</button><br></br></h1>
          <img className="recipe-image" src={recipe.imgUrl}/>
          <br></br>
          <button className='add-to-meal-btn' type='submit' onClick={handleMealPlanClick}>{mealPlanSelectedText}</button>
          </div>
    <div className="ingredients-macros">
      <div>
          <h3>Ingredients & Macros</h3> 
          <br></br>
          {ingredientList}
          <br></br>
          <div className="vegan-veggie">{isVegan()} {isVegetarian()}</div>
          <br></br>
        </div>
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
    </div>
         <h4>Steps:</h4>
          <ul>
          <li className='steps'>{recipe.steps.step1}</li>
          <li className='steps'>{recipe.steps.step2}</li>
          <li className='steps'>{recipe.steps.step3}</li>
          <li className='steps'>{recipe.steps.step4}</li>
          <li className='steps'>{recipe.steps.step5}</li>
          </ul>
    </div>
  )
}
export default Recipe