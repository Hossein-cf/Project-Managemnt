
const loginBtn = document.querySelector('#login-btn')

loginBtn.addEventListener('click' , ()=>{
    const userName = document.querySelector('#userName').value 
    const passWord = document.querySelector('#passWord').value

    if(userName === 'admin' && passWord ==='admin'){
        // window.location.href = '../Pages/Dashbord.html'
    }
})


