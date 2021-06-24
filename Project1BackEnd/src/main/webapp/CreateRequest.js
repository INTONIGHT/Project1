function sendRequest(){
    let url="http://localhost:8080/Project1BackEnd/EmployeeServlet/createRequest";
    let xhttp = new XMLHttpRequest();
    let type = document.getElementById('type').value;
    let amount = document.getElementById('amount').value;
    let data = document.getElementById('data');
    let request = document.getElementById('request').value;
    let body = {type:type,amtReq:amount,request:request};
    body = JSON.stringify(body);
    xhttp.open('POST',url);
    xhttp.send(body);
    xhttp.onreadystatechange = () =>{
        if(xhttp.status == 200 && xhttp.readyState == 4){
            let response = (xhttp.responseText);
            data.innerHTML = response;
        }
    }
}
function getCookie(cname){
    let name = cname + "=";
    let decodedCookie = decodeURIComponent(document.cookie);
    console.log(decodedCookie);
    let ca = decodedCookie.split(';');
    for(let i =0;i<ca.length;i++){
        let c = ca[i];
        while(c.charAt(0)==' '){
            c=c.substring(1);
        }
        if(c.indexOf(name)==0){
            return c.substring(name.length,c.length);
        }
    }
    return "";
}
function readData(){
    let data = getCookie("Login");
    console.log(data);
}
function goToRequests(){
    window.location = "Employee.html";
}
function goToGrades(){
    window.location = "Grade.html";
}
function goToPresentations(){
    window.location = "Presentation.html";
}
function logout(){
    window.location = "index.html";
}