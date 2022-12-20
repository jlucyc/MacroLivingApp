const baseURL = 'http://localhost:8080/api/users/'

export const getUsers = () => {
    return fetch(baseURL)
        .then(res => res.json())
}

export const addUser = (payload) => {
    const id = payload.id;

    return fetch(baseURL + id, {
        method: 'PATCH',
        body: JSON.stringify(payload),
        headers:{'Content-Type': 'application/json'}

    })
}

