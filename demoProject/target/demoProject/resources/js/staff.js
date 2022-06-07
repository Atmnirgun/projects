function editStaff(staff_id,comp_id) {
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
    var url = "api/staff/"+ staff_id;
    fetch(url,param).then((response)=>{
        return response.json();
        }).then((result)=>{
                console.log(result);

            var comp = document.getElementById("comp_id");
            comp.value = comp_id;
            onCompanyEdit(result.dept_id);
            document.getElementById("name").value = result.name;
            document.getElementById("nric").value = result.nric;
            document.getElementById("tel").value = result.tel_hp;
            var male = document.getElementById("male")
            var female = document.getElementById("female");

            if( male.value === result.gender){
                male.setAttribute("checked","");
            }else {
                female.setAttribute("checked","");
            }

            var jdate = new Date(result.join_date);
            var join_date = jdate.getFullYear()+"-"+String(jdate.getMonth()+1).padStart(2,'0')+"-"+String(jdate.getDate()).padStart(2,'0');
            var ddate = new Date(result.dob);
            var dob = ddate.getFullYear()+"-"+String(ddate.getMonth()+1).padStart(2,'0')+"-"+String(ddate.getDate()).padStart(2,'0');
            document.getElementById("jdate").value = join_date;
            document.getElementById("dobdate").value = dob;

            document.getElementById("sup_id").value = result.supervisor_id;
            var button = document.getElementById("button");
            button.innerText = "update";
            button.setAttribute("onclick","displayUpdate()");

            var form = document.getElementsByTagName("form");

            form[0].setAttribute("action","edit-staff/"+staff_id);


        });
}

function removeStaff(staff_id) {
    console.log(staff_id);
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
    var url = "api/company/department/supervisor/"+staff_id;
    fetch(url,param).then((response)=>{
        return response.json();
        }).then((result)=>{
            if(result > 0){
                alert("you cannot delete staff");
            }else{
                window.location = "staff-delete/"+staff_id;
                setTimeout(function(){
                    alert("Staff deleted successfully.");
                },2000);
            }
        });
}


function onCompanyChange(){
    var selectTag = document.getElementById("comp_id").value;
    var deptag = document.getElementById("dept_id");
    deptag.innerHTML = "<option value=\"-1\" selected>Select Department</option>";
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
        var url = "api/department-by-company/"+selectTag;
        fetch(url,param).then((response)=>{
            return response.json();
        }).then((result)=>{

                for(var i = 0;i<result.length;i++){
                   var option = document.createElement("option");
                   option.text = result[i].name;
                   option.value = result[i].dept_id;
                   deptag.add(option);
                }
                });

}
function onCompanyEdit(dept_id){
    var selectTag = document.getElementById("comp_id").value;
    var deptag = document.getElementById("dept_id");
    deptag.innerHTML = "<option value=\"-1\" selected>Select Department</option>";
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
    var url = "api/department-by-company/"+selectTag;
    fetch(url,param).then((response)=>{
        return response.json();
}).then((result)=>{

        for(var i = 0;i<result.length;i++){
        var option = document.createElement("option");
        option.text = result[i].name;
        option.value = result[i].dept_id;
        deptag.add(option);
    }
    document.getElementById("dept_id").value = dept_id;
});

}

function displayUpdate(){
    var comp = document.getElementById("comp_id");

    var name = document.getElementById("name").value;
    var nric = document.getElementById("nric").value;
    var tel = document.getElementById("tel").value;
    var join_date =  document.getElementById("jdate").value;
    var dob = document.getElementById("dobdate").value;
    var super_id = document.getElementById("sup_id").value;

    if(name && comp && nric && tel && join_date && dob && super_id != ""){
        setTimeout(function () {
            alert("Staff Updated successfully");
        },2000);
    }
}

function displayAdd(){

    var comp = document.getElementById("comp_id");

    var name = document.getElementById("name").value;
    var nric = document.getElementById("nric").value;
    var tel = document.getElementById("tel").value;
    var join_date =  document.getElementById("jdate").value;
    var dob = document.getElementById("dobdate").value;
    var super_id = document.getElementById("sup_id").value;

    if(name && comp && nric && tel && join_date && dob && super_id != ""){
        setTimeout(function () {
            alert("Staff Added successfully");
        },2000);
    }
}
