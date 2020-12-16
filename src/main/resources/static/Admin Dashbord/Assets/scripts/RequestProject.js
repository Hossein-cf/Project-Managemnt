let tbody = document.getElementById('projectRequestsList')
let customersName=[]
let array
fetch('http://localhost:8086/getNotStartedProjects')
    .then(response => response.json())
    .then(res => {
        array = res
        console.log(array)
        getCustomerName()
    })

function getCustomerName() {
    let customersId=[]
    for (i = 0; i < array.length; i++) {
       customersId.push(array[i].customerId)
    }
    console.log(customersId)
    fetch('http://localhost:8086/getCustomerNameById', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },

        body: JSON.stringify({
            list:customersId
        })
    }).then((response) => response.json())
        .then(data => {
            customersName = data
            console.log(customersName)


                setInfoToTable()

        })
}

function setInfoToTable() {
    for (i = 0; i < array.length; i++) {
        let tr = document.createElement('tr')
        tr.className = 'rtl-table-texts'
        tr.setAttribute('onclick', 'openModal(this)')

        let td_id = document.createElement('td')
        td_id.innerText = array[i].id
        tr.appendChild(td_id)

        let td_subject = document.createElement('td')
        td_subject.innerText = array[i].subject

        tr.appendChild(td_subject)


        let td_customerName = document.createElement('td')
        td_customerName.innerText = customersName[i]
        tr.appendChild(td_customerName)

        let td_generateTime = document.createElement('td')
        td_generateTime.innerText = array[i].generateTime
        tr.appendChild(td_generateTime)

        let td_condition = document.createElement('td')
        td_condition.innerText = array[i].condition
        tr.appendChild(td_condition)
        tbody.appendChild(tr)
    }

}

let projectObj
function openModal(x) {
    var projectId = x.getElementsByTagName("td")[0]
    console.log(projectId.innerHTML)
    localStorage.setItem("PROJECT_ID",projectId.innerHTML)
    fetch('http://localhost:8086/getProjectByID', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },

        body: JSON.stringify({

            id:projectId.innerHTML
        })
    }).then((response) => response.json())
        .then(data => {
            projectObj = data
            console.log(projectObj.description)

            setInfoToModal()


        })


}
//TODO
// function getFiles(){
//     fetch('http://localhost:8086/getCustomerNameById', {
//         method: 'POST',
//         headers: {
//             'Content-Type': 'application/json;charset=utf-8'
//         },
//
//         body: JSON.stringify({
//             list:JSON.stringify({
//                 id
//             })
//         })
//     }).then((response) => response.json())
//         .then(data => {
//             customersName = data
//             console.log(customersName)
//
//
//             setInfo()
//
//         })
// }

function setInfoToModal(){
    document.getElementById('projectSubject').value = projectObj.subject
    document.getElementById('projectDeadLine').value = projectObj.deadLine
    document.getElementById('projectDescription').value = projectObj.description
    let a = document.createElement('a')
    a.setAttribute("href",projectObj.documents)
    a.setAttribute("download","")
    a.innerHTML = "file"
    document.getElementById('fileLinks').appendChild(a)

    $('#assignProjectToManager').modal('show');


}

document.getElementById('createProjectBtn').addEventListener('click',(e)=>{
    e.preventDefault()
    let projectInfos = {
        subject: document.getElementById('projectSubject').value,
        deadLine:document.getElementById('projectDeadLine').value,
        description:document.getElementById('projectDescription').value,
        documents:projectObj.documents,
        projectId:projectObj.id
    }
    localStorage.setItem("PROJECT-OBJ",JSON.stringify(projectInfos))
    window.location.href="http://localhost:8086/createProject_Admin"
})