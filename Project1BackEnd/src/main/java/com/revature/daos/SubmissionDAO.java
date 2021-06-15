package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.connection.JDBCConnection;
import com.revature.models.Grades;
import com.revature.models.Presentations;

public class SubmissionDAO implements Presentations, Grades{
	private Connection conn = JDBCConnection.getConnection();
	//requests has an r_id which is the user id
	//and then an id that youll want to reference for a foreign key
	

	@Override
	public void approvePresentation(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getPresentation(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void sendPresentation(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean approveGrade(int id,String reason,boolean approval) {
		String sql = "update grades set approval = ? , reason = ? where id = ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBoolean(1, approval);
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

	//the grades has a reason and approval status
	//same with the presentations
	@Override
	public boolean sendGrade(String grade,int approvalId) {
		String sql = "insert into grades values(default,?,?,'none',false);";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, grade);
			ps.setInt(2, approvalId);
			boolean success = ps.execute();
			if(success) {
				return true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public String getGrade(int id) {
		String sql = "select * from grades where id = ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String temp = rs.getString("usergrade");
				return temp;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return "no grade found";
	}
	
	

}
