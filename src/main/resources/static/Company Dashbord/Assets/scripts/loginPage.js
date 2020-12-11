
const loginBtn = document.querySelector('#login-btn')

loginBtn.addEventListener('click' , ()=>{
    const userName = document.querySelector('#userName').value 
    const passWord = document.querySelector('#passWord').value
    //
    let obj = {
        password :passWord,
        username :userName
    }
    // let obj = {
    //     userId: 5,
    //     id: 5
    // }


    // http://localhost:8086/companyGet
    fetch('http://localhost:8086/companyGet',{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(obj)
    }).then((response) => response.json())
        .then(data => {
            if(data.username == null)
                alert('error')
            else
                window.location.href = 'http://localhost:8086/Dashbord_Company'
        })






})


