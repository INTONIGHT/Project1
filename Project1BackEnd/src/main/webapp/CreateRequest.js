function sendRequest(){
    let url="http://localhost:8080/Project1BackEnd/EmployeeServlet/createRequest";
    let xhttp = new XMLHttpRequest();
    let type = document.getElementById('type').value;
    let amount = document.getElementById('amount').value;
    let request = document.getElementById('request').value;
    let body = {type:type,amount:amount,request:request};
    body = JSON.stringify(body);
    xhttp.open('POST',url);
    xhttp.send(body);
    xhttp.onreadystatechange = () =>{
        if(xhttp.status == 200 && xhttp.readyState == 4){
            let response = (xhttp.responseText);
            console.log(response);
        }
    }
}


