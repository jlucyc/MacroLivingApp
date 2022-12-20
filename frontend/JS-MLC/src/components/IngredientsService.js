const baseURL = 'http://localhost:8080/api/ingredients/'

export const getIngredients = () => {
    return fetch(baseURL)
        .then(res => res.json())
}
export const updateIngredients = (payload) => {
    const id = payload.id;
    return fetch(baseURL + id, {
        method: 'PATCH',
        body: JSON.stringify(payload),
        headers:{'Content-Type': 'application/json'}
    })
}