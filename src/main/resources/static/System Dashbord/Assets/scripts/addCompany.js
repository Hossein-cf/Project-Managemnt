document.querySelector('.submit').addEventListener('click', (e) => {
    e.preventDefault()
    let form = document.getElementById('addCompany');
    let formData = new FormData(form);

    var object = {};
    formData.forEach(function (value, key) {
        object[key] = value;
    });
    var json = JSON.stringify(object);
    console.log(json)
    //
    // let user = {
    //     name: 'John',
    //     Email: 'Smith'
    // };

    /*  private long id;
    private String name;
    private String Username;
    private String Password;
    private String Email;
    private Date createTime;
    private Date validityDate;
    private List<Part> parts;
    private double satisfactionPercentage;//    درصد رضایت
    private List<Ticket> tickets;*/

    fetch('http://localhost:8086/companyPost', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: json
    })
        .then(response => response)
        .then(res => {


            console.log(res)
            alert("success")
            window.location.href = 'http://localhost:8086/systemDashboard'
            }
        )


})




