package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.revature.connection.JDBCConnection;
import com.revature.models.Grades;
import com.revature.models.Presentations;

public class SubmissionDAO implements Presentations, Grades{
	private Connection conn = JDBCConnection.getConnection();
	//requests has an r_id which is the user id
	//and then an id that youll want to reference for a foreign key
	

	@Override
	public boolean approvePresentation(int id,String reason,boolean approval) {
		String sql = "update presentations set approval = ?, reason = ? where id = ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBoolean(1,approval);
			ps.setString(2,reason);
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

	@Override
	public String getPresentation(int id) {
		String sql = "select * from presentations where approvals_id = ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String temp = rs.getString("userpresentation");
				return temp;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return "presentation not found";
	}
	@Override
	public boolean sendPresentation(int id,String presentation) {
		String sql = "insert into presentations values(default,?,?,'empty',false);";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, presentation);
			ps.setInt(2, id);
			boolean success = ps.execute();
			if(success) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
		
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
		//that approvals id is which request it is it will be one to one theoretically.
		String sql = "select * from grades where approvals_id = ?;";
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
	//remove this
	public boolean getGradeApproval(int id) {
		String sql = "select approval from grades where id = ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				boolean result = rs.getBoolean("approval");
				return result;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean getPresentationApproval(int id) {
		String sql = "select approval from presentations where id = ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				boolean result = rs.getBoolean("approval");
				return result;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	

}
