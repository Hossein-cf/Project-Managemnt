let user = {
    name: 'John',
    Email: 'Smith'
};

fetch('http://localhost:8080/companyPost',{
    method: 'POST',
    headers: {
        'Content-Type': 'application/json;charset=utf-8'
    },
    body: JSON.stringify(user)
})
    .then(response => response.json())
    .then(res => console.log(res))