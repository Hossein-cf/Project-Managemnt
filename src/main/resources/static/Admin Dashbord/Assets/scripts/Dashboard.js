
let Admin_Object = JSON.parse(localStorage.getItem('ADMIN_OBJECT'))
console.log(Admin_Object)
let partName = localStorage.getItem('PART_NAME')

document.getElementById('adminName').innerHTML = Admin_Object.name
// ??????????????
// document.getElementById('partEmail').innerText =

fetch('http://localhost:8086/getPartByName',{
    method: 'POST',
    headers: {
        'Content-Type': 'application/json;charset=utf-8'
    },
    body: JSON.stringify({
        name : partName
    })
})
    .then(response => response.json())
    .then(res => {
        console.log(res)
        document.getElementById('partEmail').innerText = res.email
    })



