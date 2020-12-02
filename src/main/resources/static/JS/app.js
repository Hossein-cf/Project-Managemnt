let user = {
    name: 'John',
    surname: 'Smith'
};

fetch('http://localhost:8080/test1',{
    method: 'POST',
    headers: {
        'Content-Type': 'application/json;charset=utf-8'
    },
    body: JSON.stringify(user)
})
    .then(response => response.json())
    .then(res => console.log(res))