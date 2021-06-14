package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.connection.JDBCConnection;
import com.revature.models.Employee;

public class EmployeeDAO {
	//change back to private
	private Connection conn = JDBCConnection.getConnection();
	//lets you log in
	public Employee Login(String username,String password) {
		String sql = "select * from employees where username = ?"
				+ "and password = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt("id"));
				e.setUsername(rs.getString("username"));
				e.setPassword(rs.getString("password"));
				e.setRole(rs.getString("role"));
				e.setBalance(rs.getDouble("reimbursementamt"));
				return e;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//request type is based on the different types.
	public boolean createRequest(String request,int userid,String requestType) {
		String sql = "insert into requests values(default,?,false,?,?,'none','empty');";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, request);
			ps.setInt(2, userid);
			ps.setString(3, requestType);
			boolean success = ps.execute();
			if(success) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean approveRequest(String reason,String role,int id) {
		String sql = "update requests set approvalstage = ?,set reason = ? where id = ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			//roles are department head direct supervisor and benco
			switch(role) {
			case "directSupervisor":
				ps.setString(1, "directSupervisor");
				break;
			case "departmentHead":
				ps.setString(1, "departmentHead");
				break;
			case "BenCo":
				ps.setString(1, "BenCo");
				break;
			default:
				ps.setString(1, "none");
				break;
			}
			ps.setString(2, reason);
			ps.setInt(3, id);
			boolean success = ps.execute();
			if(success) {
				return true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static void main(String[] args) {
		EmployeeDAO edao = new EmployeeDAO();
		//getting a lot of classnot found excpetions but it works in my driver.
		
		
		Employee e = new Employee();
		e = edao.Login("Tyler", "Password");
		System.out.println(e);
		//edao.createRequest("test", 1, "thisis a test");
	}
}
