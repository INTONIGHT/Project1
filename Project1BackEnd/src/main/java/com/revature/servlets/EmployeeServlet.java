package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.models.*;
import com.google.gson.Gson;
import com.revature.daos.EmployeeDAO;

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
	EmployeeDAO edao = new EmployeeDAO();
	private Gson gson = new Gson();
	//i might have to modify this later on im going based on class code
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String uri = request.getRequestURI();
		//System.out.println(uri);
		//for get requests 
		/**
		 * localhost 8080/EMployeeServelt/requests get allr equests
		 * if we do cats/id get a request by id.
		 *
		 */
		
		//http://localhost:8080/Project1BackEnd/EmployeeServlet
		 uri = uri.substring("/Project1BackEnd/EmployeeServlet".length());

		switch(uri) {
		case "/requests":
			//System.out.println("getting requests");
			//this is hard coded right now.
			//this might require session.
			List<Requests> requests = edao.getRequests(1);
			//System.out.println(requests);
			//add this
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.getWriter().append(gson.toJson(requests));
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
		switch(uri) {
		
		
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
		default:{
			System.out.println("default case");
		}
		}
	}
	
}
