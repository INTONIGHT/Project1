function approve(){
    let url = "http://localhost:8080/Project1BackEnd/EmployeeServlet/approve";
    let xhttp = new XMLHttpRequest();
    let reason = document.getElementById('reason').value;
    let role = document.getElementById('role').value;
    let id = document.getElementById('id').value;
    let approval = document.getElementById('approval').value;
    if(approval == "approve"){
        approval = true;
    }else{
        approval = false;
    }
   let approve ={reason:reason,role:role,id:id,approve:approval};
   approve = JSON.stringify(approve);
   xhttp.open('POST',url);
   xhttp.send(approve);
   //ds dh bc
   xhttp.onreadystatechange = () =>{
       if(xhttp.status == 200 && xhttp.readyState == 4){
           let response = (xhttp.responseText);
           console.log(response);
           //put a relative path in there.
           //httpsession.
           //window.location.assign('')
       }
   }
   //Make a date object when they create a date object
   //check in the back end if this date - current day
   //closer than a week away set a priority .
}
function getInfo(){
    let url = "http://localhost:8080/Project1BackEnd/EmployeeServlet/getInfo";
    let dep = document.getElementById('ds');
    let dir = document.getElementById('dh');
    let benc = document.getElementById('bc');
    let xhttp = new XMLHttpRequest();
    xhttp.open('GET',url);
    xhttp.send();
    xhttp.onreadystatechange = () =>{
        if(xhttp.status == 200 && xhttp.readyState == 4){
            let response = JSON.parse(xhttp.responseText);
            console.log(response.role);
            switch(response.role){
                //directsupervisor,departmentHead,benefitsCoordinator
                case "directSupervisor":
                    
                    dep.style.display = 'block';
                    break;
                case 'departmentHead':
                    dir.style.display = 'block';
                    break;
                case 'benefitsCoordinator':
                    benc.style.display = 'block';
                    break;
            }
        }
    }
}
function logout(){
    window.location = "index.html";
}
function goToGrade(){
    window.location = "Grade.html";
}
function goToPresentation(){
    window.location = "Presentation.html";
}