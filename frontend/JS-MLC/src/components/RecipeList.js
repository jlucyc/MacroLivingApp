import React from 'react'
import { Link } from 'react-router-dom'



const RecipeList = ({recipe, handleRecipeFavourite}) => {

  const handleClick = (() => {
    handleRecipeFavourite(recipe.id)
  })
  
  const hearted = require("../images/Hearted.png")
  const unhearted= require("../images/Unhearted.png")
  
  const favouriteSelectedText = recipe.favourite ? <img width='20px' src={hearted}/>  : <img width='20px' src={unhearted}/>
  return (
    <>
    <div className='recipe-card-all'>
    <Link to={`/recipe/${recipe.id}`}>
    <span className="closed" id={recipe.name}>
    <header id="toggle">
    <img className="header" src={recipe.imgUrl}/>
    <div className="title">{recipe.name} <button className='fav-btn' type="submit" onClick={handleClick}>{favouriteSelectedText}</button></div>
    </header>
    </span>
    <br></br>
    </Link>
    </div>
    </>
  )
}

export default RecipeList

