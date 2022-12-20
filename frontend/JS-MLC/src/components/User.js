import React from 'react'
import { useState } from 'react'
import './User.css'

const User = ({updateUser, user}) => {

  const [formData, setFormData] = useState({
    protein: '',
    carbs: '',
    fat: '',
    fibre: '',
    calories: ''
    })
    
    const handleUserSubmit = ((e) => {
      e.preventDefault()
      updateUser(formData)
      alert("Thank you for inputting your macros ")
    })

  return (
    <div className='user-form'>
    <h2>Input Macros in grams</h2>
      <form onSubmit = {handleUserSubmit}>
      <label htmlFor="protein">Protein:</label>
      <input type="number" id="protein" name="protein" min="0" placeholder={user.protein} value={formData.protein} onChange={(e) => setFormData({...formData , protein: e.target.value})} required autoFocus/>
    
      <label htmlFor="carbs">Carbs:</label>
      <input type="number" id="carbs" name="carbs" min="0" placeholder={user.carbs} value={formData.carbs} onChange={(e) => setFormData({...formData , carbs: e.target.value})} required/>
     
      <label htmlFor="fat">Fat:</label>
      <input type="number" id="fat" name="fat" min="0" placeholder={user.fat} value={formData.fat} onChange={(e) => setFormData({...formData , fat: e.target.value})} required/>
    
      <label htmlFor="fibre">Fibre:</label>
      <input type="number" id="fibre" name="fibre" min="0" placeholder={user.fibre} value={formData.fibre} onChange={(e) => setFormData({...formData , fibre: e.target.value})} required/>
     
      <label htmlFor="calories">Calories:</label>
      <input type="number" id="calories" name="calories" min="0" placeholder={user.calories} value={formData.calories} onChange={(e) => setFormData({...formData , calories: e.target.value})} required/>
    
      <button className='macros-button' type="submit">Update Macros</button>
      
      
      

    
    
    
    </form>
    </div>
  )
}

export default User