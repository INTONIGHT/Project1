url = "http://localhost:8080/Project1BackEnd/EmployeeServlet/";
xhttp = new XMLHttpRequest();
function sendGrade(){
url = url + "createGrade";
let grade = document.getElementById('grade');
let id = document.getElementById('approval_id').valu
let gradeSubmission = {grade:grade,id:id,approval:false,reason:"none"};
gradeSubmission = JSON.stringify(gradeSubmission);
xhttp.open('POST',url);
xhttp.send(gradeSubmission);
xhttp.onreadystatechange = () =>{
    if(xhttp.status == 200 && xhttp.readyState == 4){
        let response = (xhttp.responseText);
        console.log(response);
    }
}

}
function getGrade(){
url = url + "getGrade"
let id = document.getElementById('approval_id').value;
let data = document.getElementById('output');
xhttp.open('POST',url);
id = JSON.stringify(id);
xhttp.send(id);
xhttp.onreadystatechange = () =>{
    if(xhttp.status == 200 && xhttp.readyState == 4){
        let response = xhttp.responseText;
        data.innerHTML = response;
    }
}
}
function approveGrade(){
url = url + "approveGrade"
let approval = document.getElementById("approve").value;
let id = document.getElementById('approval_id');
let reason = document.getElementById('reason');
xhttp.open('POST',url);
let approve = {id:id,reason:reason,approval:approval};
approve = JSON.stringify(approve);
xhttp.send(approve);
xhttp.onreadystatechange = () =>{
    if(xhttp.status == 200 && xhttp.readyState == 4){
let response = xhttp.responseText;
console.log(response);
    }
}

}