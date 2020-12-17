let partName = localStorage.getItem("PART_NAME")


let tickets
let generatorsName
fetch('http://localhost:8086/getTicketsForPart', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json;charset=utf-8'
    },
    body: JSON.stringify({
        name: partName
    })
}).then(response => response.json())
    .then(res => {
        console.log(res)
        tickets = res
        getGeneratorName()
    })

function setTicketsToTable() {
    let tbody = document.getElementById('partTickets')

    for (let i = 0; i < tickets.length; i++) {
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

}

function getGeneratorName() {
    fetch('http://localhost:8086/getTicketsGeneratorIdName', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            list: tickets
        })
    }).then(response => response.json())
        .then(res => {
            console.log(res)
            generatorsName = res
            setTicketsToTable()
        })
}
function goToTicketPage(x){
    console.log(x)
    var A = x.getElementsByTagName("td")[0]
    console.log(A.innerHTML)
    localStorage.setItem("TICKET_ID",A.innerHTML)
    window.location.href = 'http://localhost:8086/ticketPage_Admin'

}