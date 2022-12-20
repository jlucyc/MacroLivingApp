import React, { useEffect, useState } from 'react'
import RecipeList from './RecipeList'
import './RecipeResult.css'


const RecipesAll = ({recipes, handleRecipeFavourite}) => {

  const [selectedRecipeList, setSelectedRecipeList] = useState([])

  
  const sortedRecipes = recipes.sort((a, b) => a.name.localeCompare(b.name))
  
  const recipeList = sortedRecipes.map((recipe) => {
    return <RecipeList recipe = {recipe} key={recipe.id}/> 
    
  })

  useEffect(() => {
    setSelectedRecipeList(recipeList)
  },[])
  
  const generateVeganList = (recipes) => {    
    let filteredList = []
    for(let i=0; i < recipes.length; i++){
      let counter = 0
      for(let j=0; j < recipes[i].ingredients.length; j++){
        if(recipes[i].ingredients[j].vegan == true){
          counter += 1
        } 
      }
      if(counter == recipes[i].ingredients.length){
        filteredList.push(recipes[i])
      }
    }
    return filteredList;
  }

    
  const generateVegetarianList = (recipes) => {    
    let filteredList = []
    for(let i=0; i < recipes.length; i++){
      let counter = 0
      for(let j=0; j < recipes[i].ingredients.length; j++){
        if(recipes[i].ingredients[j].vegetarian == true){
          counter += 1
        } 
      }
      if(counter == recipes[i].ingredients.length){
        filteredList.push(recipes[i])
      }
    }
    return filteredList;
  }

  const veganRecipes = generateVeganList(sortedRecipes)

  const veganList = veganRecipes.map((recipe) => {
    return <RecipeList recipe = {recipe} key={recipe.id} handleRecipeFavourite={handleRecipeFavourite}/>
  })
  
  const vegetarianRecipes = generateVegetarianList(sortedRecipes)

  const vegetarianList = vegetarianRecipes.map((recipe) => {
    return <RecipeList recipe = {recipe} key={recipe.id}/>
  })
  

  const handleVeganClick = () => {
      setSelectedRecipeList(veganList)
  }
  const handleAllClick = () => {
      setSelectedRecipeList(recipeList)
  }
  const handleVegetarianClick = () => {
      setSelectedRecipeList(vegetarianList)
  }
  


  return (
    <>
        <div className='filter-by-recipe-btn'>
        <p>Filter recipes by:</p>
        <input type="radio" value="all" name="radio" defaultChecked onClick={handleAllClick} /> All
        <input type="radio" value="vegetarian" name="radio" onClick={handleVegetarianClick}/> Vegetarian
        <input type="radio" value="vegan" name="radio" onClick={handleVeganClick} /> Vegan
        </div>
    <div className='recipe-list-all'>
        {selectedRecipeList}
    </div>
    </>
  )
}

export default RecipesAll