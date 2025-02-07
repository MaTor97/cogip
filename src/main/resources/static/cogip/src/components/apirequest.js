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
          return [el.name, el.tva, el.country, el.typeName, el.createdAt];
        case 'invoice':
          return [el.ref, el.dueDate, el.companyName, el.createdAt];
        case 'contact':
          return [el.name, el.phone, el.mail, el.companyName, el.createdAt];
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