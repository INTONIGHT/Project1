package com.revature.service;

import java.util.List;

import com.revature.daos.EmployeeDAO;
import com.revature.daos.SubmissionDAO;
import com.revature.models.Employee;
import com.revature.models.Requests;

public class DAOImpl {
EmployeeDAO edao = new EmployeeDAO();
SubmissionDAO sdao = new SubmissionDAO();

	public Employee Login(String username,String password) {
		Employee e = edao.Login(username, password);
		return e;
	}
	public boolean createRequest(String request,int userid,String requestType,double amt) {
		boolean b = edao.createRequest(request, userid, requestType, amt);
		return b;
	}
	public double getReimbursement(int id) {
		double d = edao.getReimbursement(id);
		return d;
	}
	public List<Requests> getRequests(int id){
		List<Requests> test= edao.getRequests(id);
		return test;
	}
	public Requests getRequest(int id,int r_id) {
		Requests test = edao.getRequest(id, r_id);
		return test;
	}
	public boolean approvePresentation(int id,String reason,boolean approval) {
		boolean b = sdao.approvePresentation(id, reason, approval);
		return b;
	}
	public String getPresentation(int id) {
		String s = sdao.getPresentation(id);
		return s;
	}
	public boolean sendPresentation(int id,String presentation) {
		boolean b = sdao.sendPresentation(id, presentation);
		return b;
	}
	public boolean approveGrade(int id,String reason,boolean approval) {
		boolean b = sdao.approveGrade(id, reason, approval);
		return b;
	}
	public boolean sendGrade(String grade,int approvalId) {
		boolean b = sdao.sendGrade(grade, approvalId);
		return b;
	}
	public String getGrade(int id) {
		String s = sdao.getGrade(id);
		return s;
	}
	
}
