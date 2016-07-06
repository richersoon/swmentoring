package com.scratchwerk.models;

public class Mentor extends User {
	
	private int mentorID;
	private Organization org;
	
	public int getMentorID() {
		return mentorID;
	}
	public void setMentorID(int mentorID) {
		this.mentorID = mentorID;
	}
	public Organization getOrg() {
		return org;
	}
	public void setOrg(Organization org) {
		this.org = org;
	}
	
	
	

}
