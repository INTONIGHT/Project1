function login(){
    //use this for testing purposes
    //go here to start:http://localhost:8080/Project1BackEnd/
   let url = "http://localhost:8080/Project1BackEnd/EmployeeServlet/login";
   let xhttp = new XMLHttpRequest();
   
   //xhttp.send json object
   //in the servlet make the java representation
   //give that to the gson.
   let username = document.getElementById('username').value;
       let password = document.getElementById('password').value;
       let login = {username:username,password:password};
       var test = JSON.stringify(login);
       //console.log(test);
   xhttp.open('POST',url);
   xhttp.send(test);
       //let login = document.getElementById('login');
       let output = document.getElementById('data');
       output.innerHTML = '';
       xhttp.onreadystatechange = ()=> {
           if(xhttp.status == 200 && xhttp.readyState == 4){
            //id username password role balance.
            let response = JSON.parse(xhttp.responseText);
            setCookie("Login",response);
            //we would switch here to what we want to do
            //dont know it yet.
            
            let role = response.role;
            
            if(role == "Employee"){
                //C:/Users/User/Desktop
               window.location="CreateRequest.html";
            }if(role == "directSupervisor"||role == "departmentHead"||role == "BenCo"){
                window.location ="Approval.html";
                //Admin password
                //ADmin 12345
                //BenCo password
            }
           }};
       //Employee [id=1, username=Tyler, password=Password, role=Employee, balance=1000.0]
       //delete that
       
       
   
}
function setCookie(name,value){
    document.cookie = name +"="+value+';'+";path=/";
}