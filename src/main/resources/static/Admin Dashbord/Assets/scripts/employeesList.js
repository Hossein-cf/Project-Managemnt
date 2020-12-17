// needed a fetch to get all employees of part
let partId = localStorage.getItem("DEPARTMENT_ID")
let arrayOfEmployees
fetch('http://localhost:8086/getAllEmployeeOfCurrentPart', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json;charset=utf-8'
    },
    body: JSON.stringify({
        id:partId
    })
}).then(response => response.json())
    .then(res => {
        console.log(res)
        arrayOfEmployees=res
        setInfosToTable()
    })



// needed a method to set data in table

function setInfosToTable() {
    let tbody = document.getElementById('partEmployees')

    for (const item of arrayOfEmployees) {

        let tr = document.createElement('tr')
        tr.className = 'rtl-table-texts'
       // tr.setAttribute('onclick','saveEmployeeInfo(this)')

        let td_id = document.createElement('td')
        td_id.innerText = item.id
        tr.appendChild(td_id)


        let td_name = document.createElement('td')
        td_name.innerText = item.name
        tr.appendChild(td_name)



        let td_phoneNumber = document.createElement('td')
        td_phoneNumber.innerText = item.phoneNumber
        tr.appendChild(td_phoneNumber)

        let td_email= document.createElement('td')
        td_email.innerText = item.email
        tr.appendChild(td_email)

        let td_roll= document.createElement('td')
        td_roll.innerText = "....."
        tr.appendChild(td_roll)

        let td_condition= document.createElement('td')
        td_condition.innerText = item.condition
        tr.appendChild(td_condition)


        let td_dropDown = document.createElement('td')
        td_dropDown.className = 'dropdown option-icone-container'

        let iTag = document.createElement('i')
        iTag.className = 'bx bx-down-arrow options-icon'
        iTag.setAttribute('data-toggle',"dropdown")
        iTag.setAttribute('onclick','saveEmployeeInfo(this)')

        let ul = document.createElement('ul')
        ul.className = 'dropdown-menu'

        let li1 = document.createElement('li')
        let li2 = document.createElement('li')

        li1.className = 'dropdown-item'
        li2.className = 'dropdown-item'


        let a1 = document.createElement('a')
        a1.innerHTML = 'ایجاد تیکت'

        a1.href = 'http://localhost:8086/createTicket_Admin'
        li1.appendChild(a1)

        let a2 = document.createElement('a')
        a2.innerHTML = 'ایجاد ایمیل'
        li2.appendChild(a2)

        ul.appendChild(li1)
        ul.appendChild(li2)


        td_dropDown.appendChild(iTag)
        td_dropDown.appendChild(ul)



        tr.appendChild(td_dropDown)

        tbody.appendChild(tr)
    }

}

function saveEmployeeInfo(x) {
    console.log(x)
    let tr = (x.parentElement).parentElement
    var A = tr.getElementsByTagName("td")[0]
    let employeeName = tr.getElementsByTagName("td")[1]
    console.log(A.innerHTML)
    localStorage.setItem("EMPLOYEE_ID",A.innerHTML)
    localStorage.setItem("EMPLOYEE_NAME",employeeName.innerHTML)
    // window.location.href = 'http://localhost:8086/createTicket_Admin'
}

//TODO remember to add employee condition to backend