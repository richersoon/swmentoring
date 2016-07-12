package com.scratchwerk.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by richersoon on 7/12/16.
 */
public class StudentRequestDto {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String suffix;
    private String password;

    private LocalDateTime dob;
    private String school;
    private int grade;
    private ArrayList tasks;
    private ArrayList reportCards;
    private ArrayList progressReports;
    private String fatherId;

    private String motherId;
    private String guardianId1;
    private String guardianId2;

    private String number;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private Integer zip;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
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

    public String getFatherId() {
        return fatherId;
    }

    public void setFatherId(String fatherId) {
        this.fatherId = fatherId;
    }

    public String getMotherId() {
        return motherId;
    }

    public void setMotherId(String motherId) {
        this.motherId = motherId;
    }

    public String getGuardianId1() {
        return guardianId1;
    }

    public void setGuardianId1(String guardianId1) {
        this.guardianId1 = guardianId1;
    }

    public String getGuardianId2() {
        return guardianId2;
    }

    public void setGuardianId2(String guardianId2) {
        this.guardianId2 = guardianId2;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }
}
