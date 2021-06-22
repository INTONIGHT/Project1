xhttp = new XMLHttpRequest();
let presentation = document.getElementById('presentation');
let id = document.getElementById('approval_id').value;
let approval = document.getElementById('approve');
let reason = document.getElementById('reason');
let packet = {id:id,presentation:presentation};
packet = JSON.stringify(packet);
function sendPresentation(){
    url = "http://localhost:8080/Project1BackEnd/EmployeeServlet/createPresentation";
    
    
    xhttp.open('POST',url);
    xhttp.send(packet);
    xhttp.onreadystatechange = () =>{
        if(xhttp.readyState == 4 && xhttp.status == 200){
            let response = xhttp.responseText;
            console.log(response);
        }
    }
}