import React from 'react';
import './Header.css';
import { HeaderSVG } from '../svg';
import HomeIntro from './HomeIntro.jsx'

const Header = ({activePage, setActivePage}) => {
    return (
        <header style={activePage === 'home' ? {height: '787px'} : {}}>
            <div className="header">
                <nav>
                    <h1>COGIP</h1>
                    <ul>
                        <li className={activePage === 'home' ? 'actual' : ""}>
                            <a 
                                href="#home"
                                className={activePage === 'home' ? 'active' : ''} 
                                onClick={() => setActivePage('home')}
                            >Home</a>
                        </li>
                        <li className={activePage === 'invoices' ? 'actual' : ""} >
                            <a 
                                href="#invoices"
                                className={activePage === 'invoices' ? 'active' : ''} 
                                onClick={() => setActivePage('invoices')}
                            >Invoices</a>
                        </li>
                        <li className={activePage === 'companies' ? 'actual' : ""}>
                            <a 
                                href="#companies"
                                className={activePage === 'companies' ? 'active' : ''} 
                                onClick={() => setActivePage('companies')}
                            >Companies</a>
                        </li>
                        <li className={activePage === 'contact' ? 'actual' : ""}>
                            <a 
                                href="#contact"
                                className={activePage === 'contact' ? 'active' : ''} 
                                onClick={() => setActivePage('contact')}
                            >Contact</a>
                        </li>
                    </ul>
                </nav>
                <nav>
                    <ul>
                        <li className="signup"><a href="#signup">Sign Up</a></li>
                        <li><a href="#login">Login</a></li>
                    </ul>
                </nav>
            </div>
            {activePage === 'home' ? <HomeIntro />: null}
            <HeaderSVG activePage={activePage}/>
            </header>
    );
};

export default Header;