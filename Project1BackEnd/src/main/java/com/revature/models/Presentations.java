package com.revature.models;

public interface Presentations {

	public boolean approvePresentation(int id);
	public String getPresentation(int id);
	public boolean sendPresentation(String presentation,int id);
	
}
