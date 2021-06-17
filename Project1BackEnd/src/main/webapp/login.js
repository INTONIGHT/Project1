function login(){
   let url = "http://localhost:8080/Project1BackEnd/EmployeeServlet/login";
   let xhttp = new XMLHttpRequest();
   xhttp.onreadystatechange = retrieveData;
   xhttp.open('GET',url);
   xhttp.send();
   function retrieveData(){
       //let login = document.getElementById('login');
       if(xhttp.status == 200 && xhttp.readyState == 4){
       let username = document.getElementById('username');
       let password = document.getElementById('password');
       console.log(username + password);
       }
   }
}