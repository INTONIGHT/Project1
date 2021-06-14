package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.connection.JDBCConnection;
import com.revature.models.Employee;

public class EmployeeDAO {
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
	public void createRequest(String request,int userid,String requestType) {
		String sql = "insert into requests values(default,?,false,?,?);";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, request);
			ps.setInt(2, userid);
			ps.setString(3, requestType);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
