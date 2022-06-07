function editCompany(comp_id) {
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
    var url = "api/company/"+comp_id;
    fetch(url,param).then((response)=>{
        return response.json();
}).then((result)=>{
        console.log(result);
    document.getElementById("name").value = result.name;
    document.getElementById("country").value = result.country;

    var date = new Date(result.foundation_date);
    var f_date = date.getFullYear()+"-"+String(date.getMonth()+1).padStart(2,'0')+"-"+String(date.getDate()).padStart(2,'0');
    console.log(f_date);

    document.getElementById("fdate").value = f_date;
    var button = document.getElementById("button");
    button.innerText = "update";
    button.setAttribute("onclick","display()");
    //button.setAttribute()
    var form = document.getElementsByTagName("form");
    console.log(form[0])
    form[0].setAttribute("action","edit-company/"+comp_id);
});
}

function removeCompany(comp_id){
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
    var url = "api/company/department-list/"+comp_id;
    fetch(url,param).then((response)=>{
        return response.json();
}).then((result)=>{
        console.log(result);
        if(result > 0){
            alert("you cannot delete company.");
        }else{

            window.location = "delete/"+comp_id;
            setTimeout(function(){
                alert("company deleted successfully");
            },2000);

        }
});
}

function display(){
    setTimeout(function () {
        alert("company updated successfully");
    },2000);
}