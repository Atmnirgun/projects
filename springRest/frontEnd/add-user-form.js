function addUser(){
    let first_name = document.getElementById("fname").value;
    let last_name = document.getElementById("lname").value;

    let user_data = {
        firstName:first_name,
        lastName:last_name
    }
    let param = {
        mode:"cors",
        method:"POST",
        headers : {
            'Content-Type':'application/json',
            'Accept':'application/json',
            'Access-Control-Allow-Origin': '*',
            'Accept-Control-Allow-Origin': '*'
        },
        body : JSON.stringify(user_data)
    }
    fetch("http://localhost:8080/crudRestDemo_war_exploded/api/user",param).then((response)=>{
        return response.json();
    }).then((result)=>{
        let mainDiv = document.getElementById("mainDiv");
        let cList = mainDiv.classList;
        cList.add("d-none");
        let hidDiv = document.getElementById("hidden-div")
        hidDiv.classList.remove("d-none");
        let msg = document.getElementById("success_msg");
        msg.innerText = "User added successfully";
    });
}