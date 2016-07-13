package com.scratchwerk.model;

import com.scratchwerk.dto.OrganizationRequestDto;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = Organization.COLLECTION_NAME)
public class Organization {

    public static final String COLLECTION_NAME = "organizations";

    @Id
	private ObjectId id;
	private String name;

	public ObjectId getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static Organization create(final OrganizationRequestDto organizationRequestDto) {
	    Organization organization = new Organization();
        organization.id = new ObjectId();
        organization.name = organizationRequestDto.getName();

        return organization;
	}
}
