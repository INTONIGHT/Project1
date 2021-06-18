package com.revature.app;

import com.revature.daos.EmployeeDAO;
import com.revature.models.Employee;

public class Driver {
	//public Employee ey = new Employee();
	EmployeeDAO edao = new EmployeeDAO();
	public double getReimbursementAmount(Employee e,String type,double amtReq,String role) {
		double tempvalue = 1.0;
		switch(type) {
		//make sure your options are called this.
		case "UniCourse":
			tempvalue = amtReq * .8;
			break;
			
		case "Seminars":
			tempvalue = amtReq * .6;
			break;
		case "CertPrep":
			tempvalue = amtReq * .75;
			break;
		case "Certification":
			tempvalue = amtReq;
			break;
		case "TechTraining":
			tempvalue = amtReq * .9;
			break;
		default:
			tempvalue = amtReq * .3;
			break;
		}
		//i have to create a function that grabs any pending approvals.
		//as well as awarded.
		double available = e.getBalance() - edao.getReimbursement(e.getId());
		if(tempvalue > available) {
			if(role.equals("BenCo")) {
				return tempvalue;
				
			}
			tempvalue = available;
		}
		return tempvalue;
		
	}
	
	
}
