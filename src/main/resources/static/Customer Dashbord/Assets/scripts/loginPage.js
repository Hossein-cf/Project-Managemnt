
const loginBtn = document.querySelector('#sign-in-button')

loginBtn.addEventListener('click' , (e)=>{
    e.preventDefault()
    const userName = document.querySelector('#username').value
    const passWord = document.querySelector('#password').value
    //
    let obj = {
        password :passWord,
        username :userName
    }
    console.log(obj)
    // let obj = {
    //     userId: 5,
    //     id: 5
    // }


    // http://localhost:8086/companyGet
    fetch('http://localhost:8086/customerGet',{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(obj)
    }).then((response) => response.json())
        .then(data => {
            if(data.username == null)
                alert('error')
            else{
                window.location.href = 'http://localhost:8086/dashbord_Customer'
                console.log(data)
                localStorage.setItem("CUSTOMER_OBJECT",JSON.stringify(data))
               //  CUSTOMER_OBJECT = data
            }
        })






})


