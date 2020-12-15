let projectID = JSON.parse(localStorage.getItem("PROJECT_ID"))

let obj ={
    id : projectID
}
let generatorName
let destinationName
let ticketObj
fetch('http://localhost:8086/getProjectByID',{
    method: 'POST',
    headers: {
        'Content-Type': 'application/json;charset=utf-8'
    },
    body: JSON.stringify(obj)
}).then((response) => response.json())
    .then(data => {
       ticketObj=data
        console.log(ticketObj)
        getGeneratorAndDestinationName()
    })
function setInformation(){
    document.getElementById('TicketGenerator').innerText=generatorName
    document.getElementById('createTime').innerText=ticketObj.generateTime
    document.getElementById('description').innerText=ticketObj.description


    document.getElementById('condition').innerText=ticketObj.condition
    document.getElementById('priority').innerText=ticketObj.ticketPriority
    document.getElementById('ticketSubject').innerText=ticketObj.subject

    document.getElementById('ticketPart').innerText=destinationName


}
function getGeneratorAndDestinationName(){
    let currentOBJ = JSON.parse(localStorage.getItem("CUSTOMER_OBJECT"))

    if(ticketObj.generatorType === "بخش"){

        fetch('http://localhost:8086/getPartById',{
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                id:ticketObj.generatorId
            })
        }).then((response) => response.json())
            .then(data => {
                generatorName=data
                destinationName=currentOBJ.name
                console.log(generatorName)
                setInformation()
            })
    }else{
        fetch('http://localhost:8086/getPartById',{
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                id:ticketObj.destinationId
            })
        }).then((response) => response.json())
            .then(data => {
                destinationName=data
                generatorName=currentOBJ.name
                console.log(destinationName)
                setInformation()
            })
    }
}