let obj = {
    // TODO get company id
    id: 596595
}
let tbody = document.getElementById('departmentsList')

fetch('http://localhost:8086/GetPartsOfCompany', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json;charset=utf-8'
    },
    body: JSON.stringify({
        id:596595
    })
})
    .then(response => response.json())
    .then(res => {
        console.log(res)
        let array = res
        for (const item of array) {
            let tr = document.createElement('tr')
            tr.className = 'rtl-table-texts'
            tr.setAttribute('onclick','openDepartmentPage(this)')

            let td_id = document.createElement('td')
            td_id.innerText = item.id
            tr.appendChild(td_id)


            let td_name = document.createElement('td')
            td_name.innerText = item.name
            tr.appendChild(td_name)
            let adminID = {
                id: item.adminId
            }

            let td_adminId = document.createElement('td')
            fetch('http://localhost:8086/employeeGet', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json;charset=utf-8'
                },
                body: JSON.stringify(adminID)
            })
                .then(response => response.json())
                .then(res => {
                        console.log(res.name)
                        td_adminId.innerText = res.name

                    }
                )
            tr.appendChild(td_adminId)


            let td_create = document.createElement('td')
            td_create.innerText = item.createTime
            tr.appendChild(td_create)

            let td_activity = document.createElement('td')
            td_activity.innerText = item.partActivity
            tr.appendChild(td_activity)
            tbody.appendChild(tr)
        }
        // array.foreach(item => {
        //     let tr = document.createElement('tr')
        //
        //     let td_id = document.createElement('td')
        //     td_id.innerText = item.id
        //     tr.appendChild(td_id)
        //
        //     let td_name = document.createElement('td')
        //     td_name.innerText = item.name
        //     tr.appendChild(td_name)
        //
        //     let td_adminId = document.createElement('td')
        //     td_adminId.innerText = item.adminId
        //     tr.appendChild(td_adminId)
        //
        //     let td_create = document.createElement('td')
        //     td_create.innerText = item.createTime
        //     tr.appendChild(td_create)
        //
        //     let td_activity = document.createElement('td')
        //     td_activity.innerText = item.partActivity
        //     tr.appendChild(td_activity)
        //     tbody.appendChild(tr)
        // })
    })


function openDepartmentPage(x) {
    console.log(x)
    var id = x.getElementsByTagName("td")[0]
    var name = x.getElementsByTagName("td")[1]

    console.log(id.innerHTML)
    localStorage.setItem("DEPARTMENT_ID",id.innerHTML)
    localStorage.setItem("DEPARTMENT_NAME",name.innerHTML)
    window.location.href = 'http://localhost:8086/DepartmentPage_Company'
}