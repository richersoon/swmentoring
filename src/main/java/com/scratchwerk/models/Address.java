package com.scratchwerk.models;

public class Address {

	private String number;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private Integer zip;
	
	public static Address create(final String number, final String address1, final String address2,
								 final String city, final String state, final Integer zip) {

		final Address address = new Address();
		address.number = number;
		address.address1 = address1;
		address.address2 = address2;
		address.city = city;
		address.state = state;
		address.zip = zip;

		return address;
	}

}
