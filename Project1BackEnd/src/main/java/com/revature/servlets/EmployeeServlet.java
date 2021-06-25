package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		public boolean approve;
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
	public static HttpSession session;
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String uri = request.getRequestURI();
		uri = uri.substring("/Project1BackEnd/EmployeeServlet".length());
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Content-Type", "application/json");
		session = request.getSession();
				switch(uri) {
		
				case"/getInfo":
					Employee user = (Employee)session.getAttribute("login");
					response.getWriter().append(gson.toJson(user));	
					//System.out.println(user + " user from getInfo");
					break;
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
		session = request.getSession();
		//System.out.println(session.getId());
		
		
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
//		session = request.getSession();
		session.setAttribute("login", test);
		//System.out.println(session.getId());
		//System.out.println(session.getAttribute("login"));
		response.getWriter().append(gson.toJson(test));
		
		break;
	case "/approve":
		Approve info1 = this.gson.fromJson(request.getReader(), Approve.class);
		
		boolean success = edao.approveRequest(info1.reason, info1.role, info1.id,info1.approve);
		
		//System.out.println(info1.reason + info1.role+ info1.id);
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		response.getWriter().append(" your response has been sent with a result of "+ !success);
		break;
	case "/createRequest":
		
		Driver dr = new Driver();
		//ideally you want to get from session or something like that
		
		Employee e = (Employee) session.getAttribute("login");
		//System.out.println(e);
		//System.out.println("employee from request");
		createRequest userReq = this.gson.fromJson(request.getReader(), createRequest.class);
		
		double amt = dr.getReimbursementAmount(e, userReq.type, userReq.amtReq, e.getRole());
		//uncomment this just to not populate my database
		//System.out.println(amt);
		edao.createRequest(userReq.request, e.getId(), userReq.type, amt);
		response.getWriter().append(amt + " has been requested");
		break;
	case "/createGrade":
		Grade g = this.gson.fromJson(request.getReader(), Grade.class);
		//System.out.println(g.grade + g.id);
		
		boolean b = sdao.sendGrade(g.grade, g.id);
		response.getWriter().append("grade "+g.grade+" has been sent with a response of "+!b);
		
		break;
	case "/approveGrade":
		//this didnt work to fix it
		Grade g1 = this.gson.fromJson(request.getReader(), Grade.class);
		
		boolean b2 = sdao.approveGrade(g1.id,g1.reason,g1.approval);
		response.getWriter().append("approveGrade was sent with a response of "+!b2);
		break;
	case "/getGrade":
		 int approval_id = this.gson.fromJson(request.getReader(),Integer.class);
		 String grade = sdao.getGrade(approval_id);
		 response.getWriter().append(gson.toJson(grade));
		 break;
	case "/createPresentation":
		Presentation p = this.gson.fromJson(request.getReader(),Presentation.class);
		boolean b1 = sdao.sendPresentation( p.id,p.presentation);
		response.getWriter().append("presentation has been sent with a response of "+!b1);
		break;
	case "/getPresentation":
		Presentation p1 = this.gson.fromJson(request.getReader(), Presentation.class);
		String presentation = sdao.getPresentation(p1.id);
		response.getWriter().append(gson.toJson(presentation));
		break;
	case "/approvePresentation":
		Presentation p2 = this.gson.fromJson(request.getReader(), Presentation.class);
		
		boolean b3 = sdao.approvePresentation(p2.id, p2.reason, p2.approval);
		response.getWriter().append("presentation has been approved with a response of "+!b3);
		break;
	default:{
			System.out.println("default case");
		}
		}
	}
	
}
