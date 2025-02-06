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

const invoiceUrl = 'http://localhost:8080/api/invoice/all';
let invoiceObject = [];

const fetchDataInvoices = async () => {
  const response = await fetch(url, {});
  const result = await response.json();
  invoiceObject = result.map(el => [el.ref, el.dueDate, el.companyName, el.createdAt]);
};

// Call fetchData when needed
fetchData();

export { invoiceObject };

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
