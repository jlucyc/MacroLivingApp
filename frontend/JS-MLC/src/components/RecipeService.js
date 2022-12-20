
const baseURL = 'http://localhost:8080/api/recipes/'

export const getRecipes = () => {
    return fetch(baseURL)
        .then(res => res.json())
        
}

export const updateRecipe = (payload) => {
    const id = payload.id;
    
    return fetch(baseURL + id, {
        method: "PATCH",
        body: JSON.stringify(payload),
        headers:{'Content-Type': 'application/json'}

    })
}