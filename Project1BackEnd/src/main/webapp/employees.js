function getData(){
let url = "http://localhost:8080/Project1BackEnd/EmployeeServlet/requests";
let xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = retrieveData;
xhttp.open('GET',url);
xhttp.send();
function retrieveData(){
    let dataSection = document.getElementById('data');
    dataSection.innerHTML = '';
    if(xhttp.readyState == 4 && xhttp.status == 200){
        let response = xhttp.responseText;
        response = JSON.parse(response);
        console.log(response);
        let employeeTable = document.createElement('table');
    employeeTable.id = 'employeeTable';

    let thRow = document.createElement('tr');
    let tHeaders = ['id','requesttype','userrequest',
                    'approvalstage','approvalstatus','amount',
                'reason'    ];
           for( let h of tHeaders){
               let th = document.createElement('th');
               th.innerHTML = h;
               thRow.appendChild(th);
           }     
           employeeTable.append(thRow);
           for(let employee of response){
              let tr = document.createElement('tr');
               for(let name of tHeaders){
                let td = document.createElement('td');
                let temp1 = name;
              
                let temp = employee.temp1;
                td.innerHTML = temp;
                tr.appendChild(td);
               }
               employeeTable.appendChild(tr);
            //    let tdId = document.createElement('td');
            //    tdId.innerHTML = employee.id;
            //    tr.appendChild(tdId);
           }
           dataSection.appendChild(employeeTable);
    }
}
}