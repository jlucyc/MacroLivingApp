import React, {useState, useEffect} from 'react'
import RecipesAll from '../components/RecipesAll'
import {BrowserRouter as Router, Routes, Route, Link} from 'react-router-dom'
import HamburgerMenu from '../components/HamburgerMenu'
import Homepage from '../components/Homepage'
import RecipeService, { getRecipes, updateRecipe } from '../components/RecipeService'
import Recipe from '../components/Recipe'
import { addUser, getUsers } from '../components/UserService'
import { getIngredients} from '../components/IngredientsService'
import MealPlan from '../components/MealPlan'
import Footer from '../components/Footer'
import FavouritesPage from '../components/FavouritesPage'




const MainContainer = () => {
  
  const [recipes, setRecipes] = useState([]);

  const [users, setUsers] = useState([]);

  const [ingredients, setIngredients] = useState([]);

  const [clearSelectedIngredients, setClearSelectedIngredients] = useState([])

  useEffect(() => {
    getRecipes().then((allRecipes) => {setRecipes(allRecipes)});
    getUsers().then((allUsers) => {setUsers(allUsers)});
    getIngredients().then((allIngredients) => {setIngredients(allIngredients)});
    getIngredients().then((allIngredients) => {setClearSelectedIngredients(allIngredients)});

},[],[],[],[])

const handleIngredientSelected = ((id) => {
  const updatedIngredients = ingredients.map((ingredient) => {
    return ingredient.id == id
      ?{...ingredient, selected: !ingredient.selected} : ingredient
  })
  setIngredients(updatedIngredients);
})

const handleClearAll = (() => {
  setIngredients(clearSelectedIngredients)
})

  
const handleRecipeFavourite = ((id) => {
  const updatedRecipes = recipes.map((recipe) => {
    return recipe.id == id
    ?{...recipe, favourite: !recipe.favourite} : recipe
  })

  const filteredRecipe = updatedRecipes.find((recipe)=>{return recipe.id==id})
  updateRecipe(filteredRecipe)
  setRecipes(updatedRecipes)
})

const handleAddToMealPlan = ((id) => {
    
    const recipesInMealPlan = recipes.filter((recipe) => recipe.mealPlan == true)

    if (recipesInMealPlan.length < 3){
        const updatedRecipes = recipes.map((recipe) => {
            return recipe.id == id

        ?{...recipe, mealPlan: !recipe.mealPlan} : recipe})

        const filteredRecipe = updatedRecipes.find((recipe)=>{return recipe.id==id})
            updateRecipe(filteredRecipe)
            setRecipes(updatedRecipes)
    }else{
      const updatedRecipes = recipes.map((recipe) => {
        return recipe.id == id
        
        ?{...recipe, mealPlan: false} : recipe})
        
        const filteredRecipe = updatedRecipes.find((recipe)=>{return recipe.id==id})
      
            updateRecipe(filteredRecipe)
            setRecipes(updatedRecipes)
            }
          }
  )

const updateUser = ((formData) => {
    const updatedUser = users
    updatedUser[0].protein = formData.protein
    updatedUser[0].carbs = formData.carbs
    updatedUser[0].fat = formData.fat
    updatedUser[0].fibre = formData.fibre
    updatedUser[0].calories = formData.calories
    setUsers(updatedUser)

    const filteredUser = updatedUser.find((user)=>{return user.id==1})
    addUser(filteredUser)

  })
  
  const userMealPlan = users.map((user) => {
    return  <MealPlan recipes={recipes} handleRecipeFavourite={handleRecipeFavourite} handleAddToMealPlan={handleAddToMealPlan} user = {user} key={user.id} />
  })


  const logo = require('../images/MacroLivingLogoWhite.png')

    
    return (
      <>
    <main>
        <Router>
        <div className="sidebars">
        <HamburgerMenu />
        <Link to="/"><img height='100px' src={logo}/></Link>
        {userMealPlan} 
        </div>
             {/* <br></br> */}
                <Routes>
                    <Route exact path="/" element={<Homepage users={users} ingredients={ingredients} recipes={recipes} handleIngredientSelected={handleIngredientSelected} updateUser = {updateUser} handleRecipeFavourite={handleRecipeFavourite} handleAddToMealPlan={handleAddToMealPlan} handleClearAll={handleClearAll}/>}/>
                    <Route exact path="/recipes-all" element={<RecipesAll recipes = {recipes} handleRecipeFavourite={handleRecipeFavourite}/>}/>
                    <Route exact path="/recipe/:id" element={<Recipe recipes={recipes} handleRecipeFavourite={handleRecipeFavourite} handleAddToMealPlan={handleAddToMealPlan}/>}/>
                    <Route exact path="/recipes-fav" element={<FavouritesPage recipes={recipes} handleRecipeFavourite = {handleRecipeFavourite}/>}/>
                </Routes>
        </Router>
    </main>
    {/* <br></br>
    <br></br>
    <br></br> */}

    <footer><Footer className="footer"/></footer>
 
      </>
  )
}

export default MainContainer