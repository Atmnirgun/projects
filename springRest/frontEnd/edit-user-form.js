// function loadPageDetails(val){
//     loadPage();    
// }
var url = new URL(window.location.href);
var id = url.searchParams.get("id");

window.addEventListener('load',(event)=>{
    loadUser()
});

function loadUser(val){
    
    fetch("http://localhost:8080/crudRestDemo_war_exploded/api/user/"+id).then((response)=>{
        return response.json();
    }).then((result)=>{
        let first_name = document.getElementById("fname")
        first_name.value = result.firstName;
        let last_name = document.getElementById("lname")
        last_name.value = result.lastName;
    }); 
}

function updateUser(){
    first_name = document.getElementById("fname").value;
    last_name = document.getElementById("lname").value;

    data = {
        firstName:first_name,
        lastName:last_name
    }
    param = {
        mode:'cors',
        method:'PUT',
        headers : {
            'Content-Type':'application/json',
            'Accept':'application/json',
            'Access-Control-Allow-Origin': '*',
            'Accept-Control-Allow-Origin': '*'
        },
        body:JSON.stringify(data)
    }
    fetch("http://localhost:8080/crudRestDemo_war_exploded/api/update/"+id,param).then((response)=>{
        return response.json();
    }).then((result)=>{
        window.location.href = "home.html";
        //console.log(result);
    });
}