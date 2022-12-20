import React from 'react'
import { Link } from 'react-router-dom'


const FavouriteRecipe = ({recipe, handleRecipeFavourite}) => {

    const hearted = require("../images/Hearted.png")
    const unhearted= require("../images/Unhearted.png")

    const favouriteSelectedText = recipe.favourite ? <img width='20px' src={hearted}/>  : <img width='20px' src={unhearted}/>

    const handleClick = (() => {
        handleRecipeFavourite(recipe.id)
      })
  
    return (
        <>
        <div className='recipe-card-all'>
        <Link to={`/recipe/${recipe.id}`}>
        <span className="closed" id={recipe.name}>
        <header id="toggle">
            <img className="header" src={recipe.imgUrl}/>
        </header>
            <div className="title">{recipe.name}</div>
        </span>
        <br></br>
        </Link>
        </div>
        </>
  )
}

export default FavouriteRecipe