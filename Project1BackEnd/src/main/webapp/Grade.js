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
xhttp.open('POST',url);
id = JSON.stringify(id);
xhttp.send(id);
xhttp.onreadystatechange = () =>{
    if(xhttp.status == 200 && xhttp.readyState == 4){
        let response = xhttp.responseText;
        console.log(response);
    }
}
}
function approveGrade(){
url = url + "approveGrade"
}