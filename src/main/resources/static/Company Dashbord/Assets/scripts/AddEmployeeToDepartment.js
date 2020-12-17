let tbody = document.getElementById('employees-tbody')
let apply_btn = document.getElementById('apply-btn')


if(tbody.childElementCount == 0)
    apply_btn.classList.add('hide')


// TODO fetch to get employees that havent part





// TODO set employees to table

function setInfosToTable() {
    let tr = document.createElement('tr')
    tr.className = 'rtl-table-texts'
    //  tr.setAttribute('onclick', 'openModal(this)')



    let td_id = document.createElement('td')
    td_id.innerText = tickets[i].id
    tr.appendChild(td_id)
    tr.setAttribute('onclick','goToTicketPage(this)')

    let td_DestinationName = document.createElement('td')
    //TODO remember to add roll of employee beside name
    td_DestinationName.innerText = generatorsName[i]
    tr.appendChild(td_DestinationName)

    let td_subject = document.createElement('td')
    td_subject.innerText = tickets[i].subject

    tr.appendChild(td_subject)

    let td_generateTime = document.createElement('td')
    td_generateTime.innerText = tickets[i].generateTime
    tr.appendChild(td_generateTime)

    let td_condition = document.createElement('td')
    td_condition.innerText = tickets[i].condition
    tr.appendChild(td_condition)
    let td_ticketPriority = document.createElement('td')
    td_ticketPriority.innerText = tickets[i].ticketPriority
    tr.appendChild(td_ticketPriority)

    tbody.appendChild(tr)
}








let trs  = []
let EmployeesId = []

apply_btn.addEventListener('click' , ()=>{
    let array = document.getElementsByClassName('check')


    for (const item of array) {

        if(item.checked === true){
            trs.push((item.parentElement).parentElement)
        }

    }

    for (const item of trs) {

        let td =  item.getElementsByTagName("td")[0]
        EmployeesId.push(td.innerHTML)
    }


    //TODO fetch to post employees id





})
