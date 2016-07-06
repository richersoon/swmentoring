package com.scratchwerk.models;

import java.util.ArrayList;
import java.util.Date;

public class Student extends User {
	
	private int studentID;
	private Date dob;
	private String school;
	private int grade;
	private ArrayList tasks;
	private ArrayList reportCards;
	private ArrayList progressReports;
	private Address address;
	
	private Parent father;
	private Parent mother;
	private Parent guardian1;
	private Parent guardian2;
	
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public ArrayList getTasks() {
		return tasks;
	}
	public void setTasks(ArrayList tasks) {
		this.tasks = tasks;
	}
	public ArrayList getReportCards() {
		return reportCards;
	}
	public void setReportCards(ArrayList reportCards) {
		this.reportCards = reportCards;
	}
	public ArrayList getProgressReports() {
		return progressReports;
	}
	public void setProgressReports(ArrayList progressReports) {
		this.progressReports = progressReports;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Parent getFather() {
		return father;
	}
	public void setFather(Parent father) {
		this.father = father;
	}
	public Parent getMother() {
		return mother;
	}
	public void setMother(Parent mother) {
		this.mother = mother;
	}
	public Parent getGuardian1() {
		return guardian1;
	}
	public void setGuardian1(Parent guardian1) {
		this.guardian1 = guardian1;
	}
	public Parent getGuardian2() {
		return guardian2;
	}
	public void setGuardian2(Parent guardian2) {
		this.guardian2 = guardian2;
	}
	

	
}
