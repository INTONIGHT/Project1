function getData(){
let url = "http://localhost:8080/Project1BackEnd/EmployeeServlet/requests";
let xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = retrieveData;
xhttp.open('POST',url);
let user_id = document.getElementById('login').value;


id = JSON.stringify(user_id);
//console.log(id);
xhttp.send(id);


function retrieveData(){
    let dataSection = document.getElementById('data');
    dataSection.innerHTML = '';
    if(xhttp.readyState == 4 && xhttp.status == 200){
        let response = xhttp.responseText;
        response = JSON.parse(response);
        //console.log(response);
        let employeeTable = document.createElement('table');
    employeeTable.id = 'employeeTable';

    let thRow = document.createElement('tr');
    let tHeaders = ['Id','Request Type','User Request',
                    'Approval Stage','Approval Status','Amount',
                'Reason'    ];
           for( let h of tHeaders){
               let th = document.createElement('th');
               th.innerHTML = h;
               thRow.appendChild(th);
           }     
           employeeTable.append(thRow);
           for(let employee of response){
              let tr = document.createElement('tr');
                //id
                let tdId = document.createElement('td');
               tdId.innerHTML = employee.id;
               tr.appendChild(tdId);
                //Request type
                let tRt = document.createElement('td');
                tRt.innerHTML = employee.requesttype;
                tr.appendChild(tRt);
                //userrequest
                let tUr = document.createElement('td');
                tUr.innerHTML = employee.userrequest;
                tr.appendChild(tUr);
                //approvalstage
                let tAs = document.createElement('td');
                tAs.innerHTML = employee.approvalstage;
                tr.appendChild(tAs);
                //approvalstatus
                let tA = document.createElement('td');
                tA.innerHTML = employee.approvalstatus;
                tr.appendChild(tA);
                //amount
                let tAm = document.createElement('td');
                tAm.innerHTML = employee.amount;
                tr.appendChild(tAm);
                //reason
                let tR = document.createElement('td');
                tR.innerHTML = employee.reason;
                tr.appendChild(tR);
               employeeTable.appendChild(tr);
               //date requested for
               //if the request is approved
            //    let tAp = document.createElement('td');
            //    tAp.innerHTML = employee.approval;
            //    tdId.appendChild(tAp);
               
           }
           dataSection.appendChild(employeeTable);
    }
}
}
function getById(){
    let id = document.getElementById('employeeId').value;
    let url = "http://localhost:8080/Project1BackEnd/EmployeeServlet/getById";
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = retrieveData;
    xhttp.open('POST',url);
    console.log(id);
    id = JSON.stringify(id);
    xhttp.send(id);
    function retrieveData(){
        let dataSection = document.getElementById('data');
        dataSection.innerHTML = '';
        if(xhttp.readyState == 4 && xhttp.status == 200){
            let response = xhttp.responseText;
            response = JSON.parse(response);
            //console.log(response);
            let employeeTable = document.createElement('table');
        employeeTable.id = 'employeeTable';
    
        let thRow = document.createElement('tr');
        let tHeaders = ['Id','Request Type','User Request',
                        'Approval Stage','Approval Status','Amount',
                    'Reason','Urgent'    ];
               for( let h of tHeaders){
                   let th = document.createElement('th');
                   th.innerHTML = h;
                   thRow.appendChild(th);
               }     
               employeeTable.append(thRow);
               for(let employee of response){
                  let tr = document.createElement('tr');
                    //id
                    let tdId = document.createElement('td');
                   tdId.innerHTML = employee.id;
                   tr.appendChild(tdId);
                    //Request type
                    let tRt = document.createElement('td');
                    tRt.innerHTML = employee.requesttype;
                    tr.appendChild(tRt);
                    //userrequest
                    let tUr = document.createElement('td');
                    tUr.innerHTML = employee.userrequest;
                    tr.appendChild(tUr);
                    //approvalstage
                    let tAs = document.createElement('td');
                    tAs.innerHTML = employee.approvalstage;
                    tr.appendChild(tAs);
                    //approvalstatus
                    let tA = document.createElement('td');
                    tA.innerHTML = employee.approvalstatus;
                    tr.appendChild(tA);
                    //amount
                    let tAm = document.createElement('td');
                    tAm.innerHTML = employee.amount;
                    tr.appendChild(tAm);
                    //reason
                    let tR = document.createElement('td');
                    tR.innerHTML = employee.reason;
                    tr.appendChild(tR);
                    //urgent
                   let tU = document.createElement('td');
                   tU.innerHTML = employee.urgent;
                   tr.appendChild(tU);
                   //append the elements
                   employeeTable.appendChild(tr);
                   
                }
                dataSection.appendChild(employeeTable);
         }
}
}
function getInfo(){
    let url = "http://localhost:8080/Project1BackEnd/EmployeeServlet/getInfo";
   
    
    let xhttp = new XMLHttpRequest();
    xhttp.open('GET',url);
    xhttp.send();
    xhttp.onreadystatechange = () =>{
        if(xhttp.status == 200 && xhttp.readyState == 4){
            let response = JSON.parse(xhttp.responseText);
            //console.log(response.id);
            let stuff = document.getElementById('login');
            stuff.value = response.id;
            let adminRole = document.getElementById('admin');
            adminRole.value = response.role;
            console.log(adminRole.value);
            if(adminRole.value == 'directSupervisor'||adminRole.value == 'departmentHead'||adminRole.value=="BenCo"){
                let getStuff = document.getElementById('getId');
                getStuff.style.display = "block";
                let input = document.getElementById('employeeId');
                input.style.display = "block";
                let otherInput = document.getElementById('goToApp');
                otherInput.style.display ="block";
               
            }
            //document.documentElement
            //try to set the employee id here.
        }
    }
}
function goToCreate(){
    window.location ="CreateRequest.html";
}
function goToApprove(){
    window.location="Approval.html";
}