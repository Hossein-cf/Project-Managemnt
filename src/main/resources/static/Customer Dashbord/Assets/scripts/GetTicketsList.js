let currentOBJ = JSON.parse(localStorage.getItem("CUSTOMER_OBJECT"))

let obj = {
    id: currentOBJ.id
}
let tbody = document.getElementById('ticketsList')

fetch('http://localhost:8086/getTicketsForCustomer', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json;charset=utf-8'
    },
    body: JSON.stringify(obj)
})
    .then(response => response.json())
    .then(res => {
        const array = res
        for (const item of array) {
            let tr = document.createElement('tr')
            tr.className = 'rtl-table-texts'
            tr.setAttribute('onclick','clickTicket(this)')

            let td_id = document.createElement('td')
            td_id.innerText = item.id
            tr.appendChild(td_id)

            let td_subject = document.createElement('td')
            td_subject.innerText = item.subject

            tr.appendChild(td_subject)


            let td_generateTime = document.createElement('td')
            td_generateTime.innerText = item.generateTime
            tr.appendChild(td_generateTime)

            let td_ticketPriority = document.createElement('td')
            td_ticketPriority.innerText = item.ticketPriority
            tr.appendChild(td_ticketPriority)

            let td_condition = document.createElement('td')
            td_condition.innerText = item.condition
            tr.appendChild(td_condition)
            tbody.appendChild(tr)
        }


    })

function clickTicket(x) {
    console.log(x)
    var A = x.getElementsByTagName("td")[0]
    console.log(A.innerHTML)
    localStorage.setItem("TICKET_ID",A.innerHTML)
    window.location.href = 'http://localhost:8086/TicketPage_Customer'


}