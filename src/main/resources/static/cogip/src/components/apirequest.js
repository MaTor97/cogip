const companyUrl = 'http://localhost:8080/api/company/all';
let companyObject = [];

const fetchDataCompany = async () => {
  const response = await fetch(url, {});
  const result = await response.json();
  companyObject = result.map(el => [el.name, el.tva, el.country, el.typeName, el.createdAt]);
};

// Call fetchData when needed
fetchData();

export { companyObject };

const invoicesUrl = 'http://localhost:8080/api/invoices/all';
let invoicesObject = [];

const fetchDataInvoices = async () => {
  const response = await fetch(url, {});
  const result = await response.json();
  invoicesObject = result.map(el => [el.ref, el.dueDate, el.companyName, el.createdAt]);
};

// Call fetchData when needed
fetchData();

export { invoicesObject };

const contactUrl = 'http://localhost:8080/api/contact/all';
let contactObject = [];

const fetchDatacontact = async () => {
  const response = await fetch(url, {});
  const result = await response.json();
  contactObject = result.map(el => [el.name, el.phone, el.mail, el.companyName, el.createdAt]);
};

// Call fetchData when needed
fetchData();

export { contactObject };
