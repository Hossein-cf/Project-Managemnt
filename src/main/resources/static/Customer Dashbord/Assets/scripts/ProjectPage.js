let projectID = JSON.parse(localStorage.getItem("PROJECT_ID"))

let obj ={
    id : projectID
}

let projectObj
fetch('http://localhost:8086/getProjectByID',{
    method: 'POST',
    headers: {
        'Content-Type': 'application/json;charset=utf-8'
    },
    body: JSON.stringify(obj)
}).then((response) => response.json())
    .then(data => {
       projectObj=data
        console.log(projectObj)
        setInformation()
    })
function setInformation(){
    document.getElementById('project-subject').innerText=projectObj.subject
    document.getElementById('project-id').innerText=projectObj.id
    document.getElementById('condition').innerText=projectObj.condition
    document.getElementById('project-text').innerText=projectObj.description





}
// function getGeneratorAndDestinationName(){
//     let currentOBJ = JSON.parse(localStorage.getItem("CUSTOMER_OBJECT"))
//
//     if(ticketObj.generatorType === "بخش"){
//
//         fetch('http://localhost:8086/getPartById',{
//             method: 'POST',
//             headers: {
//                 'Content-Type': 'application/json;charset=utf-8'
//             },
//             body: JSON.stringify({
//                 id:ticketObj.generatorId
//             })
//         }).then((response) => response.json())
//             .then(data => {
//                 generatorName=data
//                 destinationName=currentOBJ.name
//                 console.log(generatorName)
//                 setInformation()
//             })
//     }else{
//         fetch('http://localhost:8086/getPartById',{
//             method: 'POST',
//             headers: {
//                 'Content-Type': 'application/json;charset=utf-8'
//             },
//             body: JSON.stringify({
//                 id:ticketObj.destinationId
//             })
//         }).then((response) => response.json())
//             .then(data => {
//                 destinationName=data
//                 generatorName=currentOBJ.name
//                 console.log(destinationName)
//                 setInformation()
//             })
//     }
// }