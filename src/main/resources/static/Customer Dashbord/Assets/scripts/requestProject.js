// CUSTOMER_OBJECT
let currentOBJ = JSON.parse(localStorage.getItem("CUSTOMER_OBJECT"))
var a

const CustomerObject = JSON.parse(localStorage.getItem('CUSTOMER_OBJECT'))

document.querySelector('#customerName').value = CustomerObject.name
document.querySelector('#email').value = CustomerObject.email


document.querySelector('#submitProject').addEventListener('click', (e) => {
    e.preventDefault()
    uploadFile()
   // setTimeout(sendData , 3000)

// company Dashbord

})
let sendData = ()=>{
    let form = document.getElementById('requestProjectForm');
    let formData = new FormData(form);
    formData.append('companyId', 596595);
    console.log(currentOBJ.id)

    formData.append('generateTime', moment().locale('fa').format('MMMM Do YYYY, h:mm a'));



    formData.delete('document')
    formData.append("document", a)
    formData.append("customerId", currentOBJ.id)
    var object = {};
    formData.forEach(function (value, key) {
        object[key] = value;
    });
    var json = JSON.stringify(object);
    console.log(json)
// add department
    fetch('http://localhost:8086/AddProjectPost', {

        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: json
    })
        .then(response => response)
        .then( res => {
            alert('Success')
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
            a = data.filePath
            sendData()
        })


}
// document.querySelector('#document').addEventListener('change', event => {
//     const files = event.target.files
//     const formData = new FormData()
//     formData.append('myFile', files[0])
// })
