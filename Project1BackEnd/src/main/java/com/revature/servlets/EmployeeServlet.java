package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.models.*;
import com.google.gson.Gson;
import com.revature.app.Driver;
import com.revature.daos.EmployeeDAO;
import com.revature.daos.SubmissionDAO;

public class EmployeeServlet extends HttpServlet{
	class Login {
		public String username;
		public String password;
	}
	class Approve{
		public int id;
		public String reason;
		public String role;
	}
	class getRequest{
		public int user_id;
	}
	class createRequest{
		public String type;
		public int amtReq;
		public String request;
	}
	class Grade{
		public int id;
		public String reason;
		public boolean approval;
		public String grade;
	}
	class Presentation{
		public int id;
		public String reason;
		public boolean approval;
		public String presentation;
	}
	EmployeeDAO edao = new EmployeeDAO();
	SubmissionDAO sdao = new SubmissionDAO();
	private Gson gson = new Gson();
	//i might have to modify this later on im going based on class code
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String uri = request.getRequestURI();
		uri = uri.substring("/Project1BackEnd/EmployeeServlet".length());
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Content-Type", "application/json");

		switch(uri) {
		
			
			default:
				System.out.println("default case");
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String uri = request.getRequestURI();
		uri = uri.substring("/Project1BackEnd/EmployeeServlet".length());
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Content-Type", "application/json");
		switch(uri) {
		
		case "/requests":
			//getRequest info2 = this.gson.fromJson(request.getReader(),getRequest.class);
			int info2 = this.gson.fromJson(request.getReader(),Integer.class);
			//System.out.println(info2);
			//int test_id = info2;
			//System.out.println(info2);
			List<Requests> requests = edao.getRequests(info2);			
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.getWriter().append(gson.toJson(requests));
			break;
	case "/login":
		Login info = this.gson.fromJson(request.getReader(), Login.class);
		
		Employee test = edao.Login(info.username,info.password);
		
		
		response.getWriter().append(gson.toJson(test));
		break;
	case "/approve":
		Approve info1 = this.gson.fromJson(request.getReader(), Approve.class);
		boolean success = edao.approveRequest(info1.reason, info1.role, info1.id);
		System.out.println(info1.reason + info1.role+ info1.id);
		response.setHeader("Access-Control-Allow-Origin", "*");
		if(!success) {
			System.out.println("yeah");
			
		}
		response.getWriter().append("Hello there");
		break;
	case "/createRequest":
		Driver dr = new Driver();
		//ideally you want to get from session or something like that
		Employee e = new Employee(1,"Tyler","Password","Employee",1000);
		createRequest userReq = this.gson.fromJson(request.getReader(), createRequest.class);
		double amt = dr.getReimbursementAmount(e, userReq.type, userReq.amtReq, e.getRole());
		edao.createRequest(userReq.request, e.getId(), userReq.type, amt);
		break;
	case "/createGrade":
		Grade g = this.gson.fromJson(request.getReader(), Grade.class);
		System.out.println(g.grade + g.id);
		
		boolean b = sdao.sendGrade(g.grade, g.id);
		
		if(b) {
			System.out.println("yeah");
		}
		break;
	case "/approveGrade":
		//this didnt work to fix it
		int user_id = this.gson.fromJson(request.getReader(),Integer.class);
		String reason = this.gson.fromJson(request.getReader(), String.class);
		boolean approval = this.gson.fromJson(request.getReader(),boolean.class);
		
		boolean b2 = sdao.approveGrade(user_id,reason,approval);
		if(b2) {
			System.out.println("grade approved");
		}
		break;
	case "/getGrade":
		 int approval_id = this.gson.fromJson(request.getReader(),Integer.class);
		 String grade = sdao.getGrade(approval_id);
		 response.getWriter().append(gson.toJson(grade));
		 break;
	case "/createPresentation":
		Presentation p = this.gson.fromJson(request.getReader(),Presentation.class);
		boolean b1 = sdao.sendPresentation(p.presentation, p.id);
		break;
	case "/getPresentation":
		int presentation_id = this.gson.fromJson(request.getReader(), Integer.class);
		String presentation = sdao.getPresentation(presentation_id);
		response.getWriter().append(gson.toJson(presentation));
		break;
	case "/approvePresentation":
		Presentation p2 = this.gson.fromJson(request.getReader(), Presentation.class);
		boolean b3 = sdao.approvePresentation(p2.id, p2.presentation, p2.approval);
		
	default:{
			System.out.println("default case");
		}
		}
	}
	
}
