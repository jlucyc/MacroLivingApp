import React, {useRef, useState} from 'react'
import './RecipeResult.css'
import CardContents from './CardContents';


const RecipeResult = ({recipe, handleRecipeFavourite,handleAddToMealPlan}) => {
    
    const [visibleDetails, setVisibleDetails] = useState(false);
    
      const handleClick = (() => {
        handleRecipeFavourite(recipe.id)
      })


      const hearted = require("../images/Hearted.png")
      const unhearted= require("../images/Unhearted.png")

      const favouriteSelectedText = recipe.favourite ? <img width='20px' src={hearted}/>  : <img width='20px' src={unhearted}/>



    function byID(id) {
        return document.getElementById(id);
      }
      const handleToggle = () => {
        if (byID(recipe.name).classList.contains("closed")) {
          byID(recipe.name).classList.remove("closed");
          setVisibleDetails(!visibleDetails)
          bottomRef.current?.scrollIntoView({behavior: 'smooth',});
        } else {
          byID(recipe.name).classList.add("closed");
      }
    }
    
    const bottomRef = useRef(null);
    
    return (
        <>
    <span className="closed" id={recipe.name}>
        <div className='recipe-card'>
        <div ref={bottomRef}/>
        <header onClick={handleToggle} id="toggle">
        <img className="header" src={recipe.imgUrl}/>
        </header>
        <div className="title">{recipe.name}<button className='fav-btn' 
        type="submit" onClick={handleClick}>{favouriteSelectedText}</button></div> 
    <CardContents recipe={recipe} handleRecipeFavourite={handleAddToMealPlan} handleAddToMealPlan={handleAddToMealPlan} />
    </div>
    </span>


        </>
      )
}

export default RecipeResult


