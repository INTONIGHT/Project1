url = "http://localhost:8080/Project1BackEnd/EmployeeServlet/";
xhttp = new XMLHttpRequest();
function sendGrade(){
url = url + "createGrade";
console.log(url);
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
/**var f = document.getElementById("form")
let spform = {}
let formData = new FormData(f)
for (var [key, value] of formData.entries()) { 
    spform[key] = value
}
let body_content = JSON.stringify(spform) */
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
//function newrequest() {
//     window.location = "/Project1/html/Request.html"
// }
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