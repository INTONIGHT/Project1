package com.revature.models;

public interface Grades {
public void getGrade(int id);
public void approveGrade(int id);

public void sendGrade(String grade, int approvalId);
}
