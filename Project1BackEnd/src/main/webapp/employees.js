function getData(){
let url = "http://localhost:8080/Project1BackEnd/EmployeeServlet/requests";
let xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = retrieveData;
xhttp.open('POST',url);
let user_id = document.getElementById('user_id').value;


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
            //document.documentElement
        }
    }
}
function goToCreate(){
    window.location ="CreateRequest.html";
}