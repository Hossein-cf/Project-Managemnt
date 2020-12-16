let Admin_Object = JSON.parse(localStorage.getItem('ADMIN_OBJECT'))
console.log(Admin_Object)
let partName = localStorage.getItem('PART_NAME')
let customersName
document.getElementById('adminName').innerHTML = Admin_Object.name
// ??????????????
// document.getElementById('partEmail').innerText =

fetch('http://localhost:8086/getPartByName', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json;charset=utf-8'
    },
    body: JSON.stringify({
        name: partName
    })
})
    .then(response => response.json())
    .then(res => {
        console.log(res)
        document.getElementById('partEmail').innerText = res.email
    })

////////////////////////////

fetch('http://localhost:8086/getNumberOfCustomersForCompany', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json;charset=utf-8'
    },
    body: JSON.stringify({
        id: 596595
    })
})
    .then(response => response.json())
    .then(res => {
        console.log(res)
        document.getElementById('customers-number').innerText = res
    })

////////////////////////
let tbody = document.getElementById('projects-table-tbody')
let startedProjectList

let listForNumberOfProjectAgents
fetch('http://localhost:8086/getStartedProjects')
    .then(response => response.json())
    .then(res => {
        startedProjectList = res
        console.log(res)
        getCustomersName()
        // setStartedProjectToTable()
    })


function setStartedProjectToTable() {
    for (let i = 0; i < startedProjectList.length; i++) {
        let tr = document.createElement('tr')
        tr.className = 'rtl-table-texts'
        //tr.setAttribute('onclick', 'openModal(this)')

        let td_id = document.createElement('td')
        td_id.innerText = startedProjectList[i].id
        tr.appendChild(td_id)

        let td_subject = document.createElement('td')
        td_subject.innerText = startedProjectList[i].subject

        tr.appendChild(td_subject)

        let td_generateTime = document.createElement('td')
        td_generateTime.innerText = startedProjectList[i].generateTime
        tr.appendChild(td_generateTime)

        let td_customerName = document.createElement('td')
        td_customerName.innerText = customersName[i]
        tr.appendChild(td_customerName)



        let td_condition = document.createElement('td')
        td_condition.innerText = listForNumberOfProjectAgents[i]
        tr.appendChild(td_condition)
        tbody.appendChild(tr)
    }

}

function getCustomersName() {
    let customersId = []
    let projectsId = []

    for (let i = 0; i < startedProjectList.length; i++) {
        customersId.push(startedProjectList[i].customerId)
        projectsId.push(startedProjectList[i].id)
    }
    fetch('http://localhost:8086/getCustomerNameById', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            list: customersId
        })
    })
        .then(response => response.json())
        .then(res => {
            customersName = res
            console.log(res)
            getAgentNumberForProject(projectsId)
        })

}

function getAgentNumberForProject(list) {

    fetch('http://localhost:8086/getNumberOfEmployeeInCurrentProjects', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            list: list
        })
    })
        .then(response => response.json())
        .then(res => {
            listForNumberOfProjectAgents = res
            console.log(res)
            setStartedProjectToTable()
        })
}

