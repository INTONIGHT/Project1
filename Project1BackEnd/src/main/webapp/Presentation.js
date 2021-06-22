xhttp = new XMLHttpRequest();
let presentation = document.getElementById('presentation');
let id = document.getElementById('approval_id').value;
let approval = document.getElementById('approve');
let reason = document.getElementById('reason');
let packet = {id:id,presentation:presentation,reason:reason,approval:approval};
packet = JSON.stringify(packet);
function sendPresentation(){
    url = "http://localhost:8080/Project1BackEnd/EmployeeServlet/createPresentation";
    
    packet = {id:id,presentation:presentation,reason:'',approval:false};
    xhttp.open('POST',url);
    xhttp.send(packet);
    xhttp.onreadystatechange = () =>{
        if(xhttp.readyState == 4 && xhttp.status == 200){
            let response = xhttp.responseText;
            console.log(response);
        }
    }
}
function getPresentation(){
    url = "http://localhost:8080/Project1BackEnd/EmployeeServlet/getPresentation";
    xhttp.open('POST',url);
    xhttp.send(packet);
    xhttp.onreadystatechange = () =>{
        if(xhttp.readyState == 4 && xhttp.status == 200){
            let response = xhttp.responseText;
            console.log(response);
        }
    }
}
function approvePresentation(){
    url = "http://localhost:8080/Project1BackEnd/EmployeeServlet/approvePresentation";
    xhttp.open('Post',url);
    xhttp.send(packet);
    xhttp.onreadystatechange = () =>{
        if(xhttp.readyState == 4 && xhttp.status == 200){
            
        }
    }
}