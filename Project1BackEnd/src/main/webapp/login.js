function login(){
   let url = "http://localhost:8080/Project1BackEnd/EmployeeServlet/login";
   let xhttp = new XMLHttpRequest();
   
   //xhttp.send json object
   //in the servlet make the java representation
   //give that to the gson.
   let username = document.getElementById('username').value;
       let password = document.getElementById('password').value;
       let login = {username:username,password:password};
       var test = JSON.stringify(login);
       console.log(test);
   xhttp.open('POST',url);
   xhttp.send(test);
       //let login = document.getElementById('login');
       xhttp.onreadystatechange = ()=> {
           if(xhttp.status == 200 && xhttp.readyState == 4){
            console.log(xhttp.responseText);
           }};
       
       
       
   
}