let tbody = document.getElementById('employees-tbody')
let apply_btn = document.getElementById('apply-btn')



// TODO fetch to get employees that havent part

let arrayOfEmployees_DontHavePart
fetch('http://localhost:8086/getAllEmployeesDontHavePart')
    .then((response) => response.json())
    .then(data => {
        console.log(data)
        arrayOfEmployees_DontHavePart = data
        setInfosToTable()
    })


function setInfosToTable() {
    for (const item of arrayOfEmployees_DontHavePart) {


        let tr = document.createElement('tr')
        tr.className = 'rtl-table-texts'


        let td_id = document.createElement('td')
        td_id.innerText = item.id
        tr.appendChild(td_id)
        tr.setAttribute('onclick', 'goToTicketPage(this)')

        let td_Name = document.createElement('td')
        td_Name.innerText = item.name
        tr.appendChild(td_Name)

        let td_phoneNumber = document.createElement('td')
        td_phoneNumber.innerText = item.phoneNumber
        tr.appendChild(td_phoneNumber)

        let td_email = document.createElement('td')
        td_email.innerText = item.email
        tr.appendChild(td_email)
        let td_roll = document.createElement('td')
        td_roll.innerText = "......"
        tr.appendChild(td_roll)

        let td_condition = document.createElement('td')
        td_condition.innerText = item.condition
        tr.appendChild(td_condition)


        let td_selectEmployee = document.createElement('td')
        let checkBox = document.createElement('input')
        checkBox.type = "checkbox";
        checkBox.className = 'check'
        td_selectEmployee.appendChild(checkBox)
        tr.appendChild(td_selectEmployee)

        tbody.appendChild(tr)
    }

    if (tbody.childElementCount == 0)
        apply_btn.classList.add('hide')

}


let EmployeesId = []

apply_btn.addEventListener('click', () => {
    let array = document.getElementsByClassName('check')


    for (const item of array) {

        if (item.checked === true) {
            let a = (item.parentElement).parentElement
            let td = a.getElementsByTagName("td")[0]
            EmployeesId.push(td.innerHTML)
        }

    }


    console.log(EmployeesId)
    console.log( localStorage.getItem("DEPARTMENT_ID"))

    fetch('http://localhost:8086/addEmployeeToPart', {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            ids: EmployeesId,
            partId: localStorage.getItem("DEPARTMENT_ID")
        })
    }).then((response) => response)
        .then(data => {
            alert("عملیات با موفقیت انجام شد")
            window.location.href="http://localhost:8086/AddEmployeeToDepartment_Company"
        })


})
