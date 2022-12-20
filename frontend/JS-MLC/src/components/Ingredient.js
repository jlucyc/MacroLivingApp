import React from "react";

const Ingredient = ({ingredient}) => {

    return(
    <div> {ingredient.name}  : {ingredient.quantity}</div>
    )
}

export default Ingredient