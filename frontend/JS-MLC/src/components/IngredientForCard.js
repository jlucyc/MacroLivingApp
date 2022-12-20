import React from 'react'

const IngredientForCard = ({ingredient}) => {
  return (
   <>
    <li> 
        <div className="amount">{ingredient.quantity}</div>
        <div className="ingredient">{ingredient.name}</div>
    </li>
   </>
  )
}

export default IngredientForCard