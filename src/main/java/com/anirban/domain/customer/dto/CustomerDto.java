package com.anirban.domain.customer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonInclude;

import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.anirban.domain.customer.model.Customer;

@JsonIgnoreProperties(ignoreUnknown = true)

@JsonInclude(Include.NON_NULL)

public class CustomerDto {

	@JsonProperty("cust_id")
	public String custId;

	@JsonProperty("first_name")
	private String firstName;

	@JsonProperty("last_name")
	private String lastName;

	@JsonProperty("email")
	private String email;

	@JsonProperty("phone")
	private String phone;

	public String getCustId() {

		return custId;

	}

	public void setCustId(String custId) {

		this.custId = custId;

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

	public String getPhone() {

		return phone;

	}

	public void setPhone(String phone) {

		this.phone = phone;

	}

	public String getEmail() {

		return email;

	}

	public void setEmail(String email) {

		this.email = email;

	}

	public CustomerDto build(Customer customer) {

		this.custId = customer.getCustId();

		this.firstName = customer.getFirstName();

		this.lastName = customer.getLastName();

		this.phone = customer.getPhone();

		this.email = customer.getEmail();

		return this;

	}

}
