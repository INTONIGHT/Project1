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
	public void getGrade(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void approvePresentation(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getPresentation(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void approveGrade(int id) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public boolean sendGrade(String grade,int approvalId) {
		String sql = "insert into grades values(default,?,?);";
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

	@Override
	public void sendPresentation(int id) {
		// TODO Auto-generated method stub
		
	}
	

}
