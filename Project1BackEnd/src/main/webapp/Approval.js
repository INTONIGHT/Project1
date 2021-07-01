function approve(){
    let url = "http://localhost:8080/Project1BackEnd/EmployeeServlet/approve";
    let xhttp = new XMLHttpRequest();
    let reason = document.getElementById('reason').value;
    let role = document.getElementById('role').value;
    let id = document.getElementById('id').value;
    let approval = document.getElementsByName('choice');
    let choice;
    for(let i =0;i<approval.length;i++){
        if(approval[i].checked){
           if(approval[i].value=="approve"){
               choice = true;
           }else if(approval[i].value =="reject"){
               choice = false;
           }
        }
    }
    
    let test = document.getElementById('grade').textContent;
    
    //getPresentationInfo();
    let test1 = document.getElementById('presentation').textContent;
   if(test == true || test1 == true){
      
   
   
    
    
   let approve ={reason:reason,role:role,id:id,approve:choice};
   let data = document.getElementById('data');
   approve = JSON.stringify(approve);
   xhttp.open('POST',url);
   xhttp.send(approve);
   //ds dh bc
   xhttp.onreadystatechange = () =>{
       if(xhttp.status == 200 && xhttp.readyState == 4){
           let response = (xhttp.responseText);
          
           data.innerHTML = response;
           
       }
   }
}
else{
    alert('please check the grade or presentation and then approve either before approving the request');
}
   //Make a date object when they create a date object
   //check in the back end if this date - current day
   //closer than a week away set a priority .
}
function getGradeInfo(){
    let url = "http://localhost:8080/Project1BackEnd/EmployeeServlet/getGradeInfo";
    let id = document.getElementById('id').value;
    let xhttp = new XMLHttpRequest();
    id = JSON.stringify(id);
    xhttp.open('POST',url);
    xhttp.send(id);
    xhttp.onreadystatechange = () =>{
        if(xhttp.status == 200 && xhttp.readyState == 4){
            let approval = document.getElementById('signoff');
            approval.disabled = false;
            let response = (xhttp.responseText);
            //now what you have to do is find the true or false or just send it here.
            //console.log(response);
           
            if(response == "true"){
                let value = document.getElementById('grade');
                 value.innerHTML = "true";
                
                
            }else{
                let value = document.getElementById('grade');
                 value.innerHTML = "false";
            }
        }
    }
}
function getPresentationInfo(){
    let url = "http://localhost:8080/Project1BackEnd/EmployeeServlet/getPresentationInfo";
    let id = document.getElementById('id').value;
    id = JSON.stringify(id);
    let xhttp = new XMLHttpRequest();
    xhttp.open('POST',url);
    xhttp.send(id);
    xhttp.onreadystatechange = () =>{
        if(xhttp.status == 200 && xhttp.readyState == 4){
            let approval = document.getElementById('signoff');
    approval.disabled = false;
            let response = (xhttp.responseText);
           if(response == "true"){
               let value = document.getElementById('presentation');
               value.innerHTML = "true";
           }else{
               let value = document.getElementById('presentation');
               value.innerHTML = "false";
           }
        }
    }
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
                case 'BenCo':
                    benc.style.display = 'block';
                   
                    break;
            }
            if (response.role=="BenCo"){
                alert('please do get presentation and get grade before sending the request');
                let approval = document.getElementById('signoff');
                approval.disabled = true;
            }
        }
    }
}
function setButtons(){
    let url = "http://localhost:8080/Project1BackEnd/EmployeeServlet/getInfo";
    let buttonSet = document.getElementById('button');
    let buttonSet1 = document.getElementById('button1');
    let department = document.getElementById('nonEmployee');
    let xhttp = new XMLHttpRequest();
    xhttp.open('GET',url);
    xhttp.send();
    xhttp.onreadystatechange = () =>{
        if(xhttp.status == 200 && xhttp.readyState == 4){
            let response = JSON.parse(xhttp.responseText);
            if(response.role == "directSupervisor" || response.role == "departmentHead" || response.role == "benfitsCoordinator"){
                buttonSet.style.display = 'block';
                buttonSet1.style.display = 'block';
                department.style.display = "block";
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
function goToRequest(){
    window.location = "Employee.html"
}