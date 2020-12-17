let manager = JSON.parse(localStorage.getItem("MANAGER_OBJECT"))

fetch('http://localhost:8086/getProjectsForCurrentManager', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json;charset=utf-8'
    },
    body: JSON.stringify(manager)
}).then((response) => response.json())
    .then(data => {

    })