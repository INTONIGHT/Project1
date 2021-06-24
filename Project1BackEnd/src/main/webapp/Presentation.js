xhttp = new XMLHttpRequest();
// let presentation = document.getElementById('presentation').value;
// let id = document.getElementById('approval_id').value;
// let approval = document.getElementById('approve').value;
// let reason = document.getElementById('reason').value;
// let packet = {id:id,presentation:presentation,reason:reason,approval:approval};
// packet = JSON.stringify(packet);
//id reason approval presentation
function sendPresentation(){
    url = "http://localhost:8080/Project1BackEnd/EmployeeServlet/createPresentation";
    let id = document.getElementById('approval_id').value;
    let presentation = document.getElementById('presentation').value;
    packet = {id:id,reason:'',approval:false,presentation:presentation};
    packet = JSON.stringify(packet);
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
    let id = document.getElementById('approval_id').value;
    let data = document.getElementById('output');
    packet = {id:id};
    packet = JSON.stringify(packet);
    xhttp.open('POST',url);
    xhttp.send(packet);
    xhttp.onreadystatechange = () =>{
        if(xhttp.readyState == 4 && xhttp.status == 200){
            let response = xhttp.responseText;
            data.innerHTML = response;
        }
    }
}
function approvePresentation(){
    url = "http://localhost:8080/Project1BackEnd/EmployeeServlet/approvePresentation";
    let id = document.getElementById('approval_id').value;
    let reason = document.getElementById('reason').value;
    let approval = document.getElementById('approve').value;
    if(approval == "approve"){
        approval = true;
    }else{
        approval = false;
    }
    packet = {id:id,reason:reason,approval:approval};
    packet = JSON.stringify(packet);
    xhttp.open('Post',url);
    xhttp.send(packet);
    xhttp.onreadystatechange = () =>{
        if(xhttp.readyState == 4 && xhttp.status == 200){
            let response = xhttp.responseText;
            console.log(response);
        }
    }
}
function goToRequest(){
    window.location ="CreateRequest.html";
}