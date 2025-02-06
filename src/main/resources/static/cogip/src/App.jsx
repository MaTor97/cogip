import { useState } from 'react'
import './App.css'
import './components/header/Header.jsx'
import Header from './components/header/Header.jsx'
import HomeOutro from './components/homeOutro/HomeOutro.jsx'
import Footer from './components/footer/Footer.jsx'
import { companyObject } from './components/apirequest.js'


function App() {
  const [activePage, setActivePage] = useState('home')

  return (
    <>
      <Header activePage={activePage} setActivePage={setActivePage} />
      <div>{...companyObject}</div> 
      {activePage === 'home' ? <HomeOutro /> : null}
      <Footer activePage={activePage} />
    </>
  )
}

export default App
