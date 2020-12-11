document.querySelector('#submit').addEventListener('click',(e)=>{
    e.preventDefault()
    let form = document.getElementById('addEmployee');
    let formData = new FormData(form);
    formData.append('companyId', 596595);

    var object = {};
    formData.forEach(function(value, key){
        object[key] = value;
    });
    var json = JSON.stringify(object);
    console.log(json)


    fetch('http://localhost:8086/employeePost',{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: json
    })
        .then(response => response.json())
        .then(res =>{
            alert(res)
        })

    let change = ()=>{
        window.location.href = 'http://localhost:8086/Dashbord_Company'
    }


    setTimeout(change,1000)
    //window.location.href = 'http://localhost:8086/systemDashboard'

})




