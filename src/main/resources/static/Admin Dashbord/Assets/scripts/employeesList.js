// needed a fetch to get all employees of part

let arrayOfEmployees
fetch('http://localhost:8086/', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json;charset=utf-8'
    },
    body: JSON.stringify({

    })
}).then(response => response.json())
    .then(res => {

    })



// needed a method to set data in table

function setInfosToTable() {
    let tbody = document.getElementById('partEmployees')

    for (const item of arrayOfEmployees) {




    }

}

function f(x) {
    console.log(x)
    let tr = (x.parentElement).parentElement
    var A = tr.getElementsByTagName("td")[0]
    console.log(A.innerHTML)
    localStorage.setItem("EMPLOYEE_ID",A.innerHTML)
    window.location.href = 'http://localhost:8086/createTicket_Admin'
}

//TODO remember to add employee condition to backend