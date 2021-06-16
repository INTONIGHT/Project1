function getData(){
let url = "http://localhost:8080/Project1BackEnd/EmployeeServlet/requests";
let xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = retrieveData;
xhttp.open('GET',url);
xhttp.send();
function retrieveData(){
    if(xhttp.readyState == 4 && xhttp.status == 200){
        let response = xhttp.responseText;
        //response = JSON.parse(response);
        console.log(response);
    }
}
}