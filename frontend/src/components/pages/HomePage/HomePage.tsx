import React from 'react'
import { Link } from 'react-router-dom'

export default function HomePage() {
  return (
    <ul><Link to={"/login"}>login</Link><br /><Link to={"/register"}>register</Link></ul>
  )
}
