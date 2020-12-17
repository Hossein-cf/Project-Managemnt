const loginBtn = document.querySelector('#login-btn')

loginBtn.addEventListener('click', () => {
    const userName = document.querySelector('#userName').value
    const passWord = document.querySelector('#passWord').value

    let obj = {
        password: passWord,
        username: userName
    }
    console.log(obj)

    fetch('http://localhost:8086/Login_Manager', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(obj)
    }).then((response) => response.json())
        .then(data => {
            if (data.id == 0)
                alert('error')
            else {
                console.log(data)
                localStorage.setItem("MANAGER_OBJECT", JSON.stringify(data))
                window.location.href = 'http://localhost:8086/dahsbord_Manager'

            }
        })
})


