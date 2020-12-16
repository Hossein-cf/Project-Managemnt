// const loginBtn = document.querySelector('#login-btn')
//
// loginBtn.addEventListener('click' , ()=>{
//     const userName = document.querySelector('#userName').value
//     const passWord = document.querySelector('#passWord').value
//
//     if(userName === 'admin' && passWord ==='admin'){
//         // window.location.href = '../Pages/Dashbord_Company.html'
//     }
// })
// localStorage.clear()
let parts
let adminObject
fetch('http://localhost:8086/getAllPartsName')
    .then(response => response.json())
    .then(res => {
        parts = res
        console.log(res)
        setPartNames()
    })

function setPartNames() {


    const partsComboBox = document.getElementById('inputDepartment')
    for (const item of parts) {
        let option = document.createElement('option')
        option.innerText = item
        partsComboBox.appendChild(option)
    }
}

const loginBtn = document.querySelector('#login-btn')

loginBtn.addEventListener('click', () => {
    const username = document.querySelector('#username').value
    const password = document.querySelector('#Password').value

    let e = document.getElementById("inputDepartment");
    let selectedPart = e.options[e.selectedIndex].text;
    localStorage.setItem("PART_NAME", selectedPart)
    fetch('http://localhost:8086/getCurrentAdmin', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            username: username,
            password: password,
            partName: selectedPart
        })
    })
        .then(response => response.json())
        .then(res => {
            console.log(res)
            if (res.username == null ||selectedPart ==="مالی")
                alert('error')
            else {

                localStorage.setItem("ADMIN_OBJECT", JSON.stringify(res))
                window.location.href = 'http://localhost:8086/dahsbord_Admin'
            }
        })

})

