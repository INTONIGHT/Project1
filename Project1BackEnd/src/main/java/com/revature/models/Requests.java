package com.revature.models;

public class Requests {
private int id,r_id,amount;
private String userrequest,requesttype,approvalstage,reason;
private boolean approvalstatus;


public Requests() {
	super();
}

public Requests(int id, int r_id, int amount, String userrequest, String requesttype, String approvalstage,
		String reason, boolean approvalstatus) {
	super();
	this.id = id;
	this.r_id = r_id;
	this.amount = amount;
	this.userrequest = userrequest;
	this.requesttype = requesttype;
	this.approvalstage = approvalstage;
	this.reason = reason;
	this.approvalstatus = approvalstatus;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getR_id() {
	return r_id;
}
public void setR_id(int r_id) {
	this.r_id = r_id;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public String getUserrequest() {
	return userrequest;
}
public void setUserrequest(String userrequest) {
	this.userrequest = userrequest;
}
public String getRequesttype() {
	return requesttype;
}
public void setRequesttype(String requesttype) {
	this.requesttype = requesttype;
}
public String getApprovalstage() {
	return approvalstage;
}
public void setApprovalstage(String approvalstage) {
	this.approvalstage = approvalstage;
}
public String getReason() {
	return reason;
}
public void setReason(String reason) {
	this.reason = reason;
}
public boolean isApprovalstatus() {
	return approvalstatus;
}
public void setApprovalstatus(boolean approvalstatus) {
	this.approvalstatus = approvalstatus;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + amount;
	result = prime * result + ((approvalstage == null) ? 0 : approvalstage.hashCode());
	result = prime * result + (approvalstatus ? 1231 : 1237);
	result = prime * result + id;
	result = prime * result + r_id;
	result = prime * result + ((reason == null) ? 0 : reason.hashCode());
	result = prime * result + ((requesttype == null) ? 0 : requesttype.hashCode());
	result = prime * result + ((userrequest == null) ? 0 : userrequest.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Requests other = (Requests) obj;
	if (amount != other.amount)
		return false;
	if (approvalstage == null) {
		if (other.approvalstage != null)
			return false;
	} else if (!approvalstage.equals(other.approvalstage))
		return false;
	if (approvalstatus != other.approvalstatus)
		return false;
	if (id != other.id)
		return false;
	if (r_id != other.r_id)
		return false;
	if (reason == null) {
		if (other.reason != null)
			return false;
	} else if (!reason.equals(other.reason))
		return false;
	if (requesttype == null) {
		if (other.requesttype != null)
			return false;
	} else if (!requesttype.equals(other.requesttype))
		return false;
	if (userrequest == null) {
		if (other.userrequest != null)
			return false;
	} else if (!userrequest.equals(other.userrequest))
		return false;
	return true;
}
@Override
public String toString() {
	return "Requests [id=" + id + ", r_id=" + r_id + ", amount=" + amount + ", userrequest=" + userrequest
			+ ", requesttype=" + requesttype + ", approvalstage=" + approvalstage + ", reason=" + reason
			+ ", approvalstatus=" + approvalstatus + "]";
}


}
