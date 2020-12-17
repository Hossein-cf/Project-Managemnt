// CUSTOMER_OBJECT
// let currentOBJ = JSON.parse(localStorage.getItem("CUSTOMER_OBJECT"))
var fileAddress
const AdminObject = JSON.parse(localStorage.getItem('ADMIN_OBJECT'))
if (localStorage.getItem("EMPLOYEE_NAME") !== null) {
    let employee_name = localStorage.getItem("EMPLOYEE_NAME")
    // employees are destination
    document.getElementById('destination').value = employee_name
    localStorage.removeItem("EMPLOYEE_NAME")


}


document.querySelector('#submitTicket').addEventListener('click', (e) => {
    e.preventDefault()
    if (localStorage.getItem("EMPLOYEE_ID") !== null){
        uploadFile(localStorage.getItem("EMPLOYEE_ID"), "کارمند")
        localStorage.removeItem("EMPLOYEE_ID")
    }else
        uploadFile("596595", "شرکت")

})
let sendData = (destinationID, type) => {

    let formData = new FormData();

    formData.append('companyId', 596595);
    formData.append('generateTime', moment().locale('fa').format('MMMM Do YYYY, h:mm '));

    formData.append("document", fileAddress)
    //setting partId
    formData.append("generatorId", AdminObject.partId)
    formData.append('subject', document.getElementById('subject').value)
    formData.append('generatorType', "بخش")

    formData.append('destinationType', "شرکت")

    // setting companyId
    formData.append('destinationId', 596595)

    var e = document.getElementById("priority");
    var priority = e.options[e.selectedIndex].text;
    formData.append('ticketPriority', priority)
    formData.append('description', document.getElementById('description').value)
    var object = {};
    formData.forEach(function (value, key) {
        object[key] = value;
    });
    var json = JSON.stringify(object);
    console.log(json)

// add department
    fetch('http://localhost:8086/addTicket', {

        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: json
    })
        .then(response => response)
        .then(res => {
            alert('تیکت شما با موفقیت ایجاد شد')
            // setTimeout(alert('Success'), 1000)
            window.location.href = 'http://localhost:8086/dahsbord_Admin'
        })
}

let uploadFile = (destinationID, type) => {

    const doc = document.querySelector('#document')
    const fd = new FormData()
    fd.append('files', doc.files[0])

    console.log(fd)


    fetch('http://localhost:8086/upload', {
        method: 'POST',

        body: fd
    })
        .then(response => response.json())
        .then(data => {
            fileAddress = data.filePath
            sendData(destinationID, type)
        })


}

function getPartId() {

    // var e = document.getElementById("partOfcompany");
    // var partOfCompany = e.options[e.selectedIndex].text;

    // let obj = {
    //     name: partOfCompany
    // }
    // console.log(obj)
    // fetch('http://localhost:8086/getPartId', {
    //
    //     method: 'POST',
    //     headers: {
    //         'Content-Type': 'application/json;charset=utf-8'
    //     },
    //     body: JSON.stringify(obj)
    // })
    //     .then(response => response.json())
    //     .then(res => {
    //         partId = res
    //         uploadFile()
    //     })
}

