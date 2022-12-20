import React from 'react'
import FavouriteRecipe from './FavouriteRecipe'

const FavouritesPage = ({recipes, handleRecipeFavourite}) => {

    const recipeList = () => {
        let favouritesList = []
        for(let i=0; i < recipes.length; i++){
            if(recipes[i].favourite == true){
                favouritesList.push(recipes[i])
            }
        } return favouritesList
    } 

    const filteredList = recipeList()

    const favouriteRecipes = filteredList.map((recipe) => {
        return <FavouriteRecipe recipe = {recipe} key= {recipe.id} handleRecipeFavourite={handleRecipeFavourite}/>
      
    })
  
  
    return (
        <div className='fav-page'>
    <div className='recipe-list-fav'>
        <br></br>
    {favouriteRecipes}
    </div>
    </div>
  )
}

export default FavouritesPage;