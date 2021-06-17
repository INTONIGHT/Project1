function approve(){
    let url = "http://localhost:8080/Project1BackEnd/EmployeeServlet/approve";
    let xhttp = new XMLHttpRequest();
    let reason = document.getElementById('reason').value;
    let role = document.getElementById('role').value;
    let id = document.getElementById('id').value;
   let approve ={reason:reason,role:role,id:id};
   approve = JSON.stringify(approve);
   xhttp.open('POST',url);
   xhttp.send(approve);
   xhttp.onreadystatechange = () =>{
       if(xhttp.status == 200 && xhttp.readyState == 4){
           let response = JSON.parse(xhttp.responseText);
           console.log(response);
       }
   }
}