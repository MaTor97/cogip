import React, { useState, useEffect } from "react";
import './Table.css';
import fetchData from "../apirequest.js";

const DataTable = ({ activePage, dataType = 'all' }) => {
  const [data, setData] = useState([]);
  
  useEffect(() => {
    const loadData = async () => {
      const companyData = await fetchData('company', dataType);
      const invoiceData = await fetchData('invoice', dataType);
      const contactData = await fetchData('contact', dataType);

      const dataSets = {
        company: companyData,
        invoice: invoiceData,
        contact: contactData
      };

      setData(dataSets[activePage] || []);
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
          {data.length > 0 ? (
            data.map((row, index) => (
              <tr key={index}>
                {row.map((cell, cellIndex) => (
                  <td key={cellIndex}>{cell}</td>
                ))}
              </tr>
            ))
          ) : (
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
