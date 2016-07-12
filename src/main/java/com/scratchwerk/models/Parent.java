package com.scratchwerk.models;

import com.scratchwerk.dto.ParentRequestDto;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = Parent.COLLECTION_NAME)
public class Parent {

	public static final String COLLECTION_NAME = "parents";

	@Id
	private ObjectId id;
	private String firstName;
	private String lastName;
	private String email;
	private String suffix;
	private String password;
	private Address address;

	private Integer roleId = 2;

	public ObjectId getId() {
		return id;
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

	public Address getAddress() {
		return address;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public Parent create(final ParentRequestDto parentRequestDto) {
		Parent parent = new Parent();
		parent.id = new ObjectId();
		parent.firstName = parentRequestDto.getFirstName();
		parent.lastName = parentRequestDto.getLastName();
		parent.email = parentRequestDto.getEmail();
		parent.suffix = parentRequestDto.getSuffix();
		parent.password = parentRequestDto.getPassword();

		final Address newAddress = Address.create(parentRequestDto.getNumber(), parentRequestDto.getAddress1(),
				parentRequestDto.getAddress2(), parentRequestDto.getCity(),
				parentRequestDto.getState(), parentRequestDto.getZip());
		parent.address = newAddress;

		return parent;
	}
}
