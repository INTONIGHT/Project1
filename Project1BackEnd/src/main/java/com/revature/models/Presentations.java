package com.revature.models;

public interface Presentations {

	public boolean approvePresentation(int id,String reason,boolean approval);
	public String getPresentation(int id);
	public boolean sendPresentation(int id,String presentation);
	
}
