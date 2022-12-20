import React from 'react'
import User from './User'
import RecipeResult from './RecipeResult'
import IngredientButton from './IngredientButton'
import './RecipeResult.css'


const Homepage = ({users, recipes, ingredients, handleIngredientSelected, updateUser, handleRecipeFavourite, handleAddToMealPlan, handleClearAll}) => {

  const user = users.map((user) => {
    return <User user = {user} key={user.id} updateUser = {updateUser}/>
  })
  const sortedIngredients = ingredients.sort((a, b) => a.name.localeCompare(b.name))

  const ingredientsButtons = sortedIngredients.map((ingredient) => {
    return <IngredientButton ingredient = {ingredient} key={ingredient.id} handleIngredientSelected={handleIngredientSelected}/>
  })
  
  const selectedIngredients = ingredients.filter((ingredient) => ingredient.selected === true)

  const sortedRecipes = recipes.sort((a, b) => a.name.localeCompare(b.name))

  
  const generateFilteredList = (recipes, selectedIngredients) => {    
    let filteredList = []
    for(let i=0; i < recipes.length; i++){
      let counter = 0
      for(let j=0; j < recipes[i].ingredients.length; j++){
        for(let k=0; k < selectedIngredients.length; k++){
          if(recipes[i].ingredients[j].name == selectedIngredients[k].name){
            counter +=1
          }}}
      if(counter >= recipes[i].ingredients.length){
        filteredList.push(recipes[i]
          )}}
    return filteredList;
  }

  const filteredRecipes = generateFilteredList(sortedRecipes, selectedIngredients)

  const foundRecipes = filteredRecipes.map((recipe) => {
    return <RecipeResult className="result-container" recipes={recipes} recipe = {recipe} key={recipe.id} handleRecipeFavourite={handleRecipeFavourite} handleAddToMealPlan={handleAddToMealPlan}/>
  })

  return (
    <>
    <div className='main-content'>
    <div>{user}</div>


    <div className='ingredients-box'>
    <h2>Please select your ingredients</h2>
    <div>{ingredientsButtons}
    <button  className='clear-btn' onClick={handleClearAll} >Clear All</button></div> 
    </div>

    <div className='selection-box'>
    <h2>Based on your selections you have the ingredients to make the following recipes:</h2>
    </div>
    </div>
    <div className='recipe-list'>{foundRecipes}</div>
    </>
  )
}

export default Homepage
