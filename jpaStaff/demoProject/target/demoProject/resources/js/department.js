function editDept(dept_id) {
    console.log("hello");
    console.log(dept_id);
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
                                                        button.setAttribute("onclick","display()");
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
                alert("you cannot delete department");
            }else{
                window.location = "dep-delete/"+dept_id;
                setTimeout(function(){
                    alert("department deleted successfully.");
                },2000);
            }
    });
}

function display(){
    setTimeout(function(){
        alert("department updated successfully");
    },2000);
}c