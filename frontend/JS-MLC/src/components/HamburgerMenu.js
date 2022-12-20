import React from 'react'
import { Link } from 'react-router-dom'


const HamburgerMenu = () => {
  const logo = require('../images/MacroLivingLogoBlack.png')


  function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
  }
  
  function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
  }
  
  const hamburgerMenuIcon = require("../images/HamburgerIcon.png")
  
  return (
    <>
    <div onClick={closeNav} id="mySidenav" className="leftsidenav">
    <a href="javascript:void(0)" className="closebtn" onClick={closeNav}>&times;</a>
    <img className='hamburger-logo'  src={logo}/>
    <br></br>
    <br></br>
    <Link to="/">Home</Link>
    <Link to="/recipes-all">All Recipes</Link>
    <Link to="/recipes-fav">Favourites</Link>
    </div>
    <button className="hamburger-menu-btn" onClick={openNav}><img src={hamburgerMenuIcon} width='50px' alt="Hamburger Menu"/></button>
    </>
  )
}

export default HamburgerMenu