package com.scratchwerk.model;

import com.scratchwerk.dto.MentorRequestDto;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = Mentor.COLLECTION_NAME)
public class Mentor {

    public static final String COLLECTION_NAME = "mentors";

    @Id
    private ObjectId id;
	private String organizationId;
	private String firstName;
	private String lastName;
	private String email;
	private String suffix;
	private String password;

	private Integer roleId = 3;

    public ObjectId getId() {
        return id;
    }

    public String getOrganizationId() {
		return organizationId;
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

	public Integer getRoleId() {
		return roleId;
	}

    public static Mentor create(final MentorRequestDto mentorRequestDto) {
        Mentor mentor = new Mentor();
        mentor.id = new ObjectId();
        mentor.organizationId = mentorRequestDto.getOrganizationId();
        mentor.firstName = mentorRequestDto.getFirstName();
        mentor.lastName = mentorRequestDto.getLastName();
        mentor.email = mentorRequestDto.getEmail();
        mentor.suffix = mentorRequestDto.getSuffix();
        mentor.password = mentorRequestDto.getSuffix();

        return mentor;
    }
}
