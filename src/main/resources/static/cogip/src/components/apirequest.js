function formatDate(dateString) {
  if (!dateString) return '';
  const date = new Date(dateString);
  return date.toLocaleDateString('fr-FR'); 
}

const fetchData = async (endpoint, dataType) => {
  try {
    const response = await fetch(`http://localhost:8080/api/${endpoint}/${dataType}`);
    if (!response.ok) {
      throw new Error(`HTTP error! Status: ${response.status}`);
    }
    const result = await response.json();

    const formatter = (el) => {
      switch (endpoint) {
        case 'company':
          return [el.name, el.tva, el.country, el.typeName, formatDate(el.createdAt)];
        case 'invoice':
          return [el.ref, formatDate(el.dueDate), el.companyName, formatDate(el.createdAt)];
        case 'contact':
          return [el.name, el.phone, el.mail, el.companyName, formatDate(el.createdAt)];
        default:
          return el;
      }
    };

    return result.map(formatter);
  } catch (error) {
    console.error('Error fetching data:', error);
    return [];
  }
};

export default fetchData;