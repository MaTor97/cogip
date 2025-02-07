import React from 'react'
import DataTable from '../../components/table/Table.jsx'
import './MainContent.css'
import { TableTitleSVG } from '../svg'

function MainContent({activePage}) {
    return (
        <main>
            {activePage !== 'home' ? 
            <div className='notHome'>
                <div className='notHomeTitle'>
                    <h2>
                        All {activePage === 'company' ? 'companies' : `${activePage}s`}
                    </h2>
                    <TableTitleSVG />
                    <input placeholder={'Search '+ activePage +'...'}/>
                </div>
                <DataTable activePage={activePage} /> 
            </div>:
            <div className='home'>
                <h2>Last invoices</h2> 
                <DataTable activePage={'invoice'} />
                <h2>Last contacts</h2>
                <DataTable activePage={'contact'} />  
                <h2>Last companies</h2>
                <DataTable activePage={'company'} />
            </div>}          
        </main>
    );
}

export default MainContent