/*
   private long id;
    private String name;
    private long adminId;
    private String description;
    private PartActivity partActivity;
    private List<Employee> employeesForPart;
    private List<Ticket> tickets;
    private double satisfactionPercentage;//    درصد رضایت
    private String email;
    private long companyId;
 */
document.querySelector('#submit').addEventListener('click', (e) => {
    e.preventDefault()
    let form = document.getElementById('addDepartment');
    let formData = new FormData(form);
    formData.append('companyId', 596595);
    var object = {};
    formData.forEach(function (value, key) {
        object[key] = value;
    });
    var json = JSON.stringify(object);
    console.log(json)

// add department
    fetch('http://localhost:8086/AddPartOfCompanyPost', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: json
    })
        .then(response => response)
        .then(res => {
            console.log(12154)
            console.log(res)

            window.location.href = 'http://localhost:8086/Dashbord_Company'
        })
// company Dashbord

    //window.location.href = 'http://localhost:8086/systemDashboard'

})




