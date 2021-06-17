package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.connection.JDBCConnection;
import com.revature.models.Employee;
import com.revature.models.Requests;

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
	public boolean createRequest(String request,int userid,String requestType,int amt) {
		String sql = "insert into requests values(default,?,false,?,?,'none','empty',?);";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, request);
			ps.setInt(2, userid);
			ps.setString(3, requestType);
			ps.setInt(4, amt);
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
	public double getReimbursement(int id) {
		String sql = "select * from requests where r_id = ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			double result = 0;
			while(rs.next()) {
				result += rs.getDouble("amount");
				
			}
			return result;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	//get the list of requests assocaited with a certain id. then returns a list of those requests
	public List<Requests> getRequests(int id) {
		String sql = "select * from requests where r_id = ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			List<Requests> temp = new ArrayList<Requests>();
			while(rs.next()) {
				Requests sample = new Requests();
				sample.setId(rs.getInt("id"));
				sample.setUserrequest(rs.getString("userrequest"));
				sample.setApprovalstatus(rs.getBoolean("approvalstatus"));
				sample.setR_id(rs.getInt("r_id"));
				sample.setRequesttype(rs.getString("requesttype"));
				sample.setApprovalstage(rs.getString("approvalstage"));
				sample.setReason(rs.getString("reason"));
				sample.setAmount(rs.getInt("amount"));
				temp.add(sample);
				
			}
			return temp;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		List<Requests> temp = new ArrayList<Requests>();
		return temp;
	}
	public Requests getRequest(int id,int r_id) {
		String sql = "select * from requests where id = ? and r_id =?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, r_id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Requests sample = new Requests();
				sample.setId(rs.getInt("id"));
				sample.setUserrequest(rs.getString("userrequest"));
				sample.setApprovalstatus(rs.getBoolean("approvalstatus"));
				sample.setR_id(rs.getInt("r_id"));
				sample.setRequesttype(rs.getString("requesttype"));
				sample.setApprovalstage(rs.getString("approvalstage"));
				sample.setReason(rs.getString("reason"));
				sample.setAmount(rs.getInt("amount"));
				return sample;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
