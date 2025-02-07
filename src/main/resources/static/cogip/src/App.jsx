import { useState } from 'react'
import './App.css'
import './components/header/Header.jsx'
import Header from './components/header/Header.jsx'
import HomeOutro from './components/homeOutro/HomeOutro.jsx'
import Footer from './components/footer/Footer.jsx'
import DataTable from './components/table/Table.jsx'


function App() {
  const [activePage, setActivePage] = useState('home')

  return (
    <>
      <Header activePage={activePage} setActivePage={setActivePage} />
      {activePage !== 'home' ? <DataTable activePage={activePage} /> :
        <div> 
          <DataTable activePage={'invoice'} />
          <DataTable activePage={'contact'} />  
          <DataTable activePage={'company'} />
        </div>}
      {activePage === 'home' ? <HomeOutro /> : null}
      <Footer activePage={activePage} />
    </>
  )
}

export default App
