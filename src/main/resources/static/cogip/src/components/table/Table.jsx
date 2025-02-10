import React, { useState, useEffect } from "react";
import './Table.css';
import fetchData from "../apirequest.js";

const DataTable = ({ activePage, dataType = 'paginated?page=0&size=10' }) => {
  const [data, setData] = useState([]);
  
  useEffect(() => {
    const loadData = async () => {
      try {
        const fetchedData = await fetchData(activePage, dataType);
        setData(fetchedData || []);
        console.log('fetchedData: ', fetchedData);
      } catch (error) {
        console.error("Erreur lors du chargement des données :", error);
        setData([]);
      }
    };
    loadData();
  }, [activePage, dataType]); 

  return (
    <div>
      <table>
        <thead>
          <tr>
            <th>{activePage === 'invoice' ? 'Reference' : 'Name'}</th>
            <th>
              {activePage === 'company' ? 'TVA' :
               activePage === 'invoice' ? 'Due Date' : 'Phone Number'}
            </th>
            <th>
              {activePage === 'company' ? 'Country' :
               activePage === 'invoice' ? 'Company Name' : 'Mail'}
            </th>
            <th>
              {activePage === 'company' ? 'Company Type' :
               activePage === 'invoice' ? 'Creation Date' : 'Company Name'}
            </th>
            {activePage === 'invoice' ? null : <th>Creation Date</th>}                 
          </tr>
        </thead>
        <tbody>
        {data.length > 0 ? (data.map((row, index) => (
          <tr
            key={index}
            style={{ backgroundColor: index % 2 !== 0 ? "#f5f5f5" : "#ffffff" }}
          >
            {row.map((cell, cellIndex) => (<td key={cellIndex}>{cell}</td>))}
          </tr>
          ))) : (
          <tr>
            <td colSpan="5">Aucune donnée disponible</td>
          </tr>
          )}
        </tbody>
      </table>
    </div>
  );
};

export default DataTable;
