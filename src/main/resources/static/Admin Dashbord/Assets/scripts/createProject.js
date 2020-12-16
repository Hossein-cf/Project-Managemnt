if (localStorage.getItem('PROJECT-OBJ') !== null) {
    let pObj = JSON.parse(localStorage.getItem("PROJECT-OBJ"))
    document.getElementById('projectSubject').value = pObj.subject
    document.getElementById('deadLine').value = pObj.deadLine
    document.getElementById('description').value = pObj.description

    let input = document.getElementById('fileInput')
    document.getElementById('fileContainer').removeChild(input)
    let a = document.createElement('a')
    a.href = pObj.documents
    a.innerHTML = 'فایل ضمیمه شده'
    document.getElementById('fileContainer').appendChild(a)


}

document.getElementById('createProjectBtn').addEventListener('click', (e) => {
    e.preventDefault()
    let pObj = JSON.parse(localStorage.getItem("PROJECT-OBJ"))
    let managerId1 = document.getElementById('projectManagerId').value

    console.log(managerId1)
    fetch('http://localhost:8086/updateProject', {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            managerId: managerId1,
            id: pObj.projectId,
            startTime: moment().locale('fa').format('MMMM Do YYYY, h:mm a'),
            condition: "در حال انجام"
        })
    })
        .then(response => response)
        .then(res => {
            alert("پروژه به مدیر پروژه محول شد")
            localStorage.removeItem("PROJECT-OBJ")
            window.location.href = 'http://localhost:8086/dahsbord_Admin'

        })

})