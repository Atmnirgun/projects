function editDept(dept_id) {
    var param = {
        mode:'cors',
        method:"GET",
        headers : {
            'Content-Type':'application/json',
            'Accept':'application/json',
            'Access-Control-Allow-Origin': '*',
            'Accept-Control-Allow-Origin': '*'
        }
    }
    var url = "api/department/"+dept_id;
    fetch(url,param).then((response)=>{
                                                    return response.json();
                                                    }).then((result)=>{
                                                        console.log(result);
                                                        document.getElementById("name").value = result.name;
                                                        document.getElementById("comp_id").value = result.comp_id;
                                                        var button = document.getElementById("button");
                                                        button.innerText = "update";
                                                        button.setAttribute("onclick","displayUpdate()");
                                                        //button.setAttribute()
                                                        var form = document.getElementsByTagName("form");
                                                        console.log(form[0])
                                                        form[0].setAttribute("action","edit-department/"+dept_id);

                                                    });
}

function removeDept(dept_id){
    var param = {
        mode:'cors',
        method:"GET",
        headers : {
            'Content-Type':'application/json',
            'Accept':'application/json',
            'Access-Control-Allow-Origin': '*',
            'Accept-Control-Allow-Origin': '*'
        }
    }
    var url = "api/company/department/staff-List/"+dept_id;
    fetch(url,param).then((response)=>{
        return response.json();
    }).then((result)=>{
            console.log(result);
            if(result > 0){
                alert("You cannot delete department");
            }else{
                window.location = "dep-delete/"+dept_id;
                setTimeout(function(){
                    alert("Department deleted successfully.");
                },2000);
            }
    });
}

function displayUpdate(){
    console.log("update called");
    var name = document.getElementById("name").value;
    var company = document.getElementById("comp_id").value;
    if(name && company != ""){
        setTimeout(function () {
            alert("Department updated successfully");
        },2000);
    }
}

function displayAdd(){
    var name = document.getElementById("name").value;
    var company = document.getElementById("comp_id").value;
    if(name && company != ""){
        setTimeout(function () {
            alert("Department Added successfully");
        },2000);
    }
}