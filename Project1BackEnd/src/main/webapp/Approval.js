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
           let response = (xhttp.responseText);
           console.log(response);
           //put a relative path in there.
           //httpsession.
           //window.location.assign('')
       }
   }
   //Make a date object when they create a date object
   //check in the back end if this date - current day
   //closer than a week away set a priority .
}
function logout(){
    window.location.href = "C:/Users/User/Desktop/Project1/Project1BackEnd/src/main/webapp/index.html";
}
function goToGrade(){
    window.location.href = "C:/Users/User/Desktop/Project1/Project1BackEnd/src/main/webapp/Grade.html";
}
function goToPresentation(){
    window.location.href = "C:/Users/User/Desktop/Project1/Project1BackEnd/src/main/webapp/Presentation.html";
}