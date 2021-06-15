package com.revature.models;

public interface Grades {

public boolean approveGrade(int id,String reason,boolean approval);

public boolean sendGrade(String grade, int approvalId);
}
