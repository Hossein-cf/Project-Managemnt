// CUSTOMER_OBJECT
let currentOBJ = JSON.parse(localStorage.getItem("CUSTOMER_OBJECT"))
var fileAddress
var partId

const CustomerObject = JSON.parse(localStorage.getItem('CUSTOMER_OBJECT'))

document.querySelector('#customerName').value = CustomerObject.name
document.querySelector('#email').value = CustomerObject.email


document.querySelector('#submitTicket').addEventListener('click', (e) => {
    e.preventDefault()
    getPartId()


})
let sendData = () => {
    let formData = new FormData();

    formData.append('companyId', 596595);
    formData.append('generateTime', moment().locale('fa').format('MMMM Do YYYY, h:mm '));

    formData.append("document", fileAddress)
    formData.append("generatorId", currentOBJ.id)
    formData.append('subject', document.getElementById('subject').value)
    formData.append('generatorType', "مشتری")

    formData.append('destinationType', "بخش")


    formData.append('destinationId', partId)

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
            window.location.href = 'http://localhost:8086/dashbord_Customer'
        })
}

let uploadFile = () => {

    const doc = document.querySelector('#document')
    const fd = new FormData()
    fd.append('files', doc.files[0])

    console.log(fd)

    //let fileContent = {};

    // fd.forEach(function (value, key) {
    //     fileContent[key] = value;
    // });
    // let json = JSON.stringify(fileContent);

    // console.log(fileContent)
    fetch('http://localhost:8086/upload', {
        method: 'POST',

        body: fd
    })
        .then(response => response.json())
        .then(data => {
            fileAddress = data.filePath
            sendData()
        })


}

function getPartId() {

    var e = document.getElementById("partOfcompany");
    var partOfCompany = e.options[e.selectedIndex].text;

    let obj = {
        name: partOfCompany
    }
    console.log(obj)
    fetch('http://localhost:8086/getPartId', {

        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(obj)
    })
        .then(response => response.json())
        .then(res => {
            partId = res
            uploadFile()
        })
}

