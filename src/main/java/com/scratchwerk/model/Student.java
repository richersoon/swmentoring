package com.scratchwerk.model;

import com.scratchwerk.dto.StudentRequestDto;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = Student.COLLECTION_NAME)
public class Student {

    public static final String COLLECTION_NAME = "students";

    @Id
	private ObjectId id;

    private String mentorId;

	private String firstName;
	private String lastName;
	private String email;
	private String suffix;
	private String password;

	private LocalDateTime dob;
	private String school;
	private int grade;
	private List<String> tasks;
	private List<String> reportCards;
	private List<String> progressReports;
	private String fatherId;

	private String motherId;
	private String guardianId1;
	private String guardianId2;

	private Address address;

	private Integer roleId = 1;

	public ObjectId getId() {
		return id;
	}

	public String getMentorId() {
		return mentorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getSuffix() {
		return suffix;
	}

	public String getPassword() {
		return password;
	}

	public LocalDateTime getDob() {
		return dob;
	}

	public String getSchool() {
		return school;
	}

	public int getGrade() {
		return grade;
	}

	public List<String> getTasks() {
		return tasks;
	}

	public List<String> getReportCards() {
		return reportCards;
	}

	public List<String> getProgressReports() {
		return progressReports;
	}

	public String getFatherId() {
		return fatherId;
	}

	public String getMotherId() {
		return motherId;
	}

	public String getGuardianId1() {
		return guardianId1;
	}

	public String getGuardianId2() {
		return guardianId2;
	}

	public Address getAddress() {
		return address;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public static Student create(final StudentRequestDto studentRequestDto) {
        Student student = new Student();
        student.id = new ObjectId();
        student.mentorId = studentRequestDto.getMentorId();
        student.firstName = studentRequestDto.getFirstName();
        student.email = studentRequestDto.getEmail();
        student.suffix = studentRequestDto.getSuffix();
        student.password = studentRequestDto.getPassword();
        student.dob = studentRequestDto.getDob();
        student.school = studentRequestDto.getSchool();
        student.grade = studentRequestDto.getGrade();
        student.tasks = studentRequestDto.getTasks();
        student.reportCards = studentRequestDto.getReportCards();
        student.progressReports = studentRequestDto.getProgressReports();
        student.fatherId = studentRequestDto.getFatherId();
        student.motherId = studentRequestDto.getMotherId();
        student.guardianId1 = studentRequestDto.getGuardianId1();
        student.guardianId2 = studentRequestDto.getGuardianId2();

        final Address newAddress = Address.create(studentRequestDto.getNumber(), studentRequestDto.getAddress1(),
                studentRequestDto.getAddress2(), studentRequestDto.getCity(),
                studentRequestDto.getState(), studentRequestDto.getZip());
        student.address = newAddress;

        return student;
    }
}
