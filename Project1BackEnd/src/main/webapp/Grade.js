//url = "http://localhost:8080/Project1BackEnd/EmployeeServlet/";
xhttp = new XMLHttpRequest();
function sendGrade(){
url = "http://localhost:8080/Project1BackEnd/EmployeeServlet/createGrade";
console.log(url);
let grade = document.getElementById('grade').value;
let id = document.getElementById('approval_id').value;
let gradeSubmission = {id:id,grade:grade};
console.log(grade , id);
//same field names
gradeSubmission = JSON.stringify(gradeSubmission);
xhttp.open('POST',url);
xhttp.send(gradeSubmission);
xhttp.onreadystatechange = () =>{
    if(xhttp.status == 200 && xhttp.readyState == 4){
        let response = (xhttp.responseText);
        console.log(response);
    }
}
/**var f = document.getElementById("form")
let spform = {}
let formData = new FormData(f)
for (var [key, value] of formData.entries()) { 
    spform[key] = value
}
let body_content = JSON.stringify(spform) */
}
function getGrade(){
url = "http://localhost:8080/Project1BackEnd/EmployeeServlet/getGrade"
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
//function newrequest() {
//     window.location = "/Project1/html/Request.html"
// }
}
function approveGrade(){
url = "http://localhost:8080/Project1BackEnd/EmployeeServlet/approveGrade"
let approval = document.getElementById("approve").value;
if(approval == "approve"){
    approval = true;
}else{
    approval = false;
}
let id = document.getElementById('approval_id').value;
let reason = document.getElementById('reason').value;
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
function goToRequest(){
    window.location.href ="C:/Users/User/Desktop/Project1/Project1BackEnd/src/main/webapp/CreateRequest.html";
}