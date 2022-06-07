window.addEventListener('load',(event)=>{
    add();
})
function add() {
    fetch("http://localhost:8080/crudRestDemo_war_exploded/api/users", 
    {
        mode: 'cors',
        header: {
            'Content-Type':'application/json',
            'Accept':'application/json',
            'Access-Control-Allow-Origin': '*',
            'Accept-Control-Allow-Origin': '*'
        }
    }).then((response)=>{
        console.log(response);
        return response.json();
    }).then((result)=>{
        let tbody = document.getElementsByTagName("tbody");
        if(result.length > 0){
            result.forEach(user => {
                let tr = document.createElement("tr");
                let td_id = document.createElement("td");
                let td_fname = document.createElement("td");
                let td_lname = document.createElement("td");
                let td_action = document.createElement("td");


                td_id.innerText = user.id;
                td_fname.innerText = user.firstName;
                td_lname.innerText = user.lastName;
                let del = document.createElement("button");
                
                del.setAttribute("class","me-2 btn btn-link");
                del.setAttribute("value",user.id);
                del.setAttribute("onClick","deleteUser(this.value)");
                del.innerText = "delete";
                let ed = document.createElement("a");
                ed.setAttribute("value",user.id);
                ed.setAttribute("href","edit-user-form.html?id="+user.id);
                
                
                ed.innerText = "edit";
                

                tr.appendChild(td_id);
                tr.appendChild(td_fname);
                tr.appendChild(td_lname);
                td_action.appendChild(del);
                td_action.appendChild(ed);
                tr.appendChild(td_action);
                tbody[0].appendChild(tr);
                
                
          });
          $(document).ready( function () {
            $('#table').DataTable();
        } );
        }
        
    });
    
    
}

function deleteUser(val){
    console.log(val);
    let param = {
        mode:"cors",
        method:"DELETE",
        header : {
            'Content-Type':'text/plain',
            'Accept':'text/plain',
            'Access-Control-Allow-Origin': '*',
            'Accept-Control-Allow-Origin': '*'
        }
    }

    fetch("http://localhost:8080/crudRestDemo_war_exploded/api/delete/"+val,param).then((response)=>{
     return response.text();
    }).then((result)=>{
        console.log(result);
       window.location.reload();
    });
}

// function editUser(val){
//      window.location.href = "edit-user-form.html";
//      console.log(val)

// }